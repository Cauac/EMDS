package by.vsu.emdsproject.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "specialty")
public class Specialty extends AbstractEntity {

    private String number;
    private String description;
    private Set<Group> groups = new HashSet<Group>();

    public Specialty() {
    }

    public Specialty(Long id) {
        this.id = id;
    }

    @NotNull
    @Size(min = 1, max = 10, message = "От 1 до 10 цифр")
    @Column(name = "number", nullable = false, length = 10)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @NotNull
    @Size(min = 5, max = 200, message = "От 5 до 200 символов")
    @Column(name = "description", nullable = false, length = 200)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(mappedBy = "specialty", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Specialty)) return false;

        Specialty specialty = (Specialty) o;

        if (description != null ? !description.equals(specialty.description) : specialty.description != null)
            return false;
        if (number != null ? !number.equals(specialty.number) : specialty.number != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = number != null ? number.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
