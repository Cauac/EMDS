package by.vsu.emdsproject.web.form;

import by.vsu.emdsproject.model.Group;
import by.vsu.emdsproject.model.Student;

/**
 * @author Max
 *         Date: 04.05.13
 *         Time: 22:27
 */
public class PersonCardForm {

    private Group group;
    private Student student;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
