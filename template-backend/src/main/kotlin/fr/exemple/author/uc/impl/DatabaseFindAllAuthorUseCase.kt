package fr.exemple.author.uc.impl

import fr.exemple.author.Author
import fr.exemple.author.uc.FindAllAuthorUseCase
import fr.livio.jooq.tables.daos.AuthorsDao
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class DatabaseFindAllAuthorUseCase(private val authorsDao: AuthorsDao) : FindAllAuthorUseCase {
    
    override fun findAll(): List<Author> {
        return authorsDao.findAll().map {
            Author(
                id = it.id!!,
                firstName = it.firstName,
                lastName = it.lastName
            )
        }
    }
}