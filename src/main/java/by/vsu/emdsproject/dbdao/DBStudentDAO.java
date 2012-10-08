/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package by.vsu.emdsproject.dbdao;

import by.vsu.emdsproject.dao.StudentDAO;
import by.vsu.emdsproject.model.Student;
import java.util.List;

/**
 *
 * @author Max
 */
public class DBStudentDAO extends AbstractDBDAO<Student> implements StudentDAO{

    public void create(Student e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Student read(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void update(Student e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Student> getList() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
