package fr.kars.author.uc.impl

import fr.kars.author.Author
import fr.kars.author.AuthorId
import fr.kars.author.uc.UpdateAuthorUseCase
import fr.kars.jooq.tables.references.AUTHORS
import jakarta.enterprise.context.ApplicationScoped
import org.jooq.DSLContext
import org.jooq.Field

@ApplicationScoped
class DatabaseUpdateAuthorUseCase(
    private val dslContext: DSLContext
) : UpdateAuthorUseCase {

    override fun update(authorId: AuthorId, firstName: String?, lastName: String?): Author {
        val query = dslContext.update(AUTHORS)
        val valuesToUpdate = HashMap<Field<*>, Any>(2)

        if (firstName != null) {
            valuesToUpdate[AUTHORS.FIRST_NAME] = firstName
        }
        if (lastName != null) {
            valuesToUpdate[AUTHORS.LAST_NAME] = lastName
        }

        if (valuesToUpdate.isNotEmpty()) {
            val author = query.set(valuesToUpdate).where(AUTHORS.ID.eq(authorId)).returning().fetchOne()

            author ?: throw Exception("Failed to update author")
            return Author(author.id!!, author.firstName, author.lastName)
        } else {
            val author = dslContext.selectFrom(AUTHORS).where(AUTHORS.ID.eq(authorId)).fetchOne()

            author ?: throw Exception("Failed to update author")
            return Author(author.id!!, author.firstName, author.lastName)
        }
    }
}