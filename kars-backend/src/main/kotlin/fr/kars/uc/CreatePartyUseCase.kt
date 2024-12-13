package fr.kars.uc

import fr.kars.CityId
import fr.kars.PartyDescription
import fr.kars.PartyEventType
import fr.kars.PartyName
import fr.kars.PartyPrice
import fr.kars.PartyType
import fr.kars.ProfileId
import java.time.Instant

interface CreatePartyUseCase {
    
    operator fun invoke(
        type: PartyType,
        price: PartyPrice?,
        name: PartyName,
        startAt: Instant,
        maximumPlace: Int,
        cityId: CityId,
        ownerProfileId: ProfileId,
        description: PartyDescription,
        eventType: PartyEventType
    ): CityId
}