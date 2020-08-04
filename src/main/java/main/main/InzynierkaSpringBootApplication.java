package main.main;

import main.main.Model.*;
import main.main.Repository.EmployeeRepository;
import main.main.Repository.EmpolyeeDetailsRepository;
import main.main.Repository.TransactionRepository;
import main.main.Repository.VehicleRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

//@Configuration
//@EnableAutoConfiguration
//@ComponentScan({"main.main.Repository","main.main.Controller"})
@SpringBootApplication
public class InzynierkaSpringBootApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx =
                SpringApplication.run(InzynierkaSpringBootApplication.class, args);
//        List<Employee> employees = new ArrayList<>();
//        employees.add(new Employee("Jan", "Nowak", 5000f, "Kierowca"));
//        employees.add(new Employee("Piotr", "Duda", 5500f, "Kierowca"));
//
//        List<Vehicle> vehicles = new ArrayList<>();
//        vehicles.add(new Vehicle(VehicleType.Truck, "WE4512", 5000f, "22", "Volvo", "22"));
//        vehicles.add(new Vehicle(VehicleType.Truck, "WE5012", 5010f, "22", "Volvo", "222"));
//
//        List<Transaction> transactions = new ArrayList<>();
//        transactions.add(new Transaction("Ekipa", 500f, "nie wiem po co ta zmienna chyba :dd", "Warszawa", "Krakow"));
//        transactions.add(new Transaction("Ekipa", 10000f, "koks dla friza", "Warszawa", "Krakow"));
//        transactions.add(new Transaction("Ekipa", 500f, "nie wiem po co ta zmienna chyba :dd", "Warszawa", "Krakow"));
//        transactions.add(new Transaction("Ekipa", 10000f, "koks dla friza", "Warszawa", "Krakow"));
//        transactions.add(new Transaction("MajorKonon", 1000000f, "Asterka boza?", "Warszawa", "Bialystok"));
//        transactions.get(0).setEmployee(employees.get(0));
//        transactions.get(1).setEmployee(employees.get(1));
//        transactions.get(0).setVehicle(vehicles.get(0));
//        transactions.get(1).setVehicle(vehicles.get(1));
//        transactions.get(2).setEmployee(employees.get(0));
//        transactions.get(3).setEmployee(employees.get(1));
//        transactions.get(2).setVehicle(vehicles.get(0));
//        transactions.get(3).setVehicle(vehicles.get(1));
//
//        List<EmployeeDetails> employeeDetails = new ArrayList<>();
//
//
//      //  employees.get(0).setEmployeeDetails(employeeDetails.get(0));
//      //  employees.get(1).setEmployeeDetails(employeeDetails.get(1));
//
//     //   EmpolyeeDetailsRepository empolyeeDetailsRepository = ctx.getBean(EmpolyeeDetailsRepository.class);
//      //  employeeDetails.forEach(empolyeeDetailsRepository::save);
//
//        EmployeeRepository employeeRepository = ctx.getBean(EmployeeRepository.class);
//        employees.forEach(employeeRepository::save);
//
//        VehicleRepository vehicleRepository = ctx.getBean(VehicleRepository.class);
//        vehicles.forEach(vehicleRepository::save);
//
//        TransactionRepository transactionRepository = ctx.getBean(TransactionRepository.class);
//        transactions.forEach(transactionRepository::save);
//
//        List<Vehicle> vehicles1 = vehicleRepository.findAllByBrand("Volvo");
//        vehicles1.forEach(System.out::println);
//
//      //  transactionRepository.namesForSalaryAsc(2)
//        //        .forEach(System.out::println);
//
//
//        ctx.close();
    }
}
