package by.vsu.emdsproject.service.impl;

import by.vsu.emdsproject.model.Questionnaire;
import by.vsu.emdsproject.repository.QuestionnaireRepository;
import by.vsu.emdsproject.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {

    @Autowired
    private QuestionnaireRepository questionnaireRepository;

    @Transactional
    public void add(Questionnaire entity) {
        questionnaireRepository.save(entity);
    }

    @Transactional
    public void update(Questionnaire entity) {
        questionnaireRepository.save(entity);
    }

    @Transactional(readOnly = true)
    public List<Questionnaire> list() {
        return questionnaireRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Questionnaire read(Long id) {
        return questionnaireRepository.findOne(id);
    }

    @Transactional
    public void remove(Long id) {
        questionnaireRepository.delete(id);
    }

    @Transactional
    public void remove(Questionnaire entity) {
        questionnaireRepository.delete(entity);
    }
}
