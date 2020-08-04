package main.main.Controller;

import main.main.Model.Vehicle;
import main.main.Model.VehicleType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VehicleController {

    @GetMapping("/vehicle")
    public String vehicle(Model model){
        Vehicle vehicle = new Vehicle(VehicleType.Truck, "WE4512", 5000f, "22", "Volvo", "22");
        model.addAttribute("vehicle",vehicle);
        return "vehicle";
    }

    @GetMapping("/")
    String entry(){
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model){
        return "register";
    }
}
