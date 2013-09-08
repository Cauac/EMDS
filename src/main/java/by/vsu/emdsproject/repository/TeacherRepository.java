package by.vsu.emdsproject.repository;

import by.vsu.emdsproject.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    List<Teacher> findByChief(Boolean chief);
}
