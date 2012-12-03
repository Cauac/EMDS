package by.vsu.emdsproject.model;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address extends AbstractEntity {

    private String city;
    private String street;
    private String house;
    private String apartment;

    public Address() {
    }

    @Id
    @Column(name = "id_address")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @Column(name = "city", length = 30)
    public String getCity() {
        return city;
    }

    @Column(name = "street", length = 30)
    public String getStreet() {
        return street;
    }

    @Column(name = "house", length = 3)
    public String getHouse() {
        return house;
    }

    @Column(name = "apartment", length = 4)
    public String getApartment() {
        return apartment;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }
    
    @Override
    public String toString () {
        return city + " ул." + street + " д." + house + " кв." + apartment;
    }
    
}
