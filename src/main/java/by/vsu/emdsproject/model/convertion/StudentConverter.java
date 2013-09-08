package by.vsu.emdsproject.model.convertion;

import by.vsu.emdsproject.model.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentConverter extends EMDSEntityConverter<Student> {

    public StudentConverter() {
        super(Student.class);
    }

}
