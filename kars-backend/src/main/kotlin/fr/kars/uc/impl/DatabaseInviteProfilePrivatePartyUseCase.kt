package fr.kars.uc.impl

import fr.kars.PartyId
import fr.kars.ProfileId
import fr.kars.jooq.enums.PartyEventType
import fr.kars.jooq.tables.daos.PartyDao
import fr.kars.jooq.tables.references.INVITATION_PARTY
import fr.kars.transactional
import fr.kars.uc.InviteProfilePrivatePartyUseCase
import jakarta.enterprise.context.ApplicationScoped
import org.jooq.DSLContext

@ApplicationScoped
class DatabaseInviteProfilePrivatePartyUseCase(
    private val ctx: DSLContext,
    private val partyDao: PartyDao,
) : InviteProfilePrivatePartyUseCase {

    class DatabaseInviteProfilePrivatePartyUseCaseException(message: String) : Exception(message)

    override fun invoke(
        partyId: PartyId,
        invitedProfileId: ProfileId,
    ): InviteProfilePrivatePartyUseCase.Result = ctx.transactional {
        val party = partyDao.findById(partyId)

        party ?: return@transactional InviteProfilePrivatePartyUseCase.PartyNotFound;

        if (party.partyEventType == PartyEventType.public) return@transactional InviteProfilePrivatePartyUseCase.PartyIsPublic

        if (party.ownerProfileId == invitedProfileId) return@transactional InviteProfilePrivatePartyUseCase.CannotInviteOwner
        
        ctx.insertInto(INVITATION_PARTY, INVITATION_PARTY.PARTY_ID, INVITATION_PARTY.INVITED_PROFILE_ID)
            .values(partyId, invitedProfileId)
            .execute()

        return@transactional InviteProfilePrivatePartyUseCase.Success
    }
}