package by.vsu.emdsproject.repository;

import by.vsu.emdsproject.model.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Max
 *         Date: 23.03.13
 *         Time: 23:15
 */
public interface QuestionnaireRepository extends JpaRepository<Questionnaire, Long> {
}
