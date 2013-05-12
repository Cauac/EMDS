package by.vsu.emdsproject.service;

import by.vsu.emdsproject.model.Group;
import by.vsu.emdsproject.model.Specialty;

import java.util.List;

public interface GroupService extends AbstractService<Group> {

    public List<Group> findBySpecialty(Specialty specialty);
}
