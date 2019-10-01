package pl.noCompany.handlingApplicationsForFamilyBenefits.Person.dto;

import pl.noCompany.handlingApplicationsForFamilyBenefits.Person.model.MaritalStatus;
import pl.noCompany.handlingApplicationsForFamilyBenefits.Person.model.SexEnum;

import java.time.LocalDate;
import java.util.List;

public class PersonDto {

    private int id;
    private PersonDto parent;
    private String name;
    private String surname;
    private Long pesel;
    private LocalDate birthDate;
    private SexEnum sex;
    private MaritalStatus maritalStatus;
//    private AddressDto address;
    private List<PersonDto> children;
//    private LoginDataDto loginData;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PersonDto getParent() {
        return parent;
    }

    public void setParent(PersonDto parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getPesel() {
        return pesel;
    }

    public void setPesel(Long pesel) {
        this.pesel = pesel;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public List<PersonDto> getChildren() {
        return children;
    }

    public void setChildren(List<PersonDto> children) {
        this.children = children;
    }


    public static final class Builder {
        private int id;
        private PersonDto parent;
        private String name;
        private String surname;
        private Long pesel;
        private LocalDate birthDate;
        private SexEnum sex;
        private MaritalStatus maritalStatus;
        //    private AddressDto address;
        private List<PersonDto> children;

        private Builder() {
        }

        public static Builder aPersonDto() {
            return new Builder();
        }

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withParent(PersonDto parent) {
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

        public Builder withChildren(List<PersonDto> children) {
            this.children = children;
            return this;
        }

        public PersonDto build() {
            PersonDto personDto = new PersonDto();
            personDto.setId(id);
            personDto.setParent(parent);
            personDto.setName(name);
            personDto.setSurname(surname);
            personDto.setPesel(pesel);
            personDto.setBirthDate(birthDate);
            personDto.setSex(sex);
            personDto.setMaritalStatus(maritalStatus);
            personDto.setChildren(children);
            return personDto;
        }
    }
}
