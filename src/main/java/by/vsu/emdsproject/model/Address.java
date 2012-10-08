package by.vsu.emdsproject.model;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address implements AbstractEntity {

    private Long id;
    private String city;
    private String street;
    private String house;
    private String block;
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

    @Column(name = "block", length = 3)
    public String getBlock() {
        return block;
    }

    @Column(name = "apartment", length = 4)
    public String getApartment() {
        return apartment;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setBlock(String block) {
        this.block = block;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }
}
