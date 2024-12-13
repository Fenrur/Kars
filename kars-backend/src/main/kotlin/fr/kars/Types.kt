package fr.kars

import org.jooq.SelectConditionStep

enum class Role {
    User,
    Admin
}

typealias PartyId = Int
typealias PartyType = String
typealias PartyPrice = Double
typealias PartyName = String
typealias PartyDescription = String
enum class PartyEventType {
    Public,
    Private
}

typealias CityId = Int

typealias ProfileId = Int

typealias ProfilePartyEvaluationRate = Short
typealias ProfilePartyEvaluationComment = String

data class Pagination(
    val pageIndex: Int,
    val pageSize: Int
)

data class PaginatedList<T>(
    val items: List<T>,
    val pageIndex: Int,
    val pageSize: Int,
    val totalPages: Int,
    val totalItems: Int
) {
    
}