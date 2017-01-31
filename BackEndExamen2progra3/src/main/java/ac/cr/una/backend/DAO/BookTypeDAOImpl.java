package ac.cr.una.backend.DAO;

import ac.cr.una.backend.model.BookType;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Jason
 */
public class BookTypeDAOImpl implements BookTypeDAO
{

    private final Session session = HibernateUtil.getSessionFactory().openSession();

    @Override
    public BookType save(BookType bookType)
    {
        session.beginTransaction();
        session.save(bookType);
        session.getTransaction().commit();

        return bookType;
    }

    @Override
    public BookType findByName(String name)
    {
        BookType bookType = null;
        Query query = session.createQuery("from BookType where name = :name ");
        query.setParameter("name", name);

        if (query.list().size() > 0)
        {
            bookType = (BookType) query.list().get(0);
        }

        return bookType;
    }

    @Override
    public boolean deleteAll()
    {
        boolean isDeleted = false;
        List<BookType> bookList = new ArrayList<>();

        bookList = session.createCriteria(BookType.class).list();
        session.beginTransaction();
        session.delete(bookList);
        isDeleted = true;
        session.getTransaction().commit();

        return isDeleted;
    }
}
