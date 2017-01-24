import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by praxis on 16.01.17.
 */
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa");
        EntityManager manager = factory.createEntityManager();
        Person author = new Person("Stephen", "King", 50, Person.Gender.male);
        manager.getTransaction().begin();
        manager.persist(author);
        manager.getTransaction().commit();

        Person fetchedPerson = manager.find(Person.class, author.getId());
        Query query = manager.createQuery("SELECT p FROM Person p WHERE p.id = :id");
        query.setParameter("id", author.getId());
        List<Person> persons = query.getResultList();

        Book book = new Book(author, 0.7d, "It");
        manager.getTransaction().begin();
        manager.persist(book);
        manager.getTransaction().commit();


    }
}
