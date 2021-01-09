package main.main.Service;

import main.main.Model.*;
import main.main.Repository.EmployeeDetailsRepository;
import main.main.Repository.EmployeeRepository;
import main.main.Repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final EmployeeRepository employeeRepository;
    private final EmployeeDetailsRepository employeeDetailsRepository;
    private final VehicleService vehicleService;

    public TransactionService(TransactionRepository transactionRepository, EmployeeRepository employeeRepository,
                              EmployeeDetailsRepository employeeDetailsRepository, VehicleService vehicleService) {
        this.transactionRepository = transactionRepository;
        this.employeeRepository = employeeRepository;
        this.employeeDetailsRepository = employeeDetailsRepository;
        this.vehicleService = vehicleService;
    }

    public void addTransaction(Transaction transaction){
        transactionRepository.save(transaction);
    }

    public void addTransactions(List<Transaction> transactionList){
        if(showAvailableTransactions().isEmpty())
            transactionList.forEach(transactionRepository::save);
        else
            System.out.println("Tranzakcje sa w bazie");
    }

    public List<Transaction> showAvailableTransactions(){
        return transactionRepository.getAllByEmployeeIsNull();
    }

    public List<Transaction> showAssignedTransactions(User user){
        return transactionRepository.findAllByEmployeeUser(user);
    }

    public Optional<Transaction> getOne(Long id){
        return transactionRepository.findById(id);
    }

    public void assign(Transaction transaction, Employee employee){
        if(!employee.getTransactions().contains(transaction)){
            transaction.setEmployee(employee);

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
}
