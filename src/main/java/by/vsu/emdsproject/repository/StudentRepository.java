package by.vsu.emdsproject.repository;

import by.vsu.emdsproject.model.Group;
import by.vsu.emdsproject.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByType(String type);

    List<Student> findByGroup(Group group);

    List<Student> findByQuestionnaireFacultyAndType(String faculty, String type);

}
