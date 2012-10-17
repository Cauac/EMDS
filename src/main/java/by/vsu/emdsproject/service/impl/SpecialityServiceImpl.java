/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package by.vsu.emdsproject.service.impl;

import by.vsu.emdsproject.dao.SpecialityDAO;
import by.vsu.emdsproject.model.Speciality;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Max
 */
public class SpecialityServiceImpl {
    
    @Autowired
    private SpecialityDAO specialityDAO;

    @Transactional
    public void addSpeciality(Speciality speciality) {
        specialityDAO.save(speciality);
    }

    @Transactional
    public List<Speciality> listSpeciality() {
        return specialityDAO.getList();
    }

    @Transactional
    public void removeSpeciality(Long id) {
        Speciality toDel = new Speciality();
        toDel.setId(id);
        specialityDAO.delete(toDel);
    }
    
}