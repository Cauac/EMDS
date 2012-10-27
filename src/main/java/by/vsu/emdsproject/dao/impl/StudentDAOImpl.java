package by.vsu.emdsproject.dao.impl;

import by.vsu.emdsproject.dao.StudentDAO;
import by.vsu.emdsproject.model.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAOImpl extends AbstractDAOImpl<Student> implements StudentDAO {

    public StudentDAOImpl() {
        setClazz(Student.class);
    }
}
