package by.vsu.emdsproject.dao;

import by.vsu.emdsproject.model.Student;
import java.util.List;

public interface StudentDAO extends AbstractDAO<Student> {

    public void create(Student e);

    public Student read(Long id);

    public void update(Student e);

    public void delete(Student e);

    List<Student> getList();
}
