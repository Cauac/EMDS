/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.vsu.emdsproject.dao;

import by.vsu.emdsproject.model.Group;
import java.util.List;

/**
 *
 * @author Max
 */
public interface GroupDAO extends AbstractDAO<Group> {
    public void create(Group e);
    public Group read(Long id);
    public void update(Group e);
    public void delete(Long id);
    List<Group> getList ();
}