package by.vsu.emdsproject.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

@MappedSuperclass
public abstract class Person extends AbstractEntity {

    protected String firstName;
    protected String lastName;
    protected String middleName;

    protected Person() {
    }

    protected Person(String firstName, String lastName, String middleName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    @NotEmpty(message = "Обязательное поле")
    @Size(max = 50, message = "Не более 50 символов")
    @Column(name = "first_name", nullable = false, length = 50)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @NotEmpty(message = "Обязательное поле")
    @Size(max = 50, message = "Не более 50 символов")
    @Column(name = "last_name", nullable = false, length = 50)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @NotEmpty(message = "Обязательное поле")
    @Size(max = 50, message = "Не более 50 символов")
    @Column(name = "middle_name", nullable = false, length = 50)
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
}
