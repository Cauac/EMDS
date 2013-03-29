package by.vsu.emdsproject.service;

import by.vsu.emdsproject.model.Person;
import by.vsu.emdsproject.model.User;

import java.util.List;

public interface UserService extends AbstractService<User> {

    User addUserToPerson(String personType, Person person);

    User getByLogin(String login);

    User getStudentById(Long studentId);

    User getTeacherById(Long teacherId);

    List<User> getStudents();

    List<User> getTeachers();
}
