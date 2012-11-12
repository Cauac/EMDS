package by.vsu.emdsproject.dao.impl;

import by.vsu.emdsproject.dao.SpecialtyDAO;
import by.vsu.emdsproject.model.Specialty;
import org.springframework.stereotype.Repository;

@Repository
public class SpecialtyDAOImpl extends AbstractDAOImpl<Specialty> implements SpecialtyDAO {

    public SpecialtyDAOImpl() {
        super();
        setClazz(Specialty.class);
    }
}
