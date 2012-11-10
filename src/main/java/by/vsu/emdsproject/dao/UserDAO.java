package by.vsu.emdsproject.dao;

import by.vsu.emdsproject.model.User;
import java.util.List;

public interface UserDAO extends AbstractDAO<User> {
    User getUserByLogin (String login);
    List<User> getStudents ();
    List<User> getTeachers ();
}
