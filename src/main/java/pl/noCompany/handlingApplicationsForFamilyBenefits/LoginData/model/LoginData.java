package pl.noCompany.handlingApplicationsForFamilyBenefits.LoginData.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LoginData {

    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    private int id;

    @Column(unique = true)
    private String email;

    @Column
    private String password;
}
