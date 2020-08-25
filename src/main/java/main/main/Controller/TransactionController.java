package main.main.Controller;

import main.main.Model.Employee;
import main.main.Model.Transaction;
import main.main.Service.EmployeeService;
import main.main.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.validation.Valid;

@Controller
public class TransactionController {

    private TransactionService transactionService;
    private EmployeeService employeeService;

    @Autowired
    public void setTransactionService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/allTransactions")
    public String showTransactions(Model model){
        model.addAttribute("transactionList", transactionService.showAvailableTransactions());
        return "availableTransaction";
    }

    @GetMapping("/acceptTransaction")
    public String applyTransaction(Model model){
        model.addAttribute("transactionList", transactionService.showAvailableTransactions());
        return "acceptTransaction";
    }

    public String acceptTransaction(@ModelAttribute @Valid Transaction transaction, Employee employee, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "acceptTransaction";
        else{

            return "homePage";
        }
    }


}
