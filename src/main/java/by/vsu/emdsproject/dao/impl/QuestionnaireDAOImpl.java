package by.vsu.emdsproject.dao.impl;

import by.vsu.emdsproject.dao.QuestionnaireDAO;
import by.vsu.emdsproject.model.Questionnaire;
import org.springframework.stereotype.Repository;

@Repository
public class QuestionnaireDAOImpl extends AbstractDAOImpl<Questionnaire> implements QuestionnaireDAO {

    public QuestionnaireDAOImpl() {
        setClazz(Questionnaire.class);
    }
}