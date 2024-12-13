package fr.kars.uc

import fr.kars.PartyId
import fr.kars.ProfileId

interface InviteProfilePrivatePartyUseCase {
    
    sealed interface Result
    
    object PartyNotFound : Result
    object PartyIsPublic : Result
    object Success : Result
    
    operator fun invoke(partyId: PartyId, invitedProfileId: ProfileId): Result
}