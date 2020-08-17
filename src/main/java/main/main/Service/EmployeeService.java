package main.main.Service;

import main.main.Model.Employee;
import main.main.Model.EmployeeDetails;
import main.main.Repository.EmployeeDetailsRepository;
import main.main.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;
    private EmployeeDetailsRepository employeeDetailsRepository;

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Autowired
    public void setEmployeeDetailsRepository(EmployeeDetailsRepository employeeDetailsRepository) {
        this.employeeDetailsRepository = employeeDetailsRepository;
    }

    public void addEmployee(Employee employee, EmployeeDetails employeeDetails){
        employee.setEmployeeDetails(employeeDetails);

        employeeDetailsRepository.save(employeeDetails);
        employeeRepository.save(employee);
    }

    public List<Employee> showAllEmployees(){
        return (List<Employee>) employeeRepository.findAll();
    }
}
