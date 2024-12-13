package fr.kars.uc.impl

import fr.kars.PartyId
import fr.kars.ProfileId
import fr.kars.jooq.tables.references.INVITATION_PARTY
import fr.kars.uc.RemovePartyInvitationUseCase
import jakarta.enterprise.context.ApplicationScoped
import org.jooq.DSLContext

@ApplicationScoped
class DatabaseRemovePartyInvitationUseCase(private val ctx: DSLContext) : RemovePartyInvitationUseCase {
    
    override fun invoke(partyId: PartyId, invitedProfileId: ProfileId) {
        ctx
            .deleteFrom(INVITATION_PARTY)
            .where(INVITATION_PARTY.PARTY_ID.eq(partyId).and(INVITATION_PARTY.INVITED_PROFILE_ID.eq(invitedProfileId)))
            .execute()
    }
}