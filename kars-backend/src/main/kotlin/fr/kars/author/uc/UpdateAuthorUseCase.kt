package fr.kars.author.uc

import fr.kars.author.Author
import fr.kars.author.AuthorId

interface UpdateAuthorUseCase {
    operator fun invoke(authorId: AuthorId, firstName: String?, lastName: String?): Author
}