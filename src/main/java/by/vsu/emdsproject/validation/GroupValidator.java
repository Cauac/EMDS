package by.vsu.emdsproject.validation;

import by.vsu.emdsproject.model.Group;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author Max
 */
public class GroupValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Group.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "title", "field.required", "Введите название");
        Group group = (Group) o;
        if (group.getTitle().length() > 10) {
            errors.reject("too.long.name", "Слишком длинное название");
        }
    }

}
