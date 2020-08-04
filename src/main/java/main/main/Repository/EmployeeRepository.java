package main.main.Repository;

import main.main.Model.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    List<Employee> findAllBySalary(float salary); //To to samo co Select * FROM employee where salary = $salary;
}
