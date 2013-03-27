package by.vsu.emdsproject.repository;

import by.vsu.emdsproject.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Max
 *         Date: 27.03.13
 *         Time: 22:54
 */
public interface GroupRepository extends JpaRepository<Group, Long> {
}
