/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.vsu.emdsproject.dbdao;

import by.vsu.emdsproject.dao.GroupDAO;
import by.vsu.emdsproject.model.Group;
import java.util.List;

/**
 *
 * @author Max
 */
public class DBGroupDAO extends AbstractDBDAO<Group> implements GroupDAO {

    public void create(Group e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Group read(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void update(Group e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Group> getList() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
