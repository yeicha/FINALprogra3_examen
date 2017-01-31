package ac.cr.una.backend.service;

import ac.cr.una.backend.model.BookType;

/**
 *
 * @author mguzmana
 */
public interface BookTypeService
{

    public BookType findByName(String name);

    public BookType save(BookType bookType);

    public boolean deleteAll();

}
