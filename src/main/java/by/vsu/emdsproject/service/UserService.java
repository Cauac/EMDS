package by.vsu.emdsproject.service;

import by.vsu.emdsproject.model.User;

import java.util.List;

public interface UserService extends AbstractService<User> {

    void addUser(String personType, Long personId);

    User getByLogin(String login);

    User getByStudentId(Long personId);

    User getByTeacherId(Long personId);

    List<User> getStudents();

    List<User> getTeachers();
}
