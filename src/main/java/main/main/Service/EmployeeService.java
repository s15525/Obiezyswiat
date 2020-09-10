package main.main.Service;

import main.main.Model.Employee;
import main.main.Model.EmployeeDetails;
import main.main.Model.Transaction;
import main.main.Repository.EmployeeDetailsRepository;
import main.main.Repository.EmployeeRepository;
import main.main.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;
    private EmployeeDetailsRepository employeeDetailsRepository;
    private TransactionRepository transactionRepository;

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Autowired
    public void setEmployeeDetailsRepository(EmployeeDetailsRepository employeeDetailsRepository) {
        this.employeeDetailsRepository = employeeDetailsRepository;
    }

    @Autowired
    public void setTransactionRepository(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void addEmployee(Employee employee, EmployeeDetails employeeDetails){
        employee.setEmployeeDetails(employeeDetails);

        employeeDetailsRepository.save(employeeDetails);
        employeeRepository.save(employee);
    }

    public List<Employee> showAllEmployees(){
        return (List<Employee>) employeeRepository.findAll();
    }

    public void updateEmployee(Employee employee){
        Optional<Employee> oldEmployee = this.getOne(employee.getId());
        oldEmployee.get().setFirstName(employee.getFirstName());
        oldEmployee.get().setLastName(employee.getLastName());
        oldEmployee.get().setSalary(employee.getSalary());
        oldEmployee.get().setPosition(employee.getPosition());
        //Jak robilem employeeRepository.save(employee) bez tego wyzej to klucze obce jako null mi ustawialo
        //dlatego zroiblem tak "brzydko"
        employeeRepository.save(oldEmployee.get());
    }

    public Optional<Employee> getOne(Long id){
        return employeeRepository.findById(id);
    }

    public void deleteEmployee(Long id){
        EmployeeDetails employeeDetails = employeeDetailsRepository.getById(this.getOne(id).get().getEmployeeDetails().getId());
        List<Transaction> transactionList = transactionRepository.findAllByEmployee(this.getOne(id).get());
        for(Transaction transaction : transactionList){
            transaction.setEmployee(null);
            transaction.setVehicle(null); //to bedzie trzeba ladnie schowac
        }
        employeeRepository.deleteById(id);
        employeeDetailsRepository.deleteById(employeeDetails.getId());
        transactionList.forEach(transactionRepository::save);
    }

}
