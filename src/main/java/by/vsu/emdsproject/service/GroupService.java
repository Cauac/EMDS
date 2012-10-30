package by.vsu.emdsproject.service;

import by.vsu.emdsproject.model.Group;
import java.util.List;

public interface GroupService {

    public void addGroup(Group group);

    public List<Group> listGroup();

    public Group readGroup(Long id);

    public void removeGroup(Long id);

    public void removeGroup(Group group);
}
