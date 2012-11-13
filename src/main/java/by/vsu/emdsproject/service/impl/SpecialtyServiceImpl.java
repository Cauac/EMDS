package by.vsu.emdsproject.service.impl;

import by.vsu.emdsproject.dao.SpecialtyDAO;
import by.vsu.emdsproject.model.Specialty;
import by.vsu.emdsproject.service.SpecialtyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SpecialtyServiceImpl implements SpecialtyService {

    @Autowired
    private SpecialtyDAO specialtyDAO;

    @Transactional
    public void add(Specialty specialty) {
        specialtyDAO.save(specialty);
    }
    
    @Transactional
    public void update(Specialty specialty) {
        specialtyDAO.update(specialty);
    }

    @Transactional
    public List<Specialty> list() {
        return specialtyDAO.findAll();
    }

    @Transactional
    public Specialty read(Long id) {
        return specialtyDAO.findOne(id);
    }

    @Transactional
    public void remove(Long id) {
        specialtyDAO.deleteById(id);
    }

    @Transactional
    public void remove(Specialty specialty) {
        specialtyDAO.delete(specialty);
    }
}
