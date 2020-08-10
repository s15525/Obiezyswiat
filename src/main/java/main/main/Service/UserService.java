package main.main.Service;

import main.main.Model.Role;
import main.main.Model.Subscription;
import main.main.Model.User;
import main.main.Repository.RoleRepository;
import main.main.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private static final String DEFAULT_ROLE = "Client";
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private List<Role> roles = new ArrayList<>();

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Autowired
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public void addUser(User user){
        if(roleRepository.findByRoleName(DEFAULT_ROLE) == null) {
            roles.add(new Role("Client", "cos tam moze"));
            roles.add(new Role("Admin", "Wladza absolutna"));
            roles.forEach(roleRepository::save);
        }
        Role defaultRole = roleRepository.findByRoleName(DEFAULT_ROLE);

        user.setRole(defaultRole);
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
}
