package fr.kars.author.uc.impl

import fr.kars.author.Author
import fr.kars.author.uc.FindAllAuthorUseCase
import fr.kars.jooq.tables.daos.AuthorsDao
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class DatabaseFindAllAuthorUseCase(private val authorsDao: AuthorsDao) : FindAllAuthorUseCase {
    
    override fun invoke(): List<Author> {
        return authorsDao.findAll().map {
            Author(it.id!!, it.firstName, it.lastName)
        }
    }
}