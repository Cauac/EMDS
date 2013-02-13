package by.vsu.emdsproject.dao.impl;

import by.vsu.emdsproject.dao.UserDAO;
import by.vsu.emdsproject.model.User;
import java.util.List;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl extends AbstractDAOImpl<User> implements UserDAO {

    public UserDAOImpl() {
        super();
        setClazz(User.class);
    }

    public User getUserByLogin(String login) {
        return (User) getCurrentSession().createCriteria(User.class)
                .add(Restrictions.like("login", login)).uniqueResult();
    }

    public List<User> getStudents() {
        return getCurrentSession().createCriteria(User.class)
                .add(Restrictions.like("personType", "student")).list();
    }

    public List<User> getTeachers() {
        return getCurrentSession().createCriteria(User.class)
                .add(Restrictions.like("personType", "teacher")).list();
    }

    public User getByStudentId(Long personId) {
        return (User) getCurrentSession().createCriteria(User.class)
                .add(Restrictions.eq("personId", personId))
                .add(Restrictions.like("personType", "student")).uniqueResult();
    }

    public User getByTeacherId(Long personId) {
        return (User) getCurrentSession().createCriteria(User.class)
                .add(Restrictions.eq("personId", personId))
                .add(Restrictions.like("personType", "teacher")).uniqueResult();
    }
}
