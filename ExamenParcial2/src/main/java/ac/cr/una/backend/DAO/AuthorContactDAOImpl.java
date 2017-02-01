package ac.cr.una.backend.DAO;

import ac.cr.una.backend.model.AuthorContact;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Jason
 */
public class AuthorContactDAOImpl implements AuthorContactDAO
{

    private final Session session = HibernateUtil.getSessionFactory().openSession();

    @Override
    public AuthorContact save(AuthorContact authorContact)
    {
        session.beginTransaction();
        session.save(authorContact);
        session.getTransaction().commit();

        return authorContact;
    }

    @Override
    public List<AuthorContact> findAll()
    {
        List<AuthorContact> authorContactList = new ArrayList<>();

        authorContactList = session.createCriteria(AuthorContact.class).list();

        return authorContactList;
    }

    @Override
    public boolean deleteAll()
    {
        boolean isDeleted = false;
        List<AuthorContact> authorContactList = new ArrayList<>();

        authorContactList = session.createCriteria(AuthorContact.class).list();
        session.beginTransaction();
        session.delete(authorContactList);
        isDeleted = true;
        session.getTransaction().commit();

        return isDeleted;
    }
}
