package by.vsu.emdsproject.service.impl;

import by.vsu.emdsproject.common.PasswordUtils;
import by.vsu.emdsproject.common.Transliterator;
import by.vsu.emdsproject.dao.RoleDAO;
import by.vsu.emdsproject.dao.StudentDAO;
import by.vsu.emdsproject.dao.UserDAO;
import by.vsu.emdsproject.model.*;
import by.vsu.emdsproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO studentDAO;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private RoleDAO roleDAO;

    @Transactional
    public void add(Student student) {
        studentDAO.save(student);
    }

    @Transactional
    public void add(Student s, Date d, Group g, Questionnaire q) {
        s.toStudent();
        s.setQuestionnaire(q);
        q.setStudent(s);
        s.setBirthDate(d);
        s.setGroup(g);
        studentDAO.save(s);

        Role role = roleDAO.getByName(Role.STUDENT);
        String username = Transliterator.transliterate(s.getLastName()
                + s.getFirstName().charAt(0) + s.getMiddleName().charAt(0));
        User user = new User(s.getId(), "student", username,
                PasswordUtils.encode("12345"), 1, role);
        user.setDefaultPassword(true);
        userDAO.save(user);
    }

    @Transactional
    public void transformAbiturientToStudent(Student s) {
        s.toStudent();
        studentDAO.save(s);
        Role role = roleDAO.getByName(Role.STUDENT);
        String username = Transliterator.transliterate(s.getLastName()
                + s.getFirstName().charAt(0) + s.getMiddleName().charAt(0));
        User user = new User(s.getId(), "student", username,
                PasswordUtils.encode("12345"), 1, role);
        user.setDefaultPassword(true);
        userDAO.save(user);
    }

    @Transactional
    public void update(Student student) {
        studentDAO.update(student);
    }

    @Transactional(readOnly = true)
    public List<Student> list() {
        return studentDAO.findAll();
    }

    @Transactional(readOnly = true)
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

    @Transactional
    public List<Student> getStudents() {
        return studentDAO.getStudents();
    }

    @Transactional
    public List<Student> getAbiturients() {
        return studentDAO.getAbiturients();
    }
}
