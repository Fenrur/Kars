package fr.kars.author.uc

import fr.kars.author.AuthorId

interface DeleteAuthorUseCase {
    fun delete(authorId: AuthorId)
}