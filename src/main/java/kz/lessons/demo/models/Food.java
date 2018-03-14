package kz.lessons.demo.models;



import javax.persistence.*;

@Entity
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long food_id;
    private String food_name;
    private String food_finishtime;
    private int time;
    private Client client;


    public Food() {
    }
    public Food(String food_name, String food_finishtime, int time) {
        this.food_name = food_name;
        this.food_finishtime = food_finishtime;
        this.time = time;
    }

    public long getFood_id() {
        return food_id;
    }

    public void setfood_id(long food_id) {
        this.food_id = food_id;
    }

    public String getfood_name() {
        return food_name;
    }

    public void setfood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getFood_finishtime() {
        return food_finishtime;
    }

    public void setFood_finishtime(String food_finishtime) {
        this.food_finishtime = food_finishtime;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @ManyToOne
    @JoinColumn(name = "id")
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}