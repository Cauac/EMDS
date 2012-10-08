/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.vsu.emdsproject.dao;

import by.vsu.emdsproject.model.Subject;
import java.util.List;

/**
 *
 * @author Max
 */
public interface SubjectDAO extends AbstractDAO<Subject> {

    public void create(Subject e);

    public Subject read(Long id);

    public void update(Subject e);

    public void delete(Long id);

    List<Subject> getList();
}
