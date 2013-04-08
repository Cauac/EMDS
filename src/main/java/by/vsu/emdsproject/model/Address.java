package by.vsu.emdsproject.model;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address implements AbstractEntity {

    private Long id;
    private String city;
    private String street;
    private String house;
    private String apartment;

    public Address() {
    }

    @Id
    @Override
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "city", length = 30)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "street", length = 30)
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Column(name = "house", length = 3)
    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

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
