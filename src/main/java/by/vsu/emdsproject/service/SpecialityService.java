/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.vsu.emdsproject.service;

import by.vsu.emdsproject.model.Speciality;
import java.util.List;

/**
 *
 * @author Max
 */
public interface SpecialityService {
    
    public void addSpeciality(Speciality speciality);
    public List<Speciality> listSpeciality();
    public Speciality readSpeciality (Long id);
    public void removeSpeciality(Long id);
    
    
}
