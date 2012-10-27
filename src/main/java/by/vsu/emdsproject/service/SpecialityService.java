package by.vsu.emdsproject.service;

import by.vsu.emdsproject.model.Speciality;
import java.util.List;

public interface SpecialityService {
    
    public void addSpeciality(Speciality speciality);
    public List<Speciality> listSpeciality();
    public Speciality readSpeciality (Long id);
    public void removeSpeciality(Long id);
    
    
}
