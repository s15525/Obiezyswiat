package main.main.Controller;

import main.main.Service.EmployeeService;
import main.main.Service.TransactionService;
import main.main.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    private EmployeeService employeeService;
    private TransactionService transactionService;
    private VehicleService vehicleService;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Autowired
    public void setTransactionService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Autowired
    public void setVehicleService(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @RequestMapping("/home" +
            "")
    public String home(Model model){
        model.addAttribute("employeeList", employeeService.showAllEmployees());
        model.addAttribute("vehicleList", vehicleService.showAllVehicles());
        model.addAttribute("transactionList", transactionService.showInProgrssTransactions());
        return "homePage";
    }
}
