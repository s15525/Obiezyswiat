package main.main.Model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id;
    @Size(min=2, max=30)
    @Pattern(regexp = "^[a-zA-Z]+", message = "Not Numbers Allow")
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Size(min=2, max=30)
    @Pattern(regexp = "^[a-zA-Z]+", message = "Not Numbers Allow")
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Email
    @Size(min=2, max=30)
    @Column(nullable = false)
    private String email;
    //TODO password check
//    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$",
//            message = "Minimum eight characters, at least one letter, one number and one special character")
    @Column(nullable = false)
    private String password;
    @Column(name = "birth_date", nullable = false)
    private String birthDate;
    private String subscriptionEndDate;

    @OneToOne
    private Subscription subscription;

    @OneToMany(mappedBy = "user")
    List<Employee> employees;

    @OneToOne
    private Role role;

    public User(){}

    public User(String firstName, String lastName, @Email String email, String password, String birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getSubscriptionEndDate() {
        return subscriptionEndDate;
    }

    public void setSubscriptionEndDate(String subscriptionEndDate) {
        this.subscriptionEndDate = subscriptionEndDate;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", subscriptionEndDate='" + subscriptionEndDate + '\'' +
                ", subscription=" + subscription +
                ", employees=" + employees +
                ", role=" + role +
                '}';
    }
}
