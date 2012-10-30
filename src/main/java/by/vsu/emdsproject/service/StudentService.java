package by.vsu.emdsproject.service;

import by.vsu.emdsproject.model.Student;
import java.util.List;

public interface StudentService {

    public void addStudent(Student student);

    public List<Student> listStudent();

    public Student readStudent(Long id);

    public void removeStudent(Long id);

    public void removeStudent(Student student);
}
