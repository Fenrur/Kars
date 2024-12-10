package fr.exemple.author.uc.impl

import fr.exemple.author.AuthorId
import fr.exemple.author.uc.DeleteAuthorUseCase
import fr.livio.jooq.tables.daos.AuthorsDao
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class DatabaseDeleteAuthorUseCase(private val authorsDao: AuthorsDao) : DeleteAuthorUseCase {
    
    override fun delete(authorId: AuthorId) {
        authorsDao.deleteById(authorId)
    }
}