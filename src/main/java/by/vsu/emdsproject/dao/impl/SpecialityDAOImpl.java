package by.vsu.emdsproject.dao.impl;

import by.vsu.emdsproject.dao.SpecialityDAO;
import by.vsu.emdsproject.model.Speciality;
import org.springframework.stereotype.Repository;

@Repository
public class SpecialityDAOImpl extends AbstractDAOImpl<Speciality> implements SpecialityDAO {

    public SpecialityDAOImpl() {
        super();
        setClazz(Speciality.class);
    }
}
