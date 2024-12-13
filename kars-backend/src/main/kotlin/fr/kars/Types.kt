package fr.kars

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