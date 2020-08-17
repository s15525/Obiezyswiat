package main.main.Controller;

import main.main.Model.Employee;
import main.main.Model.EmployeeDetails;
import main.main.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/allEmployees")
    public String showEmployees(Model model){
        model.addAttribute("employeeList", employeeService.showAllEmployees());
        return "employee";
    }

    @GetMapping("/addEmployee")
    public String employee(Model model){
        model.addAttribute("employee", new Employee());
        return "addEmployee";
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@ModelAttribute @Valid Employee employee, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return "addEmployee";
        }else{
            employeeService.addEmployee(employee, new EmployeeDetails(0, 0f));
            return "homePage";
        }
    }
}