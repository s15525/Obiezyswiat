package main.main.Controller;

import main.main.Model.Vehicle;
import main.main.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

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

    @GetMapping("/vehicle/getOne")
    @ResponseBody
    public Optional<Vehicle> getOne(Long Id){
        return vehicleService.getOne(Id);
    }

    @RequestMapping("/vehicle/update")
    public String update(Vehicle vehicle){
        vehicleService.updateVehicle(vehicle);
        return "redirect:/allVehicles";
    }

    @GetMapping("/vehicle/delete")
    public String delete(Long id){
        vehicleService.deleteVehicle(id);
        return "redirect:/allVehicles";
    }
}
