package main.main.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import main.main.Model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    @Override
    Optional<User> findById(String userId);
    User getByUserId(String userId);
}
