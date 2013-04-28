package by.vsu.emdsproject.web.propertyeditor;

import by.vsu.emdsproject.model.Student;
import by.vsu.emdsproject.service.StudentService;

import java.beans.PropertyEditorSupport;

/**
 * @author Max
 *         Date: 28.04.13
 *         Time: 14:52
 */
public class StudentEditor extends PropertyEditorSupport {

    private StudentService studentService;

    public StudentEditor(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public String getAsText() {
        return super.getAsText();
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Long id = Long.parseLong(text);
        Student student = studentService.read(id);
        setValue(student);
    }

}
