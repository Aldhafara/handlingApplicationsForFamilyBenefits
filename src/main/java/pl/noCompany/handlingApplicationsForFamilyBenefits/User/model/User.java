package pl.noCompany.handlingApplicationsForFamilyBenefits.User.model;

import pl.noCompany.handlingApplicationsForFamilyBenefits.Adress.model.Adress;

import java.time.LocalDateTime;
import java.util.List;

public class User {

    private int id;
    private String name;
    private String surname;
    private int pesel;
    private LocalDateTime birthDate;
    private SexEnum sex;
    private MaritalStatus maritalStatus;
    private Adress adress;
    private List<User> children;
}
