package pl.noCompany.handlingApplicationsForFamilyBenefits.Adress.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {

    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    private int id;

    @Column
    private String city;

    @Column
    private String street;

    @Column
    private String houseNumber;

    @Column
    private String localNumber;

    @Column
    private String postalCode;

    public Address(String city, String street, String houseNumber, String localNumber, String postalCode) {
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.localNumber = localNumber;
        this.postalCode = postalCode;
    }

    public Address() {
    }
}
