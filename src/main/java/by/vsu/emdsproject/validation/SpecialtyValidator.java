package by.vsu.emdsproject.validation;

import by.vsu.emdsproject.model.Specialty;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author Max
 */
public class SpecialtyValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Specialty.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "title", "field.required", "Введите название");
        Specialty specialty = (Specialty) o;
        if (specialty.getTitle().length() > 300) {
            errors.reject("too.long.name", "Слишком длинное название");
        }
    }

}
