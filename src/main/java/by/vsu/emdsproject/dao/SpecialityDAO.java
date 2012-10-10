package by.vsu.emdsproject.dao;

import by.vsu.emdsproject.model.Speciality;
import java.util.List;

public interface SpecialityDAO extends AbstractDAO<Speciality> {

    public void create(Speciality e);

    public Speciality read(Long id);

    public void update(Speciality e);

    public void delete(Speciality e);

    List<Speciality> getList();
}
