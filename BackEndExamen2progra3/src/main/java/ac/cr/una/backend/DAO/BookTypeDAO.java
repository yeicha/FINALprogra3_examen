package ac.cr.una.backend.DAO;

import ac.cr.una.backend.model.BookType;

/**
 *
 * @author Jason
 */
public interface BookTypeDAO
{

    public BookType save(BookType book);

    public BookType findByName(String name);

    public boolean deleteAll();
}
