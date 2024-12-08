package fr.exemple

import io.agroal.api.AgroalDataSource
import jakarta.enterprise.inject.Produces
import org.jooq.conf.RenderNameCase
import org.jooq.conf.RenderQuotedNames
import org.jooq.conf.Settings
import org.jooq.impl.DefaultConfiguration

class JooqConfigurationProducer() {

    @Produces
    fun getConfiguration(dataSource: AgroalDataSource) = DefaultConfiguration()
        .set(dataSource)
        .set(
            Settings()
                .withExecuteLogging(true)
                .withRenderFormatted(true)
                .withRenderCatalog(false)
                .withRenderSchema(false)
                .withMaxRows(Integer.MAX_VALUE)
                .withRenderQuotedNames(RenderQuotedNames.EXPLICIT_DEFAULT_UNQUOTED)
                .withRenderNameCase(RenderNameCase.LOWER_IF_UNQUOTED)
        )
    
}