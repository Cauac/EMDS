package by.vsu.emdsproject.dao;

import by.vsu.emdsproject.model.Group;
import java.util.List;

public interface GroupDAO extends AbstractDAO<Group> {

    public void create(Group e);

    public Group read(Long id);

    public void update(Group e);

    public void delete(Group e);

    List<Group> getList();
}