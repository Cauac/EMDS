package by.vsu.emdsproject.repository;

import by.vsu.emdsproject.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Max
 *         Date: 23.03.13
 *         Time: 23:18
 */
public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
