package main.main.Service;

import main.main.Model.*;
import main.main.Repository.EmployeeDetailsRepository;
import main.main.Repository.EmployeeRepository;
import main.main.Repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeDetailsRepository employeeDetailsRepository;
    private final TransactionRepository transactionRepository;
    private final UserService userService;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeDetailsRepository employeeDetailsRepository,
                           TransactionRepository transactionRepository, UserService userService) {
        this.employeeRepository = employeeRepository;
        this.employeeDetailsRepository = employeeDetailsRepository;
        this.transactionRepository = transactionRepository;
        this.userService = userService;
    }

    public void addEmployee(Employee employee, EmployeeDetails employeeDetails, String userId) throws Exception {
        Set<Employee> employeeSet = userService.getUserById(userId).getEmployees();
        Subscription subscription = userService.getUserById(userId).getSubscription();

        if(subscription == null) {
            throw new Exception("Nie posiadasz subskrypcji");
        }else if(subscription.getName().equals("Standard") && employeeSet.size() == 5) {
            throw new Exception("Masz maksymalna liczbe pracownikow dla twojego abonamentu");
        }else if(subscription.getName().equals("Premium") && employeeSet.size() == 10) {
            throw new Exception("Masz maksymalna liczbe pracownikow dla twojego abonamentu");
        }else {
            employee.setEmployeeDetails(employeeDetails);

            employeeDetailsRepository.save(employeeDetails);
            employeeRepository.save(employee);
        }
    }

    public List<Employee> showAllEmployees(){
        return employeeRepository.findAll();
    }

    public List<Employee> showEmployeesByUserId(User user){
        return employeeRepository.findAllByUser(user);
    }

    public List<Employee> showEmployeesWithoutVehicle(User user){
        return employeeRepository.employees(user);
    }

    public Employee getEmployeeByUserId(User user){
        return employeeRepository.getByUser(user);
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

    public void updateEmployeeVehicle(Long userId, Vehicle vehicle){
        Employee employee = employeeRepository.getOne(userId);
        employee.setVehicle(vehicle);
        employeeRepository.save(employee);
    }

    public Optional<Employee> getOne(Long id){
        return employeeRepository.findById(id);
    }

    public List<Employee> getEmployeesByUserId(User user){
        return employeeRepository.findAllByUser(user);
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
