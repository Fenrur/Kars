package fr.kars.uc.impl

import fr.kars.PaginatedList
import fr.kars.Pagination
import fr.kars.ProfileId
import fr.kars.jooq.enums.PartyEventType
import fr.kars.jooq.tables.references.INVITATION_PARTY
import fr.kars.jooq.tables.references.PARTY
import fr.kars.toDomain
import fr.kars.uc.ListPartyInvitationUseCase
import org.jooq.DSLContext
import java.time.Clock
import java.time.LocalDateTime

class DatabaseListPartyInvitationUseCase(private val ctx: DSLContext) : ListPartyInvitationUseCase {
    
    fun invoke(profileId: ProfileId, pagination: Pagination): PaginatedList<ListPartyInvitationUseCase.Element> {
        val query = ctx
            .select(
                INVITATION_PARTY.INVITED_PROFILE_ID,
                INVITATION_PARTY.PARTY_ID,
                PARTY.TYPE,
                PARTY.PRICE,
                PARTY.NAME,
                PARTY.START_AT,
                PARTY.END_AT,
                PARTY.MAXIMUM_PLACE,
                PARTY.CITY_ID,
                PARTY.OWNER_PROFILE_ID,
                PARTY.DESCRIPTION,
                PARTY.PARTY_EVENT_TYPE
            )
            .from(INVITATION_PARTY)
            .join(PARTY).on(INVITATION_PARTY.PARTY_ID.eq(PARTY.PARTY_ID))
            .where(INVITATION_PARTY.INVITED_PROFILE_ID.eq(profileId))
        
        val totalItems = query.count()
        val totalPages = (totalItems / pagination.pageSize) + 1
        
        val elements = query
            .offset(pagination.pageSize * pagination.pageIndex)
            .limit(pagination.pageSize)
            .fetch()
            .map { (invitedProfileId, partyId, type, price, name, startAt, endAt, maximumPlace, cityId, ownerProfileId, description, partyEventType ) 
                -> toElement(invitedProfileId, partyId, type, price, name, startAt, endAt, maximumPlace, cityId, ownerProfileId, description, partyEventType, ) }
        
        return PaginatedList(
            items = elements,
            pageIndex = pagination.pageIndex,
            pageSize = pagination.pageSize,
            totalPages = totalPages,
            totalItems = totalItems
        )
    }

    fun requireNonNull(vararg elements: Any?, message: String = "One or more elements are null") {
        if (elements.any { it == null }) {
            throw IllegalArgumentException(message)
        }
    }
    
    fun toElement(
        invitedProfileId: Int?,
        partyId: Int?,
        type: String?,
        price: Double?,
        name: String?,
        startAt: LocalDateTime?,
        endAt: LocalDateTime?,
        maximumPlace: Int?,
        cityId: Int?,
        ownerProfileId: Int?,
        description: String?,
        partyEventType: PartyEventType?
    ): ListPartyInvitationUseCase.Element {
        invitedProfileId!!
        partyId!!
        type!!
        name!!
        startAt!!
        maximumPlace!!
        cityId!!
        ownerProfileId!!
        partyEventType!!
        
        return ListPartyInvitationUseCase.Element(
            partyId = partyId,
            type = type,
            price = price,
            name = name,
            startAt = startAt.toInstant(Clock.systemUTC().zone.rules.getOffset(startAt)),
            endAt = endAt?.toInstant(Clock.systemUTC().zone.rules.getOffset(endAt)),
            maximumPlace = maximumPlace,
            cityId = cityId,
            ownerPartyProfileId = ownerProfileId,
            description = description,
            partyEventType = partyEventType.toDomain()
        )
    }
}