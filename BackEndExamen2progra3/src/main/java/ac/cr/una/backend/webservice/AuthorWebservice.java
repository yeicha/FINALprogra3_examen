package ac.cr.una.backend.webservice;

import ac.cr.una.backend.DAO.AuthorContactDAO;
import ac.cr.una.backend.DAO.AuthorContactDAOImpl;
import ac.cr.una.backend.DAO.AuthorDAO;
import ac.cr.una.backend.DAO.AuthorDAOImpl;
import ac.cr.una.backend.model.Author;
import ac.cr.una.backend.model.AuthorContact;
import ac.cr.una.backend.service.AuthorService;
import ac.cr.una.backend.service.AuthorServiceImpl;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Jason
 */
@Path("authors")
public class AuthorWebservice
{

    private AuthorDAO authorDAO;
    private AuthorContactDAO authorContactDAO;
    private AuthorService authorService;

    @Context
    private UriInfo context;

    public AuthorWebservice()
    {
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AuthorContact> getAllAuthors()
    {
        List<AuthorContact> AuthorContactList = null;
        authorContactDAO = new AuthorContactDAOImpl();
        authorService = new AuthorServiceImpl(authorDAO);

        AuthorContactList = authorService.findAll();

        return AuthorContactList;
    }

    @GET
    @Path("/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public Author getAuthorByName(@PathParam("nombre") String nombre)
    {
        Author author = null;
        authorDAO = new AuthorDAOImpl();
        authorService = new AuthorServiceImpl(authorDAO);

        author = authorService.findByName(nombre);

        return author;
    }

    @DELETE
    @Path("/")
    public boolean deleteAll()
    {
        boolean result;
        authorDAO = new AuthorDAOImpl();
        authorService = new AuthorServiceImpl(authorDAO);

        result = authorService.deleteAll();

        return result;
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public AuthorContact createAuthor(AuthorContact authorContact)
    {

        authorDAO = new AuthorDAOImpl();
        authorService = new AuthorServiceImpl(authorDAO);

        authorContact = authorService.save(authorContact);

        return authorContact;
    }
}
