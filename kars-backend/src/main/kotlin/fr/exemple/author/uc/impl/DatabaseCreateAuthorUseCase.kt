package fr.exemple.author.uc.impl

import fr.exemple.author.AuthorId
import fr.exemple.author.uc.CreateAuthorUseCase
import fr.livio.jooq.tables.references.AUTHORS
import jakarta.enterprise.context.ApplicationScoped
import org.jooq.DSLContext

@ApplicationScoped
class DatabaseCreateAuthorUseCase(private val dslContext: DSLContext) : CreateAuthorUseCase {
    
    override fun create(firstName: String, lastName: String): AuthorId {
        val id = dslContext
            .insertInto(AUTHORS, AUTHORS.FIRST_NAME, AUTHORS.LAST_NAME)
            .values(firstName, lastName)
            .returningResult(AUTHORS.ID)
            .fetchOne()
            ?.value1()
        
        return id ?: throw IllegalStateException("Failed to create author")
    }
}