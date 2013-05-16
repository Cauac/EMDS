package by.vsu.emdsproject.model.convertion;

import by.vsu.emdsproject.model.Specialty;
import by.vsu.emdsproject.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author Max
 *         Date: 16.05.13
 *         Time: 21:24
 */
@Component
public class SpecialtyConverter implements Converter<Long, Specialty> {

    @Autowired
    private SpecialtyService specialtyService;

    public SpecialtyConverter() {
    }

    public SpecialtyConverter(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Specialty convert(Long id) {
        return specialtyService.read(id);
    }
}
