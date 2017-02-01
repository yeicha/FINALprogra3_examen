package ac.cr.una.backend.service;

import ac.cr.una.backend.DAO.BookDAO;
import ac.cr.una.backend.model.Book;
import java.util.List;

/**
 *
 * @author Jason
 */
public class BookServiceImpl implements BookService
{

    private BookDAO bookDAO;

    public BookServiceImpl()
    {
    }

    public BookServiceImpl(BookDAO bookDAO)
    {
        this.bookDAO = bookDAO;
    }

    @Override
    public float totalPriceAll()
    {
        float aux = 0;
        List<Book> books = bookDAO.findAll();
        for (int i = 0; books.size() > 0; i++)
        {
            aux += books.get(i).getPrice();
        }
        return aux;
    }

    @Override
    public List<Book> findAll()
    {
        return bookDAO.findAll();
    }

    @Override
    public Book save(Book book)
    {
        return bookDAO.save(book);
    }

    @Override
    public boolean deleteAll()
    {
        return bookDAO.deleteAll();
    }

    public BookDAO getBookDAO()
    {
        return bookDAO;
    }

    public void setBookDAO(BookDAO bookDAO)
    {
        this.bookDAO = bookDAO;
    }

}
