package by.vsu.emdsproject.model.convertion;

import by.vsu.emdsproject.model.Student;
import org.springframework.stereotype.Component;

/**
 * @author Max
 *         Date: 16.05.13
 *         Time: 21:58
 */
@Component
public class StudentConverter extends EMDSEntityConverter<Student> {

    public StudentConverter() {
        super(Student.class);
    }

}
