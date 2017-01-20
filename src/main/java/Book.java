import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by praxis on 16.01.17.
 */
@Entity
@Table(name="books")
public class Book implements Serializable {
    @ManyToOne(targetEntity = Person.class, fetch = FetchType.LAZY)
    Person author;
    double price;
    @NotNull
    String title;

    public Book() {
    }

    public Book(Person author, double price, String title) {
        this.author = author;
        this.price = price;
        this.title = title;
    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
