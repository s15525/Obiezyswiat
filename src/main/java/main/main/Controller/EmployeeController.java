package main.main.Controller;

import main.main.Model.Employee;
import main.main.Model.EmployeeDetails;
import main.main.Model.Subscription;
import main.main.Service.EmployeeService;
import main.main.Service.UserService;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;
import java.util.Set;

@Secured("ROLE_USER")
@RequestMapping("/employee")
@Controller
public class EmployeeController {

    private final EmployeeService employeeService;
    private final UserService userService;

    public EmployeeController(EmployeeService employeeService, UserService userService) {
        this.employeeService = employeeService;
        this.userService = userService;
    }

    @GetMapping("/allEmployees")
    public String showEmployees(Model model, HttpServletRequest request){
        KeycloakAuthenticationToken principal = (KeycloakAuthenticationToken) request.getUserPrincipal();
        model.addAttribute("employeeList", employeeService.showEmployeesByUserId(userService.getUserById(principal.getAccount().getKeycloakSecurityContext().getIdToken().getSubject())));
        return "employee";
    }

    @GetMapping("/addEmployee")
    public String employee(Model model){
        model.addAttribute("employee", new Employee());
        return "addEmployee";
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@ModelAttribute @Valid Employee employee, BindingResult bindingResult,
                              HttpServletRequest request) throws Exception {
        if(bindingResult.hasErrors()) {
            return "addEmployee";
        }else{
            KeycloakAuthenticationToken principal = (KeycloakAuthenticationToken) request.getUserPrincipal();
            String userId = principal.getAccount().getKeycloakSecurityContext().getIdToken().getSubject();// Pobranie id usera
            employee.setUser(userService.getUserById(userId));
            employeeService.addEmployee(employee, new EmployeeDetails(0, 0f), userId);
            return "homePage";
        }
    }

    @GetMapping("/getOne")
    @ResponseBody
    public Optional<Employee> getOne(Long Id){
        return employeeService.getOne(Id);
    }

    @RequestMapping("/update")
    public String update(Employee employee){
        employeeService.updateEmployee(employee);
        return "redirect:/employee/allEmployees";
    }

    @GetMapping("/delete")
    public String deleteEmployee(Long Id){
        employeeService.deleteEmployee(Id);
        return "redirect:/employee/allEmployees";
    }
}