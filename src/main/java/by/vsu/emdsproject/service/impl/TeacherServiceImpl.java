package by.vsu.emdsproject.service.impl;

import by.vsu.emdsproject.dao.TeacherDAO;
import by.vsu.emdsproject.model.Teacher;
import by.vsu.emdsproject.service.TeacherService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDAO teacherDAO;

    @Transactional
    public void addTeacher(Teacher teacher) {
        teacherDAO.save(teacher);
    }

    @Transactional
    public List<Teacher> listTeacher() {
        return teacherDAO.findAll();
    }

    @Transactional
    public Teacher readTeacher(Long id) {
        return teacherDAO.findOne(id);
    }

    @Transactional
    public void removeTeacher(Long id) {
        teacherDAO.deleteById(id);
    }

    @Transactional
    public void removeTeacher(Teacher teacher) {
        teacherDAO.delete(teacher);
    }
}
