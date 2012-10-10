/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.vsu.emdsproject.dao;

import by.vsu.emdsproject.model.Student;
import java.util.List;

/**
 *
 * @author Max
 */
public interface StudentDAO extends AbstractDAO<Student> {

    public void create(Student e);

    public Student read(Long id);

    public void update(Student e);

    public void delete(Student e);

    List<Student> getList();
}
