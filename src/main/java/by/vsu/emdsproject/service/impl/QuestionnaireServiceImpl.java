package by.vsu.emdsproject.service.impl;

import by.vsu.emdsproject.dao.QuestionnaireDAO;
import by.vsu.emdsproject.model.Questionnaire;
import by.vsu.emdsproject.service.QuestionnaireService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService{
    
    @Autowired
    private QuestionnaireDAO questionnaireDAO;

    public void add(Questionnaire entity) {
        questionnaireDAO.save(entity);
    }

    public void update(Questionnaire entity) {
        questionnaireDAO.update(entity);
    }

    public List<Questionnaire> list() {
        return questionnaireDAO.findAll();
    }

    public Questionnaire read(Long id) {
        return questionnaireDAO.findOne(id);
    }

    public void remove(Long id) {
        questionnaireDAO.deleteById(id);
    }

    public void remove(Questionnaire entity) {
        questionnaireDAO.delete(entity);
    }

}
