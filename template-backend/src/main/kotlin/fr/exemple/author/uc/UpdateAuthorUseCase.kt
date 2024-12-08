package fr.exemple.author.uc

import fr.exemple.author.Author
import fr.exemple.author.AuthorId

interface UpdateAuthorUseCase {
    fun update(authorId: AuthorId, firstName: String?, lastName: String?): Author
}