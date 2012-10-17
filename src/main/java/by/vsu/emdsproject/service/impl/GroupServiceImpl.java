/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package by.vsu.emdsproject.service.impl;

import by.vsu.emdsproject.dao.GroupDAO;
import by.vsu.emdsproject.model.Group;
import by.vsu.emdsproject.service.GroupService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Max
 */
@Service
public class GroupServiceImpl implements GroupService{
    
    @Autowired
    private GroupDAO groupDAO;

    @Transactional
    public void addGroup(Group group) {
        groupDAO.save(group);
    }

    @Transactional
    public List<Group> listGroup() {
        return groupDAO.getList();
    }

    @Transactional
    public void removeGroup(Long id) {
        Group toDel = new Group();
        toDel.setId(id);
        groupDAO.delete(toDel);
    }

}