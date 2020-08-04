package main.main.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "employee_details")
public class EmployeeDetails implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detailsId")
    private Long id;
    @Column(name = "transactionsCount")
    private int transactionsCount;
    @Column(name = "sumCostTrans")
    private float sumCostTrans;

    public EmployeeDetails(int transactionsCount, float sumCostTrans) {
        this.transactionsCount = transactionsCount;
        this.sumCostTrans = sumCostTrans;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTransactionsCount() {
        return transactionsCount;
    }

    public void setTransactionsCount(int transactionsCount) {
        this.transactionsCount = transactionsCount;
    }

    public float getSumCostTrans() {
        return sumCostTrans;
    }

    public void setSumCostTrans(float sumCostTrans) {
        this.sumCostTrans = sumCostTrans;
    }

    @Override
    public String toString() {
        return "EmployeeDetails{" +
                "id=" + id +
                ", transactionsCount=" + transactionsCount +
                ", sumCostTrans=" + sumCostTrans +
                '}';
    }
}
