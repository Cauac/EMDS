/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.vsu.emdsproject.dao;

import by.vsu.emdsproject.model.Teacher;
import java.util.List;

/**
 *
 * @author Max
 */
public interface TeacherDAO extends AbstractDAO<Teacher> {

    public void create(Teacher e);

    public Teacher read(Long id);

    public void update(Teacher e);

    public void delete(Teacher e);

    List<Teacher> getList();
}
