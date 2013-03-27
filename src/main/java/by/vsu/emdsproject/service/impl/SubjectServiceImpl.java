package by.vsu.emdsproject.service.impl;

import by.vsu.emdsproject.model.Subject;
import by.vsu.emdsproject.repository.SubjectRepository;
import by.vsu.emdsproject.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Transactional
    public void add(Subject subject) {
        subjectRepository.save(subject);
    }

    @Transactional
    public void update(Subject subject) {
        subjectRepository.save(subject);
    }

    @Transactional(readOnly = true)
    public List<Subject> list() {
        return subjectRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Subject read(Long id) {
        return subjectRepository.findOne(id);
    }

    @Transactional
    public void remove(Long id) {
        subjectRepository.delete(id);
    }

    @Transactional
    public void remove(Subject subject) {
        subjectRepository.delete(subject);
    }
}
