/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.vsu.emdsproject.dao;

import by.vsu.emdsproject.model.Speciality;
import java.util.List;

/**
 *
 * @author Max
 */
public interface SpecialityDAO extends AbstractDAO<Speciality> {

    public void create(Speciality e);
    public Speciality read(Long id);
    public void update(Speciality e);
    public void delete(Long id);
    List<Speciality> getList ();
}
