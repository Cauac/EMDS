package by.vsu.emdsproject.service;

import by.vsu.emdsproject.model.User;
import java.util.List;

public interface UserService extends AbstractService<User> {

    User getByLogin(String login);

    User getByPersonId(Long personId);

    List<User> getStudents();

    List<User> getTeachers();
}
