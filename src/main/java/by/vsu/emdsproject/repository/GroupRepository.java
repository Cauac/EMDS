package by.vsu.emdsproject.repository;

import by.vsu.emdsproject.model.Group;
import by.vsu.emdsproject.model.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Long> {

    public List<Group> findBySpecialty(Specialty specialty);
}
