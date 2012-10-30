package by.vsu.emdsproject.service;

import by.vsu.emdsproject.model.Teacher;
import java.util.List;

public interface TeacherService {

    public void addTeacher(Teacher teacher);

    public List<Teacher> listTeacher();

    public Teacher readTeacher(Long id);

    public void removeTeacher(Long id);

    public void removeTeacher(Teacher teacher);
}
