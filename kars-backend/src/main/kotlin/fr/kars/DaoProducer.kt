package fr.kars

import fr.kars.jooq.tables.daos.AuthorsDao
import fr.kars.jooq.tables.daos.BooksDao
import jakarta.enterprise.inject.Produces
import org.jooq.Configuration

class DaoProducer {
    
    @Produces
    fun authorsDao(conf: Configuration) = AuthorsDao(conf)

    @Produces
    fun booksDao(conf: Configuration) = BooksDao(conf)
}