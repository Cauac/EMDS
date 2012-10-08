/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package by.vsu.emdsproject.dbdao;

import by.vsu.emdsproject.dao.SubjectDAO;
import by.vsu.emdsproject.model.Subject;
import java.util.List;

/**
 *
 * @author Max
 */
public class DBSubjectDAO extends AbstractDBDAO<Subject> implements SubjectDAO{

    public void create(Subject e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Subject read(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void update(Subject e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Subject> getList() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
