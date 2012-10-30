package by.vsu.emdsproject.service.impl;

import by.vsu.emdsproject.dao.SubjectDAO;
import by.vsu.emdsproject.model.Subject;
import by.vsu.emdsproject.service.SubjectService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectDAO subjectDAO;

    public void addSubject(Subject subject) {
        subjectDAO.save(subject);
    }

    public List<Subject> listSubject() {
        return subjectDAO.findAll();
    }

    public Subject readSubject(Long id) {
        return subjectDAO.findOne(id);
    }

    public void removeSubject(Long id) {
        subjectDAO.deleteById(id);
    }

    public void removeSubject(Subject subject) {
        subjectDAO.delete(subject);
    }
}
