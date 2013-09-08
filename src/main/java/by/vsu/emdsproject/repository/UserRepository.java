package by.vsu.emdsproject.repository;

import by.vsu.emdsproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByPersonType(String personType);

    User findByPersonTypeAndPersonId(String personType, Long personId);

    User findByLogin(String login);
}
