package main.main.Repository;

import main.main.Model.Employee;
import main.main.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findAllBySalary(float salary);
    List<Employee> findAllByUser(User user);
    Employee getByUser(User user);
    @Query("SELECT a FROM Employee a where a.user = ?1 and a.id not in (select b.employee from Vehicle b)")
    List<Employee> employees(User user);

    Optional<Employee> findById(Long id);
}
