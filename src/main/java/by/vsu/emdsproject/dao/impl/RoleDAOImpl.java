package by.vsu.emdsproject.dao.impl;

import by.vsu.emdsproject.dao.RoleDAO;
import by.vsu.emdsproject.model.Role;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDAOImpl extends AbstractDAOImpl<Role> implements RoleDAO {

    public RoleDAOImpl() {
        super();
        setClazz(Role.class);
    }

    public Role getByName(String name) {
        return (Role) getCurrentSession().createCriteria(Role.class)
                .add(Restrictions.like("authority", name)).uniqueResult();
    }
}
