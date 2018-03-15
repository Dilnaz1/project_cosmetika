package kz.lessons.demo.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;
    private String firstName ;
    private String lastName ;
    private String email ;
    private Set<Cosmetika> cosmetika;


    public Client(){}

    public Client(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    public Set<Cosmetika> getCosmetika() {
        return cosmetika;
    }

    public void setFood(Set<Cosmetika> food) {
        this.cosmetika = food;
    }

    @Override
    public String toString() {
        String result = String.format("Category[id=%d, firstName='%s', lastName='%a', email='%e']%n", id, firstName, lastName, email);
        if (cosmetika != null) {
            for(Cosmetika cosmetika : cosmetika) {
                result += String.format("Cosmetika[cosmetika_id=%d, cosmetika_name='%s', cosmetika_finishtime='%g',time='%y']%n", cosmetika.getCosmetika_id(), cosmetika.getCosmetika_name(), cosmetika.getCosmetika_finishtime(), cosmetika.getTime());
            }
        }

        return result;
    }
}

