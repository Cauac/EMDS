package by.vsu.emdsproject.repository;

import by.vsu.emdsproject.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Max
 *         Date: 23.03.13
 *         Time: 23:17
 */
public interface StudentRepository extends JpaRepository<Student, Long> {
}
