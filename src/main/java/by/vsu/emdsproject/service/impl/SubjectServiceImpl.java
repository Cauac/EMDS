package by.vsu.emdsproject.service.impl;

import by.vsu.emdsproject.dao.SubjectDAO;
import by.vsu.emdsproject.model.Subject;
import by.vsu.emdsproject.service.SubjectService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectDAO subjectDAO;

    @Transactional
    public void add(Subject subject) {
        subjectDAO.save(subject);
    }

    @Transactional
    public void update(Subject subject) {
        subjectDAO.update(subject);
    }

    @Transactional
    public List<Subject> list() {
        return subjectDAO.findAll();
    }

    @Transactional
    public Subject read(Long id) {
        return subjectDAO.findOne(id);
    }

    @Transactional
    public void remove(Long id) {
        subjectDAO.deleteById(id);
    }

    @Transactional
    public void remove(Subject subject) {
        subjectDAO.delete(subject);
    }
}
