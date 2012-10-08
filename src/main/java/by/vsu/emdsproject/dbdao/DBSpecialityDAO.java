/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package by.vsu.emdsproject.dbdao;

import by.vsu.emdsproject.dao.SpecialityDAO;
import by.vsu.emdsproject.model.Speciality;
import java.util.List;

/**
 *
 * @author Max
 */
public class DBSpecialityDAO extends AbstractDBDAO<Speciality> implements SpecialityDAO{

    public void create(Speciality e) {
        sessionFactory.getCurrentSession().save(e);
    }

    public Speciality read(Long id) {
        //sessionFactory.getCurrentSession().createQuery("FROM Speciality"). 
        //return new Speciality();
    }

    public void update(Speciality e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void delete(Long id) {
        sessionFactory.getCurrentSession().delete(id);
    }

    public List<Speciality> getList() {
        return sessionFactory.getCurrentSession().
                createQuery("FROM Speciality").list();
    }

}
