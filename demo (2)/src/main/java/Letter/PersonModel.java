package Letter.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Entity
@Table(name = "person")
public class PersonModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @NotNull(message = "ФИО не может быть пустым")
    @Size(min = 2, max = 100, message = "Имя должно быть от 2 до 100 символов")
    @Column(name = "name")
    private String name;

    @NotNull(message = "ФИО не может быть пустым")
    @Size(min = 2, max = 100, message = "Фамилия должно быть от 2 до 100 символов")
    @Column(name = "username")
    private String username;

    @Column(name = "country")
    private String country;

    public PersonModel(int id, String name, String username, String country) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "PersonModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
