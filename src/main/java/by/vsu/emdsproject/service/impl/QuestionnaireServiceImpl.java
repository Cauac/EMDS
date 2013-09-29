package by.vsu.emdsproject.service.impl;

import by.vsu.emdsproject.model.Questionnaire;
import by.vsu.emdsproject.repository.QuestionnaireRepository;
import by.vsu.emdsproject.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class QuestionnaireServiceImpl implements QuestionnaireService {

    @Autowired
    private QuestionnaireRepository questionnaireRepository;

    @Override
    public Questionnaire save(Questionnaire entity) {
        return questionnaireRepository.save(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Questionnaire> list() {
        return questionnaireRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Questionnaire read(Long id) {
        return questionnaireRepository.findOne(id);
    }

    @Override
    public void remove(Long id) {
        questionnaireRepository.delete(id);
    }

    @Override
    public void remove(Questionnaire entity) {
        questionnaireRepository.delete(entity);
    }
}
