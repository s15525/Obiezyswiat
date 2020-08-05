package main.main.Service;

import main.main.Model.Subscription;
import main.main.Model.User;
import main.main.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public void addUser(User user){
        user.setPassword(passwordEncoder().encode(user.getPassword()));// Hashowanie hasla
        userRepository.save(user);
    }

    public void addUsers(List<User> userList){
        userList.forEach(userRepository::save);
    }

    public void assignSubscription(User user, Subscription subscription){
        user.setSubscription(subscription);
        userRepository.save(user);
    }

    public boolean loginUserValidation(String email, String password){
        User user = userRepository.getByEmail(email);
        boolean result = false;

        if(user == null)
            System.err.println("Bledny email");
        else
            result = user.getPassword().equals(password);

        if(!result)
            System.err.println("Bledne haslo");

        return result;
    }
}
