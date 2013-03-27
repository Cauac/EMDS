package by.vsu.emdsproject.repository;

import by.vsu.emdsproject.model.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Max
 *         Date: 23.03.13
 *         Time: 23:16
 */
public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {
}
