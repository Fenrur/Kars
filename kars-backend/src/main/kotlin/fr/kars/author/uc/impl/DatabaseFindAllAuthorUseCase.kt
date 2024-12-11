package fr.kars.author.uc.impl

import fr.kars.author.Author
import fr.kars.author.uc.FindAllAuthorUseCase
import fr.kars.jooq.tables.daos.AuthorsDao
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