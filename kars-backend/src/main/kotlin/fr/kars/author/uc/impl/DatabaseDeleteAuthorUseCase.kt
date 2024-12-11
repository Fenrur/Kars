package fr.kars.author.uc.impl

import fr.kars.author.AuthorId
import fr.kars.author.uc.DeleteAuthorUseCase
import fr.kars.jooq.tables.daos.AuthorsDao
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class DatabaseDeleteAuthorUseCase(private val authorsDao: AuthorsDao) : DeleteAuthorUseCase {
    
    override fun invoke(authorId: AuthorId) {
        authorsDao.deleteById(authorId)
    }
}