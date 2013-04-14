package by.vsu.emdsproject.repository;

import by.vsu.emdsproject.model.DocumentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Max
 */
public interface DocumentInfoRepository extends JpaRepository<DocumentInfo, Long> {
}
