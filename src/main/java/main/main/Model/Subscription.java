package main.main.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "subscription")
public class Subscription implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subscription")
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private float prize;
    @Column(nullable = false)
    private int length;

    public Subscription(){}

    public Subscription(String name, float prize, int length) {
        this.name = name;
        this.prize = prize;
        this.length = length;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrize() {
        return prize;
    }

    public void setPrize(float prize) {
        this.prize = prize;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", prize=" + prize +
                ", length=" + length +
                '}';
    }
}
