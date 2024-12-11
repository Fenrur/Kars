package fr.kars.author.uc

import fr.kars.author.AuthorId

interface CreateAuthorUseCase {
    fun create(firstName: String, lastName: String): AuthorId
}