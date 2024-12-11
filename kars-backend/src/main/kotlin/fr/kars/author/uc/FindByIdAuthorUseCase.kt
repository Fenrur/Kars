package fr.kars.author.uc

import fr.kars.author.Author
import fr.kars.author.AuthorId

interface FindByIdAuthorUseCase {
    fun findById(authorId: AuthorId): Author?
}