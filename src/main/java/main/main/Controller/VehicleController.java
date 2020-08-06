package main.main.Controller;

import main.main.Model.Employee;
import main.main.Model.Vehicle;
import main.main.Model.VehicleType;
import main.main.validatingforminput.RegisterForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

@Controller
public class VehicleController implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("login");
    }

    @GetMapping("/")
    String entry(){
        return "login";
    }

    @GetMapping("/register")
        public String register(RegisterForm registerForm){
        return "register";
    }

    @PostMapping("/register")
    public String checkRegisterForm(@Valid RegisterForm registerForm, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return "register";
        }

        return "redirect:/";
    }
}
