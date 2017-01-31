package ac.cr.una.backend.DAO;

import ac.cr.una.backend.model.AuthorContact;
import java.util.List;

/**
 *
 * @author Jason
 */
public interface AuthorContactDAO
{

    public AuthorContact save(AuthorContact authorContact);

    public List<AuthorContact> findAll();

    public boolean deleteAll();
}
