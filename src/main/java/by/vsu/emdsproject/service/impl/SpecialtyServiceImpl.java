package by.vsu.emdsproject.service.impl;

import by.vsu.emdsproject.model.Specialty;
import by.vsu.emdsproject.repository.SpecialtyRepository;
import by.vsu.emdsproject.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SpecialtyServiceImpl implements SpecialtyService {

    @Autowired
    private SpecialtyRepository specialtyRepository;

    @Transactional
    public void add(Specialty specialty) {
        specialtyRepository.save(specialty);
    }

    @Transactional
    public void update(Specialty specialty) {
        specialtyRepository.save(specialty);
    }

    @Transactional(readOnly = true)
    public List<Specialty> list() {
        return specialtyRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Specialty read(Long id) {
        return specialtyRepository.findOne(id);
    }

    @Transactional
    public void remove(Long id) {
        specialtyRepository.delete(id);
    }

    @Transactional
    public void remove(Specialty specialty) {
        specialtyRepository.delete(specialty);
    }
}
