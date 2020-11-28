package main.main.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "transaction")
public class Transaction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaction")
    private Long id;
    @Column(name = "company_name", nullable = false)
    private String companyName;
    @Column(name = "bid", nullable = false)
    private float bid;
    @Column(name = "weight", nullable = false)
    private float weight;
    @Column(name = "loading_date", nullable = false)
    private String loadingDate;
    @Column(name = "unloading_date", nullable = false)
    private String unloadingDate;
    @Column(name = "loading_place", nullable = false)
    private String loadingPlace;
    @Column(name = "unloading_place", nullable = false)
    private String unloadingPlace;
    @Column(nullable = false)
    private String description;
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    @Column(name = "notification_date")
    private String notificationDate;
    @Column(name = "end_date")
    private String endDate;

    @ManyToOne
    @JoinColumn(name = "id_employee")
    @JsonIgnore
    private Employee employee;

    public Transaction(){}

    public Transaction(String companyName, float bid, float weight, LocalDate loadingDate,
                       LocalDate unloadingDate, String loadingPlace, String unloadingPlace,
                       String description, String phoneNumber, LocalDate notificationDate, LocalDate endDate) {
        this.companyName = companyName;
        this.bid = bid;
        this.weight = weight;
        this.loadingDate = String.valueOf(loadingDate);
        this.unloadingDate = String.valueOf(unloadingDate);
        this.loadingPlace = loadingPlace;
        this.unloadingPlace = unloadingPlace;
        this.description = description;
        this.phoneNumber = phoneNumber;
        this.notificationDate = String.valueOf(notificationDate);
        this.endDate = String.valueOf(endDate);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public float getBid() {
        return bid;
    }

    public void setBid(float bid) {
        this.bid = bid;
    }


    public String getLoadingPlace() {
        return loadingPlace;
    }

    public void setLoadingPlace(String loadingPlace) {
        this.loadingPlace = loadingPlace;
    }

    public String getUnloadingPlace() {
        return unloadingPlace;
    }

    public void setUnloadingPlace(String unloadingPlace) {
        this.unloadingPlace = unloadingPlace;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getLoadingDate() {
        return loadingDate;
    }

    public void setLoadingDate(String loadingDate) {
        this.loadingDate = loadingDate;
    }

    public String getUnloadingDate() {
        return unloadingDate;
    }

    public void setUnloadingDate(String unloadingDate) {
        this.unloadingDate = unloadingDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNotificationDate() {
        return notificationDate;
    }

    public void setNotificationDate(String notificationDate) {
        this.notificationDate = notificationDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", bid=" + bid +
                ", weight=" + weight +
                ", loadingDate='" + loadingDate + '\'' +
                ", unloadingDate='" + unloadingDate + '\'' +
                ", loadingPlace='" + loadingPlace + '\'' +
                ", unloadingPlace='" + unloadingPlace + '\'' +
                ", description='" + description + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", notificationDate='" + notificationDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
