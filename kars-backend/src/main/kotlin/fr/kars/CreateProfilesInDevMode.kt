package fr.kars

import io.quarkus.runtime.LaunchMode
import io.quarkus.runtime.StartupEvent
import jakarta.enterprise.event.Observes
import org.eclipse.microprofile.config.inject.ConfigProperty

class CreateProfilesInDevMode {

    companion object {
        private val logger = Logger(CreateProfilesInDevMode::class.java.name)
    }
    
    fun onStart(
        @Observes event: StartupEvent,
        @ConfigProperty(name = "quarkus.keycloak.devservices.port") port: Int,
        @ConfigProperty(name = "quarkus.keycloak.devservices.realm-name") realmName: String?
    ) {
        val realmName = realmName ?: "quarkus"
        
        if (LaunchMode.current() != LaunchMode.DEVELOPMENT) return
        
        logger.info { "Port: $port" }
        logger.info { "RealmName: $realmName" }
        
//        val keycloak = Keycloak.getInstance(
//            "http://localhost:$port",
//            
//        )
    }
}