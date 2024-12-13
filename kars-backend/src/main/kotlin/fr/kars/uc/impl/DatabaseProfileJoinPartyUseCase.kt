package fr.kars.uc.impl

import fr.kars.PartyId
import fr.kars.ProfileId
import fr.kars.jooq.enums.PartyEventType
import fr.kars.jooq.tables.daos.PartyDao
import fr.kars.jooq.tables.references.ATTEND_PARTY
import fr.kars.jooq.tables.references.INVITATION_PARTY
import fr.kars.jooq.tables.references.PARTY
import fr.kars.transactional
import fr.kars.uc.ProfileJoinPartyUseCase
import org.jooq.DSLContext
import org.jooq.impl.DSL.field
import org.jooq.impl.DSL.selectCount

class DatabaseProfileJoinPartyUseCase(private val ctx: DSLContext) : ProfileJoinPartyUseCase {

    override fun invoke(
        profileId: ProfileId,
        partyId: PartyId,
    ): ProfileJoinPartyUseCase.Result = ctx.transactional {
        val a = field(
            selectCount()
                .from(ATTEND_PARTY)
                .where(ATTEND_PARTY.ATTEND_PROFILE_ID.eq(profileId)
                    .and(ATTEND_PARTY.PARTY_ID.eq(partyId)))
        ).`as`("alreadyAttendCount")
        
        val record = ctx.select(
            PARTY.PARTY_ID,
            PARTY.PARTY_EVENT_TYPE,
            field(
                selectCount()
                    .from(ATTEND_PARTY)
                    .where(ATTEND_PARTY.ATTEND_PROFILE_ID.eq(profileId)
                        .and(ATTEND_PARTY.PARTY_ID.eq(partyId)))
            ).`as`("alreadyAttendCount"),
            field(
                selectCount()
                    .from(INVITATION_PARTY)
                    .where(INVITATION_PARTY.INVITED_PROFILE_ID.eq(profileId)
                        .and(INVITATION_PARTY.PARTY_ID.eq(partyId)))
            ).`as`("isInvitedCount"),
            PARTY.MAXIMUM_PLACE,
            field(
                selectCount()
                    .from(ATTEND_PARTY)
                    .where(ATTEND_PARTY.PARTY_ID.eq(partyId))
            ).`as`("participantCount")
        )
            .from(PARTY)
            .where(PARTY.PARTY_ID.eq(partyId))
            .fetchOne()

        record ?: return@transactional ProfileJoinPartyUseCase.PartyDoesntExist

        val (foundPartyId, foundPartyEventType, alreadyAttendCount, isInvitedCount, maximumPartyPlaces, participantCount) = record

        if (foundPartyId == null || foundPartyEventType == null || maximumPartyPlaces == null || participantCount == null) {
            return@transactional ProfileJoinPartyUseCase.PartyDoesntExist
        }

        val alreadyAttend = alreadyAttendCount > 0
        val isInvited = isInvitedCount > 0

        if (alreadyAttend) {
            return@transactional ProfileJoinPartyUseCase.AlreadyAttend
        }

        if (foundPartyEventType == PartyEventType.private && !isInvited) {
            return@transactional ProfileJoinPartyUseCase.ProfileNotInvited
        }

        if (participantCount >= maximumPartyPlaces) {
            return@transactional ProfileJoinPartyUseCase.MaximumPlaceReached
        }

        ctx.insertInto(ATTEND_PARTY, ATTEND_PARTY.ATTEND_PROFILE_ID, ATTEND_PARTY.PARTY_ID)
            .values(profileId, partyId)
            .execute()

        return@transactional ProfileJoinPartyUseCase.Success
    }
}