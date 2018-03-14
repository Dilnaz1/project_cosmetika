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
    private Set<Food> food;


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
    public Set<Food> getFood() {
        return food;
    }

    public void setFood(Set<Food> food) {
        this.food = food;
    }

    @Override
    public String toString() {
        String result = String.format("Category[id=%d, firstName='%s', lastName='%a', email='%e']%n", id, firstName, lastName, email);
        if (food != null) {
            for(Food food : food) {
                result += String.format("Food[food_id=%d, food_name='%s', food_finishtime='%g',time='%y']%n", food.getFood_id(), food.getfood_name(), food.getFood_finishtime(), food.getTime());
            }
        }

        return result;
    }
}

