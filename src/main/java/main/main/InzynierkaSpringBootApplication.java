package main.main;

import main.main.Model.*;
import main.main.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


@SpringBootApplication
public class InzynierkaSpringBootApplication {
    private static UserService userService;
    private static EmployeeService employeeService;
    private static VehicleService vehicleService;
    private static TransactionService transactionService;
    private static SubscriptionService subscriptionService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Autowired
    public void setVehicleService(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @Autowired
    public void setTransactionService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Autowired
    public void setSubscriptionService(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx =
                SpringApplication.run(InzynierkaSpringBootApplication.class, args);

        List<Transaction> transactionList = new ArrayList<>();
        transactionList.add(new Transaction("Xayoo industries", 500f, "costam", "Warszawa", "Krakow"));
        transactionList.add(new Transaction("Essasto", 50f, "aaaa", "Warszawa", "Krakow"));
        transactionList.add(new Transaction("Rashfordzik", 50000f, "kozak", "Warszawa", "Krakow"));

        transactionService.addTransactions(transactionList);

        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(new Vehicle(VehicleType.Truck,  "WOR1231", 5000f, "01/01/2021", "Volvo", "05/05/2222"));
        vehicleList.add(new Vehicle(VehicleType.Van,  "WOR1121", 500f, "01/01/2021", "Polonez", "05/05/2222"));
        vehicleList.add(new Vehicle(VehicleType.Truck,  "WOR66666", 5000f, "01/01/2021", "Volvo", "05/05/2222"));

        vehicleService.addVehicles(vehicleList);

        List<User> userList = new ArrayList<>();
        userList.add(new User("Lukas", "Tolpenko", "lodovelove@wp.pl", "kozackie", "jutro"));
        userList.add(new User("Piotr", "Kotu", "kozak@wp.pl", "mocne123", "dzis"));

        List<Subscription> subscriptionList = new ArrayList<>();
        subscriptionList.add(new Subscription("Premium fchuj", 50000f, 32));
        subscriptionList.add(new Subscription("Medium rare", 500f, 32));
        subscriptionList.add(new Subscription("Darmowa (dla biedakow)", 0, 1000));

        subscriptionService.addSubscriptions(subscriptionList);

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, subscriptionList.get(0).getLength()); // dodaje dlugosc subskrypcji do dzisiejszej daty
        DateFormat date = DateFormat.getDateInstance(); //formatuje do czytelnej daty

        userList.get(0).setSubscription(subscriptionList.get(0));
        userList.get(0).setSubscriptionEndDate(date.format(calendar.getTime()));
        userService.addUsers(userList);

        Employee employee = new Employee("Adam", "Robota", 2500f, "Kierowca?");

        employeeService.addEmployee(employee, new EmployeeDetails(0, 0f));

        transactionService.assignTransaction(transactionList.get(0), employee, vehicleList.get(0));
        transactionService.assignTransaction(transactionList.get(1), employee, vehicleList.get(0));

        ctx.close();
    }
}