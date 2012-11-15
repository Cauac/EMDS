package by.vsu.emdsproject.service.impl;

import by.vsu.emdsproject.dao.StudentDAO;
import by.vsu.emdsproject.model.Student;
import by.vsu.emdsproject.service.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO studentDAO;

    @Transactional
    public void add(Student student) {
        studentDAO.save(student);
    }

    @Transactional
    public void update(Student student) {
        studentDAO.update(student);
    }

    @Transactional
    public List<Student> list() {
        return studentDAO.findAll();
    }

    @Transactional
    public Student read(Long id) {
        return studentDAO.findOne(id);
    }

    @Transactional
    public void remove(Long id) {
        studentDAO.deleteById(id);
    }

    @Transactional
    public void remove(Student student) {
        studentDAO.delete(student);
    }
}
