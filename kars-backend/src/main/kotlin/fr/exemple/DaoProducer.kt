package fr.exemple

import fr.livio.jooq.tables.daos.AuthorsDao
import fr.livio.jooq.tables.daos.BooksDao
import jakarta.enterprise.inject.Produces
import org.jooq.Configuration

class DaoProducer {
    
    @Produces
    fun authorsDao(conf: Configuration) = AuthorsDao(conf)

    @Produces
    fun booksDao(conf: Configuration) = BooksDao(conf)
}