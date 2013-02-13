package by.vsu.emdsproject.service.impl;

import by.vsu.emdsproject.dao.GroupDAO;
import by.vsu.emdsproject.model.Group;
import by.vsu.emdsproject.service.GroupService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupDAO groupDAO;

    @Transactional
    public void add(Group group) {
        groupDAO.save(group);
    }

    @Transactional
    public void update(Group group) {
        groupDAO.update(group);
    }

    @Transactional(readOnly=true)
    public List<Group> list() {
        return groupDAO.findAll();
    }

    @Transactional(readOnly=true)
    public Group read(Long id) {
        return groupDAO.findOne(id);
    }

    @Transactional
    public void remove(Long id) {
        groupDAO.deleteById(id);
    }

    @Transactional
    public void remove(Group group) {
        groupDAO.delete(group);
    }
}
