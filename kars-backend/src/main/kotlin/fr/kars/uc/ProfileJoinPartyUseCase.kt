package fr.kars.uc

import fr.kars.PartyId
import fr.kars.ProfileId

interface ProfileJoinPartyUseCase {

    sealed interface Result

    object AlreadyAttend : Result
    object PartyDoesntExist : Result
    object ProfileNotInvited : Result
    object MaximumPlaceReached : Result
    object Success : Result

    fun invoke(profileId: ProfileId, partyId: PartyId): Result
}