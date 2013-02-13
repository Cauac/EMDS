package by.vsu.emdsproject.dao;

import by.vsu.emdsproject.model.Student;
import java.util.List;

public interface StudentDAO extends AbstractDAO<Student> {
    
    List<Student> getStudents();
    List<Student> getAbiturients();
    
}
