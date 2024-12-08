package fr.exemple.author.uc

import fr.exemple.author.Author
import fr.exemple.author.AuthorId

interface FindByIdAuthorUseCase {
    fun findById(authorId: AuthorId): Author?
}