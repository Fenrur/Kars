package fr.kars

import io.smallrye.common.annotation.RunOnVirtualThread
import jakarta.annotation.security.RolesAllowed
import jakarta.ws.rs.DELETE
import jakarta.ws.rs.GET
import jakarta.ws.rs.PATCH
import jakarta.ws.rs.POST
import jakarta.ws.rs.PUT
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import org.eclipse.microprofile.openapi.annotations.tags.Tag

@Path("/hello")
@Tag(name = "HelloResource", description = "Resource to test REST verbs")
@RunOnVirtualThread
class HelloResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun helloGet(): String = "Hello from Quarkus REST with GET verb"

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    fun helloPost(): String = "Hello from Quarkus REST with POST verb"

    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    fun helloPut(): String = "Hello from Quarkus REST with PUT verb"

    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    fun helloDelete(): String = "Hello from Quarkus REST with DELETE verb"

    @PATCH
    @Produces(MediaType.TEXT_PLAIN)
    fun helloPatch(): String = "Hello from Quarkus REST with PATCH verb"
}