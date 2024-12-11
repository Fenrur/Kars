package fr.kars.author.uc

import fr.kars.author.AuthorId

interface CreateAuthorUseCase {
    operator fun invoke(firstName: String, lastName: String): AuthorId
}