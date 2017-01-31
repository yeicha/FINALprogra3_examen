package ac.cr.una.backend.model;

import ac.cr.una.backend.model.BookType;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Jason
 */
@Entity
@Table(name = "book", catalog = "progra3_exa2", uniqueConstraints =
{
    @UniqueConstraint(columnNames = "idBook")
})
public class Book
{

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idBook")
    private int idBook;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "idAuthor", nullable = false)
    private Author author;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "idType", nullable = false)
    private BookType bookType;

    @Column(name = "name", unique = false, nullable = false)
    private String name;

    @Column(name = "dateRelease", unique = false, nullable = false)
    private Calendar dateRelease;

    @Column(name = "price", unique = false, nullable = false)
    private float price;

    public Book()
    {
    }

    public Book(int idBook, Author author, BookType bookType, String name, Calendar dateRelease, float price)
    {
        this.idBook = idBook;
        this.author = author;
        this.bookType = bookType;
        this.name = name;
        this.dateRelease = dateRelease;
        this.price = price;
    }

    public int getIdBook()
    {
        return idBook;
    }

    public Author getAuthor()
    {
        return author;
    }

    public BookType getBookType()
    {
        return bookType;
    }

    public String getName()
    {
        return name;
    }

    public Calendar getDateRelease()
    {
        return dateRelease;
    }

    public float getPrice()
    {
        return price;
    }

    public void setIdBook(int idBook)
    {
        this.idBook = idBook;
    }

    public void setAuthor(Author author)
    {
        this.author = author;
    }

    public void setBookType(BookType bookType)
    {
        this.bookType = bookType;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setDateRelease(Calendar dateRelease)
    {
        this.dateRelease = dateRelease;
    }

    public void setPrice(float price)
    {
        this.price = price;
    }

    @Override
    public int hashCode()
    {
        int hash = 6;
        hash = 89 * hash + this.idBook;
        hash = 89 * hash + Objects.hashCode(this.author);
        hash = 89 * hash + Objects.hashCode(this.bookType);
        hash = 89 * hash + Objects.hashCode(this.name);
        hash = 89 * hash + Objects.hashCode(this.dateRelease);
        hash = 89 * hash + Objects.hashCode(this.price);
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
        final Book other = (Book) obj;
        if (this.idBook != other.idBook)
        {
            return false;
        }
        if (!Objects.equals(this.name, other.name))
        {
            return false;
        }
        if (!Objects.equals(this.dateRelease, other.dateRelease))
        {
            return false;
        }
        if (!Objects.equals(this.price, other.price))
        {
            return false;
        }
        if (!Objects.equals(this.bookType, other.bookType))
        {
            return false;
        }
        if (!Objects.equals(this.author, other.author))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "Book{" + "idBook=" + idBook + ", author=" + author + ", bookType=" + bookType + ", name=" + name + ", dateRelease=" + dateRelease + ", price=" + price + '}';
    }

}
