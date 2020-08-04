package main.main.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "transaction")
public class Transaction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transactionId")
    private Long id;
    @Column(name = "companyName", nullable = false)
    private String companyName;
    @Column(name = "bid", nullable = false)
    private float bid;
    @Column(name = "route", nullable = false)
    private String route;
    @Column(name = "loadingPlace", nullable = false)
    private String loadingPlace;
    @Column(name = "unloadingPlace", nullable = false)
    private String unloadingPlace;

    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "vehicleId")
    private Vehicle vehicle;

    public Transaction(String companyName, float bid, String route, String loadingPlace, String unloadingPlace) {
        this.companyName = companyName;
        this.bid = bid;
        this.route = route;
        this.loadingPlace = loadingPlace;
        this.unloadingPlace = unloadingPlace;
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

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void realiseTransaction(){

    }

    public void deleteTransaction(){

    }


    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", bid=" + bid +
                ", route='" + route + '\'' +
                ", loadingPlace='" + loadingPlace + '\'' +
                ", unloadingPlace='" + unloadingPlace + '\'' +
                ", employee=" + employee +
                '}';
    }
}
