package by.vsu.emdsproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "address")
public class Address extends AbstractEntity {

    private String city;
    private String street;
    private String house;
    private String apartment;

    public Address() {
    }

    @NotNull
    @Size(max = 30)
    @Column(name = "city", length = 30)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @NotNull
    @Size(max = 30)
    @Column(name = "street", length = 30)
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @NotNull
    @Size(max = 3)
    @Column(name = "house", length = 3)
    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    @Size(max = 4)
    @Column(name = "apartment", length = 4)
    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    @Override
    public String toString() {
        return city + " ул." + street + " д." + house + " кв." + apartment;
    }

}
