package main.main.Controller;

import main.main.Model.Employee;
import main.main.Model.Transaction;
import main.main.Service.EmployeeService;
import main.main.Service.TransactionService;
import main.main.Service.UserService;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Secured("ROLE_USER")
@Controller
public class TransactionController {

    private final TransactionService transactionService;
    private final EmployeeService employeeService;
    private final UserService userService;

    public TransactionController(TransactionService transactionService, EmployeeService employeeService,
                                 UserService userService) {
        this.transactionService = transactionService;
        this.employeeService = employeeService;
        this.userService = userService;
    }

    @GetMapping("/allTransactions")
    public String showTransactions(Model model, HttpServletRequest request){
        List<Transaction> transactionList = new ArrayList<>();
        transactionList.add(new Transaction("Xayoo industries", 500f, 400f, LocalDate.of(2020,8, 5), LocalDate.of(2020,8,9), "Krakow", "Warszawa", "uwaga", "513-512-155", LocalDate.of(2020,8,8), LocalDate.of(2020,12,8)));
        transactionList.add(new Transaction("SBM", 200f, 100f, LocalDate.of(2020,8, 5), LocalDate.of(2020,8,6), "Krakow", "Warszawa", "uwaga", "505-102-011", LocalDate.of(2020,8,8), LocalDate.of(2020,12,8)));
        transactionList.add(new Transaction("BMW Company", 1200f, 1500f, LocalDate.of(2020,8, 5), LocalDate.of(2020,8,9), "Munich", "Warszawa", "M3", "666-111-222", LocalDate.of(2020,8,8), LocalDate.of(2020,12,8)));
        transactionList.add(new Transaction("Orlen", 500f, 400f, LocalDate.of(2020,10, 12), LocalDate.of(2020,8,9), "Warszawa", "Bialystok", "paliwko", "517-513-341", LocalDate.of(2020,8,8), LocalDate.of(2020,12,8)));

        transactionService.addTransactions(transactionList);

        KeycloakAuthenticationToken principal = (KeycloakAuthenticationToken) request.getUserPrincipal();

        model.addAttribute("transactionList", transactionService.showAssignedTransactions(userService.getUserById(principal.getAccount().getKeycloakSecurityContext().getIdToken().getSubject())));
        return "availableTransaction";
    }

    @GetMapping("/acceptTransaction")
    public String applyTransaction(Model model){
        model.addAttribute("transactionList", transactionService.showAvailableTransactions());
        return "acceptTransaction";
    }

    @GetMapping("/transaction/getOne")
    @ResponseBody
    public Optional<Transaction> getOne(Long Id){
        return transactionService.getOne(Id);
    }

    @GetMapping("/assign")
    public String showBeforeAssignTransaction(Long Id, Model model, HttpServletRequest request){
        KeycloakAuthenticationToken principal = (KeycloakAuthenticationToken) request.getUserPrincipal();
        model.addAttribute("transaction", transactionService.getOne(Id));
        model.addAttribute("employeeList", employeeService.getEmployeesByUserId(userService.getUserById(principal.getAccount().getKeycloakSecurityContext().getIdToken().getSubject())));
        return "transactionView";
    }

    @PostMapping("/assign")
    public String assignTransaction(@ModelAttribute Employee employee, @ModelAttribute Transaction transaction, BindingResult bindingResult){
        System.out.println(employee.toString()+ " --EMPLO");
        System.out.println(transaction.toString()+ " ---TRANS");
        if(bindingResult.hasErrors()) {
            return "redirect:/allTransactions";
        }else
            transactionService.assign(transaction, employee);
            return "homePage";
    }
}
