package by.vsu.emdsproject.service.impl;

import by.vsu.emdsproject.model.Specialty;
import by.vsu.emdsproject.repository.SpecialtyRepository;
import by.vsu.emdsproject.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SpecialtyServiceImpl implements SpecialtyService {

    @Autowired
    private SpecialtyRepository specialtyRepository;

    @Override
    public Specialty save(Specialty specialty) {
        return specialtyRepository.save(specialty);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Specialty> list() {
        return specialtyRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Specialty read(Long id) {
        return specialtyRepository.findOne(id);
    }

    @Override
    public void remove(Long id) {
        specialtyRepository.delete(id);
    }

    @Override
    public void remove(Specialty specialty) {
        specialtyRepository.delete(specialty);
    }
}
