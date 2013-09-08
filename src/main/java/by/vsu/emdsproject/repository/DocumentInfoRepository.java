package by.vsu.emdsproject.repository;

import by.vsu.emdsproject.model.DocumentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentInfoRepository extends JpaRepository<DocumentInfo, Long> {
}
