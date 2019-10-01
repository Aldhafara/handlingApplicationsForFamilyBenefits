package pl.noCompany.handlingApplicationsForFamilyBenefits.Person.model;

import pl.noCompany.handlingApplicationsForFamilyBenefits.Adress.model.Address;
import pl.noCompany.handlingApplicationsForFamilyBenefits.LoginData.model.LoginData;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Person {

    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    private int id;

    @ManyToOne
    private Person parent;

    @Column
    private String name;

    @Column
    private String surname;

    @Column(length = 11)
    private Long pesel;

    @Column
    private LocalDate birthDate;

    @Column
    @Enumerated(EnumType.STRING)
    private SexEnum sex;

    @Column
    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToMany
    @JoinTable(
        name = "parentToChildren",
        joinColumns = @JoinColumn(
            name = "PARENT_ID",
            referencedColumnName = "id"
        ),
        inverseJoinColumns = @JoinColumn(
            name = "CHILD_ID",
            referencedColumnName = "id"
        )
    )
    private List<Person> children;

    @OneToOne
    @JoinColumn(name = "loginData_id", referencedColumnName = "id")
    private LoginData loginData;

    public Person(String name, String surname, Long pesel, LocalDate birthDate, SexEnum sex, MaritalStatus maritalStatus, Address address
    ) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.birthDate = birthDate;
        this.sex = sex;
        this.maritalStatus = maritalStatus;
        this.address = address;
    }

    public Person() {

    }

    public void setChildren(List<Person> children) {
        this.children = children;
    }


    public int getId() {
        return id;
    }

    public Person getParent() {
        return parent;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Long getPesel() {
        return pesel;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public SexEnum getSex() {
        return sex;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public Address getAddress() {
        return address;
    }

    public List<Person> getChildren() {
        return children;
    }

    public LoginData getLoginData() {
        return loginData;
    }


    public static final class Builder {
        private int id;
        private Person parent;
        private String name;
        private String surname;
        private Long pesel;
        private LocalDate birthDate;
        private SexEnum sex;
        private MaritalStatus maritalStatus;
        private Address address;
        private List<Person> children;
        private LoginData loginData;

        private Builder() {
        }

        public static Builder aPerson() {
            return new Builder();
        }

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withParent(Person parent) {
            this.parent = parent;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder withPesel(Long pesel) {
            this.pesel = pesel;
            return this;
        }

        public Builder withBirthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public Builder withSex(SexEnum sex) {
            this.sex = sex;
            return this;
        }

        public Builder withMaritalStatus(MaritalStatus maritalStatus) {
            this.maritalStatus = maritalStatus;
            return this;
        }

        public Builder withAddress(Address address) {
            this.address = address;
            return this;
        }

        public Builder withChildren(List<Person> children) {
            this.children = children;
            return this;
        }

        public Builder withLoginData(LoginData loginData) {
            this.loginData = loginData;
            return this;
        }

        public Person build() {
            Person person = new Person(name, surname, pesel, birthDate, sex, maritalStatus, address
            );
            person.setChildren(children);
            person.parent = this.parent;
            person.loginData = this.loginData;
            person.id = this.id;
            person.name = this.name;
            person.surname = this.surname;
            person.pesel = this.pesel;
            person.birthDate = this.birthDate;
            person.sex = this.sex;
            person.maritalStatus = this.maritalStatus;
            return person;
        }
    }
}
