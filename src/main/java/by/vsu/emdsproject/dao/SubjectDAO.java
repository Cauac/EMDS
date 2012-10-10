package by.vsu.emdsproject.dao;

import by.vsu.emdsproject.model.Subject;
import java.util.List;

public interface SubjectDAO extends AbstractDAO<Subject> {

    public void create(Subject e);

    public Subject read(Long id);

    public void update(Subject e);

    public void delete(Subject e);

    List<Subject> getList();
}
