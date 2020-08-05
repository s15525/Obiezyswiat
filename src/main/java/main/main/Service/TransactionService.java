package main.main.Service;

import main.main.Model.Employee;
import main.main.Model.EmployeeDetails;
import main.main.Model.Transaction;
import main.main.Model.Vehicle;
import main.main.Repository.EmployeeDetailsRepository;
import main.main.Repository.EmployeeRepository;
import main.main.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private TransactionRepository transactionRepository;
    private EmployeeRepository employeeRepository;
    private EmployeeDetailsRepository employeeDetailsRepository;

    @Autowired
    public void setTransactionRepository(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Autowired
    public void setEmployeeDetailsRepository(EmployeeDetailsRepository employeeDetailsRepository) {
        this.employeeDetailsRepository = employeeDetailsRepository;
    }

    public void assignTransaction(Transaction transaction, Employee employee, Vehicle vehicle){
        if(!employee.getTransactions().contains(transaction)){
            transaction.setEmployee(employee);
            transaction.setVehicle(vehicle);

            List<Transaction> transactions = employee.getTransactions();
            transactions.add(transaction);
            employee.setTransactions(transactions);

            EmployeeDetails employeeDetails = employeeDetailsRepository.getById(employee.getEmployeeDetails().getId());
            employeeDetails.setSumCostTrans(employeeDetails.getSumCostTrans() + transaction.getBid());
            employeeDetails.setTransactionsCount(employeeDetails.getTransactionsCount()+1);

            employeeDetailsRepository.save(employeeDetails);
            employeeRepository.save(employee);
            transactionRepository.save(transaction);
        }
    }
    public void addTransaction(Transaction transaction){
        transactionRepository.save(transaction);
    }

    //Ta metoda zeby dodawac odrazu cala liste a nie pojedynczo to testow tylko jak cos mi potrzebna
    public void addTransactions(List<Transaction> transactionList){
        transactionList.forEach(transactionRepository::save);
    }
}
