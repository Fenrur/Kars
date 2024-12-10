package fr.exemple.author.uc

import fr.exemple.author.AuthorId

interface CreateAuthorUseCase {
    fun create(firstName: String, lastName: String): AuthorId
}