package main.main.Controller;

import main.main.Model.Employee;
import main.main.Model.User;
import main.main.Model.Vehicle;
import main.main.Model.VehicleType;
import main.main.Service.UserService;
import main.main.validatingforminput.LoginForm;
import main.main.validatingforminput.RegisterForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Controller
public class YourUserController implements WebMvcConfigurer {

  /*  @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("login");
        //Place for after login controller
    }

    @GetMapping("/")
    String entry(LoginForm loginForm){
        return "login";
    }

    @PostMapping("/")
    String checkPassword(LoginForm loginForm, BindingResult bindingResult ){
        //TODO

        return "login";
    }

    @GetMapping("/register")
        public String register(RegisterForm registerForm){
        return "register";
    }

    @PostMapping("/register")
    public String checkRegisterForm(@Valid RegisterForm registerForm, BindingResult bindingResult){
        //registerForm object with value's form
        if (bindingResult.hasErrors()){
            return "register";
        }
        UserService userService = new UserService();
        System.out.println(registerForm.getFirstName()+","+registerForm.getSurname()+","+registerForm.getEmail()
                +","+registerForm.getPassword()+","+registerForm.getBrithDate());
        userService.addUser(new User(registerForm.getFirstName(),registerForm.getSurname(),registerForm.getEmail()
                ,registerForm.getPassword(),registerForm.getBrithDate()));

        return "redirect:/results";
    }*/
}
