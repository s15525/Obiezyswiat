package main.main.Service;

import main.main.Model.Vehicle;
import main.main.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    private VehicleRepository vehicleRepository;

    @Autowired
    public void setVehicleRepository(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public void addVehicle(Vehicle vehicle){
        vehicleRepository.save(vehicle);
    }

    public void addVehicles(List<Vehicle> vehicleList){
        vehicleList.forEach(vehicleRepository::save);
    }
}
