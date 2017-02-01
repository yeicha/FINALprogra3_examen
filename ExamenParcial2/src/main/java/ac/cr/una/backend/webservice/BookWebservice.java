package ac.cr.una.backend.webservice;

import ac.cr.una.backend.DAO.BookDAO;
import ac.cr.una.backend.DAO.BookDAOImpl;
import ac.cr.una.backend.model.Book;
import ac.cr.una.backend.service.BookService;
import ac.cr.una.backend.service.BookServiceImpl;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Jason
 */
@Path("Books")
public class BookWebservice
{

    private BookDAO bookDAO;
    private BookService bookService;
    @Context
    UriInfo context;

    public BookWebservice()
    {
    }

    @DELETE
    @Path("/")
    public boolean deleteAll()
    {
        boolean result;
        bookDAO = new BookDAOImpl();
        bookService = new BookServiceImpl(bookDAO);

        result = bookService.deleteAll();

        return result;
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Book createBook(Book book)
    {

        bookDAO = new BookDAOImpl();
        bookService = new BookServiceImpl(bookDAO);

        book = bookService.save(book);

        return book;
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getAllBooks()
    {
        List<Book> bookList = null;
        bookDAO = new BookDAOImpl();
        bookService = new BookServiceImpl(bookDAO);

        bookList = bookService.findAll();

        return bookList;
    }

    @GET
    @Path("/{price}")
    @Produces(MediaType.APPLICATION_JSON)
    public float getTotalPrice()
    {
        float aux = 0;

        bookDAO = new BookDAOImpl();
        bookService = new BookServiceImpl(bookDAO);

        List<Book> books = bookService.findAll();
        for (int i = 0; books.size() > 0; i++)
        {
            aux += books.get(i).getPrice();
        }
        return aux;
    }
}
