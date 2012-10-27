/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.vsu.emdsproject.dao.impl;

import by.vsu.emdsproject.dao.SpecialityDAO;
import by.vsu.emdsproject.model.Speciality;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Max
 */
@Repository
public class SpecialityDAOImpl extends AbstractDAOImpl<Speciality> implements SpecialityDAO {

    public SpecialityDAOImpl() {
        setClazz(Speciality.class);
    }

}
