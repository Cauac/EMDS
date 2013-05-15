package by.vsu.emdsproject.repository;

import by.vsu.emdsproject.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Max
 *         Date: 23.03.13
 *         Time: 23:19
 */
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    List<Teacher> findByChief(Boolean chief);
}
