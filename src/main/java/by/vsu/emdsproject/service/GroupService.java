/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.vsu.emdsproject.service;

import by.vsu.emdsproject.model.Group;
import java.util.List;

/**
 *
 * @author Max
 */
public interface GroupService {

    public void addGroup(Group group);
    public List<Group> listGroup();
    public void removeGroup(Long id);
    
}
