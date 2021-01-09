package main.main.Controller;

import main.main.Service.EmployeeService;
import main.main.Service.TransactionService;
import main.main.Service.UserService;
import main.main.Service.VehicleService;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Secured("ROLE_USER")
@Controller
@RequestMapping("/home")
public class HomeController {

    private final EmployeeService employeeService;
    private final TransactionService transactionService;
    private final VehicleService vehicleService;
    private final UserService userService;

    public HomeController(EmployeeService employeeService, TransactionService transactionService,
                          VehicleService vehicleService, UserService userService) {
        this.employeeService = employeeService;
        this.transactionService = transactionService;
        this.vehicleService = vehicleService;
        this.userService = userService;
    }

    @GetMapping
    public String home(Model model, HttpServletRequest request){
        KeycloakAuthenticationToken principal = (KeycloakAuthenticationToken) request.getUserPrincipal();
        String userId = principal.getAccount().getKeycloakSecurityContext().getIdToken().getSubject();
        System.out.println(userId);
        userService.registerUser(userId); //dodanie uzytkownika do naszej dany jesli w niej nie istnieje
        userService.checkSubscription(userId); //Sprawdza czy subskrypcja jest nadal aktualna
        model.addAttribute("employeeList", employeeService.showEmployeesByUserId(userService.getUserById(userId)));
        model.addAttribute("vehicleList", vehicleService.showOurCompanyVehicles(userService.getUserById(userId)));
        model.addAttribute("transactionList", transactionService.showAssignedTransactions(userService.getUserById(userId)));
        return "homePage";
    }
}
