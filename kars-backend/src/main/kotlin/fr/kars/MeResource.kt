package fr.kars

import io.quarkus.oidc.runtime.OidcJwtCallerPrincipal
import io.quarkus.security.identity.IdentityProvider
import io.quarkus.security.identity.SecurityIdentity
import io.smallrye.common.annotation.RunOnVirtualThread
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import org.eclipse.microprofile.openapi.annotations.tags.Tag

@Path("/me")
@Tag(name = "MeResource", description = "Describe me")
@RunOnVirtualThread
class MeResource {
    
    companion object {
        private val logger = Logger(MeResource::class.java.name)
    }
    
}