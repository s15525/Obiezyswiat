package main.main.Service;

import main.main.Repository.EmployeeDetailsRepository;
import main.main.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDetailsService {

    private EmployeeDetailsRepository employeeDetailsRepository;

    @Autowired
    public void setEmployeeDetailsRepository(EmployeeDetailsRepository employeeDetailsRepository) {
        this.employeeDetailsRepository = employeeDetailsRepository;
    }

}
