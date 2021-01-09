package main.main.Service;


import main.main.Model.User;
import main.main.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User getUserById(String userId){
        return userRepository.getOne(userId);
    }

    public Optional<User> getOne(String id){
        return userRepository.findById(id);
    }

    public void registerUser(String userId){
        if(userRepository.getByUserId(userId) == null) {
            User user = new User(userId);
            userRepository.save(user);
        }
    }

    public void updateUser(User user){
        Optional<User> oldUser = this.getOne(user.getUserId());
        oldUser.get().setSubscription(user.getSubscription());
        oldUser.get().setEmployees(user.getEmployees());
        //Jak robilem employeeRepository.save(employee) bez tego wyzej to klucze obce jako null mi ustawialo
        //dlatego zroiblem tak "brzydko"
        userRepository.save(oldUser.get());
    }

    public void checkSubscription(String userId){
        User user = getUserById(userId);
        LocalDate today = LocalDate.now();
        if(user.getSubscriptionEnd() == null) {
            System.out.println("Nie posiadasz subskrypcji");
        }else{
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
            LocalDate endDate = LocalDate.parse(user.getSubscriptionEnd(), dateTimeFormatter);

            if(today.isAfter(endDate)){
                user.setSubscription(null);
                user.setSubscriptionStart(null);
                user.setSubscriptionEnd(null);

                updateUser(user);
                System.out.println("Twoja subsckrypcja wygasla");
            }else{
                System.out.println("Subskrypcja aktualna");
            }
        }
    }
}
