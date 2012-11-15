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
        List<User> list = getCurrentSession().createCriteria(User.class).add(Restrictions.like("login", login)).list();
        return list.get(0);
    }

    public List<User> getStudents() {
        return getCurrentSession().createCriteria(User.class).add(Restrictions.like("personType", "student")).list();
    }

    public List<User> getTeachers() {
        return getCurrentSession().createCriteria(User.class).add(Restrictions.like("personType", "teacher")).list();
    }

    public User getByPersonId(Long personId) {
        List<User> list = getCurrentSession().createCriteria(User.class).add(Restrictions.eq("personId", personId)).list();
        return list.get(0);
    }
}
