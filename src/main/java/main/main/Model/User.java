package main.main.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/***
 * Id uzytkownika jest jego id z keycloaka
 */

@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @Column(name = "id_user", unique = true, nullable = false, columnDefinition = "VARCHAR(255)")
    private String userId;
    @Column(name = "subscription_start")
    private String subscriptionStart;
    @Column(name = "scubscription_end")
    private String subscriptionEnd;

    @OneToMany(mappedBy = "user")
    private Set<Employee> employees;
    @ManyToOne
    @JoinColumn(name = "subscription_id")
    private Subscription subscription;

    public User(){}

    public User(String userId){
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public String getSubscriptionStart() {
        return subscriptionStart;
    }

    public void setSubscriptionStart(String subscriptionStart) {
        this.subscriptionStart = subscriptionStart;
    }

    public String getSubscriptionEnd() {
        return subscriptionEnd;
    }

    public void setSubscriptionEnd(String subscriptionEnd) {
        this.subscriptionEnd = subscriptionEnd;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                '}';
    }
}
