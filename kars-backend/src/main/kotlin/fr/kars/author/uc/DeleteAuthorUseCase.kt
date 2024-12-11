package fr.kars.author.uc

import fr.kars.author.AuthorId

interface DeleteAuthorUseCase {
    operator fun invoke(authorId: AuthorId)
}