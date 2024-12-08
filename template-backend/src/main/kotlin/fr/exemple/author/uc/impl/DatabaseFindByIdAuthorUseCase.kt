package fr.exemple.author.uc.impl

import fr.exemple.author.Author
import fr.exemple.author.AuthorId
import fr.exemple.author.uc.FindByIdAuthorUseCase
import fr.livio.jooq.tables.daos.AuthorsDao
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class DatabaseFindByIdAuthorUseCase(private val authorsDao: AuthorsDao) : FindByIdAuthorUseCase {
    
    override fun findById(authorId: AuthorId): Author? {
        val author = authorsDao.findById(authorId)
        
        return author?.let {
            Author(
                id = it.id!!,
                firstName = it.firstName,
                lastName = it.lastName
            )
        }
    }
    
}