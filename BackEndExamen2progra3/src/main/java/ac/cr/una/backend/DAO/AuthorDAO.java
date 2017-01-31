package ac.cr.una.backend.DAO;

import ac.cr.una.backend.model.Author;

/**
 *
 * @author Jason
 */
public interface AuthorDAO
{

    public Author findByName(String name);

}
