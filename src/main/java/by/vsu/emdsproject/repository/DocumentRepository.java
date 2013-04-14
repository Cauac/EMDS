package by.vsu.emdsproject.repository;

import by.vsu.emdsproject.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Max
 */
public interface DocumentRepository extends JpaRepository<Document, Long> {
}
