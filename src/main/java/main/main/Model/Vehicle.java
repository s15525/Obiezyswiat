package main.main.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "vehicle")
public class Vehicle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicleId")
    private Long id;
    @Column(name = "vehicleType", nullable = false)
    private String vehicleType;
    @Column(name = "registrationNumber", nullable = false)
    private String registerNr;
    @Column(name = "vehicleCapacity", nullable = false)
    private float capacity;
    @Column(name = "reviewDate", nullable = false)
    private String reviewDate;
    @Column(name = "vehicleBrand", nullable = false)
    private String brand;
    @Column(name = "insuranceDate", nullable = false)
    private String insuranceDate;
    @OneToMany(mappedBy = "vehicle")
    private List<Transaction> transactions;

    Vehicle(){}

    public Vehicle(VehicleType vehicleType, String registerNr, float capacity, String reviewDate, String brand, String insuranceDate) {
        this.vehicleType = String.valueOf(vehicleType);
        this.registerNr = registerNr;
        this.capacity = capacity;
        this.reviewDate = reviewDate;
        this.brand = brand;
        this.insuranceDate = insuranceDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getRegisterNr() {
        return registerNr;
    }

    public void setRegisterNr(String registerNr) {
        this.registerNr = registerNr;
    }

    public float getCapacity() {
        return capacity;
    }

    public void setCapacity(float capacity) {
        this.capacity = capacity;
    }

    public String getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(String reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getInsuranceDate() {
        return insuranceDate;
    }

    public void setInsuranceDate(String insuranceDate) {
        this.insuranceDate = insuranceDate;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id='" + id + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", registerNr='" + registerNr + '\'' +
                ", capacity=" + capacity +
                ", reviewDate=" + reviewDate +
                ", brand='" + brand + '\'' +
                ", insuranceDate=" + insuranceDate +
                '}';
    }
}
