package fr.exemple

import jakarta.enterprise.context.RequestScoped
import jakarta.enterprise.inject.Produces
import org.jooq.Configuration
import org.jooq.DSLContext
import org.jooq.impl.DSL

class DslContextProducer {

    @Produces
    @RequestScoped
    fun getDslContext(configuration: Configuration) = DSL.using(configuration)
}