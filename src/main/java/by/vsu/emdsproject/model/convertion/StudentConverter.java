package by.vsu.emdsproject.model.convertion;

import by.vsu.emdsproject.model.Student;
import by.vsu.emdsproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author Max
 *         Date: 16.05.13
 *         Time: 21:58
 */
@Component
public class StudentConverter implements Converter<Long, Student> {

    @Autowired
    private StudentService studentService;

    public StudentConverter() {
    }

    public StudentConverter(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public Student convert(Long id) {
        return studentService.read(id);
    }

}
