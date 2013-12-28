package by.vsu.emdsproject.model;

import java.util.Map;

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

    public void setMapData(Map data) {
        firstName = data.get("first_name").toString();
        middleName = data.get("middle_name").toString();
        lastName = data.get("last_name").toString();
    }
}
