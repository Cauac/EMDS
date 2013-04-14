package by.vsu.emdsproject.service.impl;

import by.vsu.emdsproject.model.DocumentInfo;
import by.vsu.emdsproject.repository.DocumentInfoRepository;
import by.vsu.emdsproject.service.DocumentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Max
 */
@Service
@Transactional
public class DocumentInfoServiceImpl implements DocumentInfoService {

    @Autowired
    DocumentInfoRepository documentInfoRepository;

    @Override
    public DocumentInfo add(DocumentInfo entity) {
        return documentInfoRepository.save(entity);
    }

    @Override
    public DocumentInfo update(DocumentInfo entity) {
        return documentInfoRepository.save(entity);
    }

    @Override
    public List<DocumentInfo> list() {
        return documentInfoRepository.findAll();
    }

    @Override
    public DocumentInfo read(Long id) {
        return documentInfoRepository.findOne(id);
    }

    @Override
    public void remove(Long id) {
        documentInfoRepository.delete(id);
    }

    @Override
    public void remove(DocumentInfo entity) {
        documentInfoRepository.delete(entity);
    }
}
