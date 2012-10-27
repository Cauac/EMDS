package by.vsu.emdsproject.dao.impl;

import by.vsu.emdsproject.dao.GroupDAO;
import by.vsu.emdsproject.model.Group;
import org.springframework.stereotype.Repository;

@Repository
public class GroupDAOImpl extends AbstractDAOImpl<Group> implements GroupDAO {

    public GroupDAOImpl() {
        setClazz(Group.class);
    }
}
