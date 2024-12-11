package fr.kars.author

typealias AuthorId = Int

data class Author(
    val id: AuthorId,
    val firstName: String,
    val lastName: String
)