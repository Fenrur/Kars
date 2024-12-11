package fr.kars

import jakarta.enterprise.context.RequestScoped
import jakarta.enterprise.inject.Produces
import org.jooq.Configuration
import org.jooq.impl.DSL

class DslContextProducer {

    @Produces
    @RequestScoped
    fun getDslContext(configuration: Configuration) = DSL.using(configuration)
}