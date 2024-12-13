package fr.kars.uc.impl

import fr.kars.CityId
import fr.kars.PartyDescription
import fr.kars.PartyEventType
import fr.kars.PartyName
import fr.kars.PartyPrice
import fr.kars.PartyType
import fr.kars.ProfileId
import fr.kars.jooq.tables.references.PARTY
import fr.kars.toJooq
import fr.kars.uc.CreatePartyUseCase
import jakarta.enterprise.context.ApplicationScoped
import org.jooq.DSLContext
import java.time.Clock
import java.time.Instant
import java.time.LocalDateTime

@ApplicationScoped
class DatabaseCreatePartyUseCase(private val ctx: DSLContext) : CreatePartyUseCase {
    
    class DatabaseCreatePartyUseCaseException(message: String) : Exception(message)
    
    override fun invoke(
        type: PartyType,
        price: PartyPrice?,
        name: PartyName,
        startAt: Instant,
        maximumPlace: Int,
        cityId: CityId,
        ownerProfileId: ProfileId,
        description: PartyDescription,
        eventType: PartyEventType
    ): CityId {
        val dbStartAt = LocalDateTime.ofInstant(startAt, Clock.systemUTC().zone)
        
        val cityId: CityId? = ctx
            .insertInto(PARTY, PARTY.TYPE, PARTY.PRICE, PARTY.NAME, PARTY.START_AT, PARTY.MAXIMUM_PLACE, PARTY.CITY_ID, PARTY.OWNER_PROFILE_ID, PARTY.DESCRIPTION, PARTY.PARTY_EVENT_TYPE)
            .values(type, price, name, dbStartAt, maximumPlace, cityId, ownerProfileId, description, eventType.toJooq())
            .returningResult(PARTY.PARTY_ID)
            .fetchOne()
            ?.value1()
        
        return cityId ?: throw DatabaseCreatePartyUseCaseException("Failed to create party")
    }

}