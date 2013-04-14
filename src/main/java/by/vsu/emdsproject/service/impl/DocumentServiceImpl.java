package by.vsu.emdsproject.service.impl;

import by.vsu.emdsproject.model.Document;
import by.vsu.emdsproject.repository.DocumentRepository;
import by.vsu.emdsproject.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Max
 */
@Service
@Transactional
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public Document add(Document entity) {
        return documentRepository.save(entity);
    }

    @Override
    public Document update(Document entity) {
        return documentRepository.save(entity);
    }

    @Override
    public List<Document> list() {
        return documentRepository.findAll();
    }

    @Override
    public Document read(Long id) {
        return documentRepository.findOne(id);
    }

    @Override
    public void remove(Long id) {
        documentRepository.delete(id);
    }

    @Override
    public void remove(Document entity) {
        documentRepository.delete(entity);
    }
}
