package main.main.Repository;

import main.main.Model.User;
import main.main.Model.Vehicle;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
    List<Vehicle> findAllByBrand(String brand);
    List<Vehicle> findAllByEmployeeUser(User user);

    Optional<Vehicle> findById(Long id);
}
