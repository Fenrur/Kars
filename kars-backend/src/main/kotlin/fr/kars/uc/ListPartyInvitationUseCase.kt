package fr.kars.uc

import fr.kars.*
import java.time.Instant

interface ListPartyInvitationUseCase {

    data class Element(
        val partyId: PartyId,
        val type: PartyType,
        val price: PartyPrice?,
        val name: PartyName,
        val startAt: Instant,
        val endAt: Instant?,
        val maximumPlace: Int,
        val cityId: Int,
        val ownerPartyProfileId: ProfileId,
        val description: PartyDescription?,
        val partyEventType: PartyEventType,
    )
}