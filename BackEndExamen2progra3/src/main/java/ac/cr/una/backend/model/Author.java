package ac.cr.una.backend.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Jason
 */
@Entity
@Table(name = "author", catalog = "progra3_exa2", uniqueConstraints =
{
    @UniqueConstraint(columnNames = "idAuthor")
})
public class Author implements Serializable
{

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idAuthor", unique = true, nullable = false)
    private int idAuthor;
    @Column(name = "name", unique = false, nullable = false)
    private String name;

    public Author()
    {
    }

    public Author(int idAuthor, String name)
    {
        this.idAuthor = idAuthor;
        this.name = name;
    }

    public int getIdAuthor()
    {
        return idAuthor;
    }

    public String getName()
    {
        return name;
    }

    public void setIdAuthor(int idAuthor)
    {
        this.idAuthor = idAuthor;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public int hashCode()
    {
        int hash = 2;
        hash = 79 * hash + this.idAuthor;
        hash = 79 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Author other = (Author) obj;
        if (this.idAuthor != other.idAuthor)
        {
            return false;
        }
        if (!Objects.equals(this.name, other.name))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "Author{" + "idAuthor=" + idAuthor + ", name=" + name + '}';
    }

}
