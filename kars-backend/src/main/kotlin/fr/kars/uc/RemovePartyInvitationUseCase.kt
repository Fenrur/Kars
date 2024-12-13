package fr.kars.uc

import fr.kars.PartyId
import fr.kars.ProfileId

interface RemovePartyInvitationUseCase {

    operator fun invoke(partyId: PartyId, invitedProfileId: ProfileId)
}