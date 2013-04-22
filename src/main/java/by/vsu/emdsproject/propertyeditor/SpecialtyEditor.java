package by.vsu.emdsproject.propertyeditor;

import by.vsu.emdsproject.model.Specialty;
import by.vsu.emdsproject.service.SpecialtyService;

import java.beans.PropertyEditorSupport;

/**
 * @author Max
 */
public class SpecialtyEditor extends PropertyEditorSupport {

    private SpecialtyService specialtyService;

    public SpecialtyEditor(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public String getAsText() {
        return super.getAsText();
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Long id = Long.parseLong(text);
        Specialty specialty = specialtyService.read(id);
        setValue(specialty);
    }
}
