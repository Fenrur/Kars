package fr.kars.author.uc.impl

import fr.kars.author.Author
import fr.kars.author.AuthorId
import fr.kars.author.uc.FindByIdAuthorUseCase
import fr.kars.jooq.tables.daos.AuthorsDao
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class DatabaseFindByIdAuthorUseCase(private val authorsDao: AuthorsDao) : FindByIdAuthorUseCase {
    
    override fun invoke(authorId: AuthorId): Author? {
        val author = authorsDao.findById(authorId)
        
        return author?.let {
            Author(it.id!!, it.firstName, it.lastName)
        }
    }
    
}