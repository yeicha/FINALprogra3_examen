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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
