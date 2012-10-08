/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.vsu.emdsproject.dbdao;

import by.vsu.emdsproject.dao.TeacherDAO;
import by.vsu.emdsproject.model.Teacher;
import java.util.List;

/**
 *
 * @author Max
 */
public class DBTeacherDAO extends AbstractDBDAO<Teacher> implements TeacherDAO {

    public void create(Teacher e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Teacher read(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void update(Teacher e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Teacher> getList() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
