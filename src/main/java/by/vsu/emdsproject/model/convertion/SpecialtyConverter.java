package by.vsu.emdsproject.model.convertion;

import by.vsu.emdsproject.model.Specialty;
import org.springframework.stereotype.Component;

/**
 * @author Max
 *         Date: 16.05.13
 *         Time: 21:24
 */
@Component
public class SpecialtyConverter extends EMDSEntityConverter<Specialty> {

    public SpecialtyConverter() {
        super(Specialty.class);
    }

}
