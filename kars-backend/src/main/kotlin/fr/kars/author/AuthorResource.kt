package fr.kars.author

import fr.kars.author.uc.CreateAuthorUseCase
import fr.kars.author.uc.DeleteAuthorUseCase
import fr.kars.author.uc.FindAllAuthorUseCase
import fr.kars.author.uc.FindByIdAuthorUseCase
import fr.kars.author.uc.UpdateAuthorUseCase
import io.smallrye.common.annotation.RunOnVirtualThread
import jakarta.ws.rs.Consumes
import jakarta.ws.rs.DELETE
import jakarta.ws.rs.GET
import jakarta.ws.rs.PATCH
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import org.eclipse.microprofile.openapi.annotations.tags.Tag
import org.jboss.resteasy.reactive.ResponseStatus

@Path("/author")
@RunOnVirtualThread
@Tag(name = "AuthorResource")
class AuthorResource(
    private val createAuthorUseCase: CreateAuthorUseCase,
    private val deleteAuthorUseCase: DeleteAuthorUseCase,
    private val findAllAuthorUseCase: FindAllAuthorUseCase,
    private val findByIdAuthorUseCase: FindByIdAuthorUseCase,
    private val updateAuthorUseCase: UpdateAuthorUseCase
) {

    data class GetAuthorResponseBody(val id: Int, val firstName: String, val lastName: String)
    
    @GET
    @ResponseStatus(200)
    @Produces(MediaType.APPLICATION_JSON)
    fun getAuthors(): List<GetAuthorResponseBody> = findAllAuthorUseCase()
        .map { GetAuthorResponseBody(it.id, it.firstName, it.lastName) }

    @GET
    @ResponseStatus(200)
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    fun getAuthor(@PathParam("id") id: Int): GetAuthorResponseBody {
        val author = findByIdAuthorUseCase(id)
        author ?: throw AuthorResourceException("Author not found")
        
        return GetAuthorResponseBody(author.id, author.firstName, author.lastName)
    }
    
    data class CreateAuthorRequestBody(val firstName: String, val lastName: String)
    
    @POST
    @ResponseStatus(201)
    @Consumes(MediaType.APPLICATION_JSON)
    fun createAuthor(body: CreateAuthorRequestBody) = createAuthorUseCase(body.firstName, body.lastName)

    data class UpdateAuthorRequestBody(val firstName: String?, val lastName: String?)
    data class UpdateAuthorResponseBody(val id: Int, val firstName: String, val lastName: String)
    
    @PATCH
    @ResponseStatus(200)
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    fun updateAuthor(@PathParam("id") id: Int, body: UpdateAuthorRequestBody): UpdateAuthorResponseBody {
        var author = updateAuthorUseCase(id, body.firstName, body.lastName)
        return UpdateAuthorResponseBody(author.id, author.firstName, author.lastName)
    }

    @DELETE
    @ResponseStatus(204)
    @Path("/{id}")
    fun deleteAuthor(@PathParam("id") id: Int) = deleteAuthorUseCase(id)
    
}