package by.vsu.emdsproject.model;

/**
 * @author Max
 *         Date: 28.03.13
 *         Time: 22:35
 */
public abstract class Person extends AbstractEntity {


    protected String firstName;

    protected String lastName;

    protected String middleName;

    protected Person() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
}
