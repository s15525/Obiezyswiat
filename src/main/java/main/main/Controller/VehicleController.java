package main.main.Controller;

import main.main.Model.EmployeeDetails;
import main.main.Model.Vehicle;
import main.main.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class VehicleController {
    private VehicleService vehicleService;

    @Autowired
    public void setVehicleService(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/allVehicles")
    public String showVehicles(Model model){
        model.addAttribute("vehiclesList", vehicleService.showAllVehicles());
        return "vehicle";
    }

    @GetMapping("/addVehicle")
    public String vehicle(Model model){
        model.addAttribute("vehicle", new Vehicle());
        return "addVehicle";
    }

    @PostMapping("/addVehicle")
    public String addVehicle(@ModelAttribute @Valid Vehicle vehicle, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return "addVehicle";
        }else{
            vehicleService.addVehicle(vehicle);
            return "homePage";
        }
    }
}
