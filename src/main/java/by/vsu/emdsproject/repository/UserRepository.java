package by.vsu.emdsproject.repository;

import by.vsu.emdsproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Max
 *         Date: 23.03.13
 *         Time: 23:21
 */
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByPersonType(String personType);

    User findByPersonTypeAndId(String personType, Long id);

    User findByLogin(String login);
}
