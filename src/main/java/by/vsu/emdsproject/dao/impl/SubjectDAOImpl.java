package by.vsu.emdsproject.dao.impl;

import by.vsu.emdsproject.dao.SubjectDAO;
import by.vsu.emdsproject.model.Subject;
import org.springframework.stereotype.Repository;

@Repository
public class SubjectDAOImpl extends AbstractDAOImpl<Subject> implements SubjectDAO {

    public SubjectDAOImpl() {
        super();
        setClazz(Subject.class);
    }
}
