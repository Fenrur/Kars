package fr.kars

import io.quarkus.runtime.LaunchMode
import io.quarkus.runtime.StartupEvent
import jakarta.enterprise.event.Observes
import org.eclipse.microprofile.config.inject.ConfigProperty
import java.util.Optional

class CreateProfilesInDevMode {

    companion object {
        private val logger = Logger(CreateProfilesInDevMode::class.java.name)
    }
    
    fun onStart(
        @Observes event: StartupEvent,
        @ConfigProperty(name = "quarkus.keycloak.devservices.port") port: Int,
        @ConfigProperty(name = "quarkus.keycloak.devservices.realm-name") realmName: Optional<String>
    ) {
        val realmName = realmName.orElse("quarkus")
        
        if (LaunchMode.current() != LaunchMode.DEVELOPMENT) return
        
        logger.info { "Port: $port" }
        logger.info { "RealmName: $realmName" }
        
        
    }
}