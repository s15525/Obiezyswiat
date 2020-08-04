package main.main.Repository;

import main.main.Model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    List<Employee> findAllBySalary(float salary); //To to samo co Select * FROM employee where salary = $salary;

    Employee findOne(Long id);
}
