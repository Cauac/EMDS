package by.vsu.emdsproject.service.impl;

import by.vsu.emdsproject.dao.SpecialityDAO;
import by.vsu.emdsproject.model.Speciality;
import by.vsu.emdsproject.service.SpecialityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SpecialityServiceImpl implements SpecialityService {

    @Autowired
    private SpecialityDAO specialityDAO;

    @Transactional
    public void addSpeciality(Speciality speciality) {
        specialityDAO.save(speciality);
    }

    @Transactional
    public List<Speciality> listSpeciality() {
        return specialityDAO.findAll();
    }

    @Transactional
    public Speciality readSpeciality(Long id) {
        return specialityDAO.findOne(id);
    }

    @Transactional
    public void removeSpeciality(Long id) {
        specialityDAO.deleteById(id);
    }

    @Transactional
    public void removeSpeciality(Speciality speciality) {
        specialityDAO.delete(speciality);
    }
}
