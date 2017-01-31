package ac.cr.una.backend.service;

import ac.cr.una.backend.DAO.AuthorContactDAO;
import ac.cr.una.backend.DAO.AuthorDAO;
import ac.cr.una.backend.model.Author;
import ac.cr.una.backend.model.AuthorContact;
import java.util.List;

/**
 *
 * @author Jason
 */
public class AuthorServiceImpl implements AuthorService
{

    private AuthorDAO authorDAO;
    private AuthorContactDAO authorContactDAO;

    public AuthorServiceImpl()
    {
    }

    public AuthorServiceImpl(AuthorDAO authorDAO)
    {
        this.authorDAO = authorDAO;
    }

    public AuthorServiceImpl(AuthorContactDAO authorContactDAO)
    {
        this.authorContactDAO = authorContactDAO;
    }

    public AuthorServiceImpl(AuthorDAO authorDAO, AuthorContactDAO authorContactDAO)
    {
        this.authorDAO = authorDAO;
        this.authorContactDAO = authorContactDAO;
    }

    @Override
    public Author findByName(String name)
    {
        return authorDAO.findByName(name);
    }

    @Override
    public List<AuthorContact> findAll()
    {
        return authorContactDAO.findAll();
    }

    @Override
    public AuthorContact save(AuthorContact authorContact)
    {
        return authorContactDAO.save(authorContact);
    }

    @Override
    public boolean deleteAll()
    {
        return authorContactDAO.deleteAll();
    }

    public AuthorDAO getAuthorDAO()
    {
        return authorDAO;
    }

    public AuthorContactDAO getAuthorContactDAO()
    {
        return authorContactDAO;
    }

    public void setAuthorDAO(AuthorDAO authorDAO)
    {
        this.authorDAO = authorDAO;
    }

    public void setAuthorContactDAO(AuthorContactDAO authorContactDAO)
    {
        this.authorContactDAO = authorContactDAO;
    }

}
