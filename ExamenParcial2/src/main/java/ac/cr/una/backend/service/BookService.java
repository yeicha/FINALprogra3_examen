package ac.cr.una.backend.service;

import ac.cr.una.backend.model.Book;
import java.util.List;

/**
 *
 * @author Jason
 */
public interface BookService
{

    public float totalPriceAll();

    public List<Book> findAll();

    public Book save(Book book);

    public boolean deleteAll();

}
