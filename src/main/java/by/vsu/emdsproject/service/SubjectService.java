package by.vsu.emdsproject.service;

import by.vsu.emdsproject.model.Subject;
import java.util.List;

public interface SubjectService {

    public void addSubject(Subject subject);

    public List<Subject> listSubject();

    public Subject readSubject(Long id);

    public void removeSubject(Long id);

    public void removeSubject(Subject subject);
}
