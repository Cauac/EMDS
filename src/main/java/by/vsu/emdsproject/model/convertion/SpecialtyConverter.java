package by.vsu.emdsproject.model.convertion;

import by.vsu.emdsproject.model.Specialty;
import org.springframework.stereotype.Component;

@Component
public class SpecialtyConverter extends EMDSEntityConverter<Specialty> {

    public SpecialtyConverter() {
        super(Specialty.class);
    }

}
