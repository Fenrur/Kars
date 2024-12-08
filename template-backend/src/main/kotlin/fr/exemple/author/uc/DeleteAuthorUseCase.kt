package fr.exemple.author.uc

import fr.exemple.author.AuthorId

interface DeleteAuthorUseCase {
    fun delete(authorId: AuthorId)
}