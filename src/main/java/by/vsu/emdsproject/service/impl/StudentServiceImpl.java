package by.vsu.emdsproject.service.impl;

import by.vsu.emdsproject.dao.StudentDAO;
import by.vsu.emdsproject.model.Student;
import by.vsu.emdsproject.service.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO studentDAO;

    @Transactional
    public void addStudent(Student student) {
        studentDAO.save(student);
    }

    @Transactional
    public List<Student> listStudent() {
        return studentDAO.findAll();
    }

    @Transactional
    public Student readStudent(Long id) {
        return studentDAO.findOne(id);
    }

    @Transactional
    public void removeStudent(Long id) {
        studentDAO.deleteById(id);
    }

    @Transactional
    public void removeStudent(Student student) {
        studentDAO.delete(student);
    }
}
