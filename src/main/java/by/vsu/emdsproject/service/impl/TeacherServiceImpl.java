package by.vsu.emdsproject.service.impl;

import by.vsu.emdsproject.dao.TeacherDAO;
import by.vsu.emdsproject.model.Teacher;
import by.vsu.emdsproject.service.TeacherService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDAO teacherDAO;

    public void addTeacher(Teacher teacher) {
        teacherDAO.save(teacher);
    }

    public List<Teacher> listTeacher() {
        return teacherDAO.findAll();
    }

    public Teacher readTeacher(Long id) {
        return teacherDAO.findOne(id);
    }

    public void removeTeacher(Long id) {
        teacherDAO.deleteById(id);
    }

    public void removeTeacher(Teacher teacher) {
        teacherDAO.delete(teacher);
    }
}
