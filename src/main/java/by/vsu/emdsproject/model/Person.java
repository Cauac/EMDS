package by.vsu.emdsproject.model;

/**
 * @author Max
 *         Date: 28.03.13
 *         Time: 22:35
 */
public abstract class Person implements AbstractEntity {

    protected String firstName;

    protected String lastName;

    protected String middleName;

    protected Person() {
    }

    abstract public String getFirstName();

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    abstract public String getLastName();

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    abstract public String getMiddleName();

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
}
