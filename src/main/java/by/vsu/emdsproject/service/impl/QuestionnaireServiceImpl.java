package by.vsu.emdsproject.service.impl;

import by.vsu.emdsproject.dao.QuestionnaireDAO;
import by.vsu.emdsproject.model.Questionnaire;
import by.vsu.emdsproject.service.QuestionnaireService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {

    @Autowired
    private QuestionnaireDAO questionnaireDAO;

    @Transactional
    public void add(Questionnaire entity) {
        questionnaireDAO.save(entity);
    }

    @Transactional
    public void update(Questionnaire entity) {
        questionnaireDAO.update(entity);
    }

    @Transactional(readOnly = true)
    public List<Questionnaire> list() {
        return questionnaireDAO.findAll();
    }

    @Transactional(readOnly = true)
    public Questionnaire read(Long id) {
        return questionnaireDAO.findOne(id);
    }

    @Transactional
    public void remove(Long id) {
        questionnaireDAO.deleteById(id);
    }

    @Transactional
    public void remove(Questionnaire entity) {
        questionnaireDAO.delete(entity);
    }
}
