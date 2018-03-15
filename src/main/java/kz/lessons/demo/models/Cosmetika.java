package kz.lessons.demo.models;

import javax.persistence.*;

@Entity
public class Cosmetika {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cosmetika_id;
    private String cosmetika_name;
    private String cosmetika_finishtime;
    private int time;
    private Client client;


    public Cosmetika() {
    }
    public Cosmetika(String cosmetika_name, String cosmetika_finishtime, int time) {
        this.cosmetika_name = cosmetika_name;
        this.cosmetika_finishtime = cosmetika_finishtime;
        this.time = time;
    }

    public long getCosmetika_id() {
        return cosmetika_id;
    }

    public void setCosmetika_id(long cosmetika_id) {
        this.cosmetika_id = cosmetika_id;
    }

    public String getCosmetika_name() {
        return cosmetika_name;
    }

    public void setCosmetika_name(String cosmetika_name) {
        this.cosmetika_name = cosmetika_name;
    }

    public String getCosmetika_finishtime() {
        return cosmetika_finishtime;
    }

    public void setCosmetika_finishtime(String cosmetika_finishtime) {
        this.cosmetika_finishtime = cosmetika_finishtime;
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
