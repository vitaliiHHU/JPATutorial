import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by praxis on 16.01.17.
 */
@Entity
public class Person implements Serializable{
    String name;
    String surname;
    int age;
    Gender gender;
    @OneToMany(targetEntity = Book.class, fetch = FetchType.LAZY, mappedBy = "author")
    List<Book> listOfBook;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    public List<Book> getListOfBook() {
        return listOfBook;
    }

    public void setListOfBook(List<Book> listOfBook) {
        this.listOfBook = listOfBook;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public enum Gender{male, female}

    public Person() {    }

    public Person(String name, String surname, int age, Gender gender) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
