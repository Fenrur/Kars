package fr.kars


typealias UserId = Int

class Password(private val value: String)

class HashedPassword(private val value: String)

enum class Role {
    User,
    Admin
}