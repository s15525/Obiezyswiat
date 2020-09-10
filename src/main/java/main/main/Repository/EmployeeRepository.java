package main.main.Repository;

import main.main.Model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    List<Employee> findAllBySalary(float salary);

    Optional<Employee> findById(Long id);
}
