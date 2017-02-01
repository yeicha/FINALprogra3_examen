package ac.cr.una.backend.DAO;

import ac.cr.una.backend.model.Book;
import java.util.List;

/**
 *
 * @author Jason
 */
public interface BookDAO
{

    public Book save(Book book);

    public List<Book> findAll();

    public boolean deleteAll();
}
