package fr.kars.author.uc.impl

import fr.kars.author.AuthorId
import fr.kars.author.uc.CreateAuthorUseCase
import fr.kars.jooq.tables.references.AUTHORS
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