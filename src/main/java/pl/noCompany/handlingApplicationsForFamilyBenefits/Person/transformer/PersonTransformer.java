package pl.noCompany.handlingApplicationsForFamilyBenefits.Person.transformer;

import pl.noCompany.handlingApplicationsForFamilyBenefits.Person.dto.PersonDto;
import pl.noCompany.handlingApplicationsForFamilyBenefits.Person.model.Person;

public class PersonTransformer {

    public static PersonDto getPersonDtoFromModel(Person person) {
        return PersonDto.Builder.aPersonDto()
                .withId(person.getId())
                .withName(person.getName())
                .withSurname(person.getSurname())
                .withBirthDate(person.getBirthDate())
                .withPesel(person.getPesel())
                .withSex(person.getSex())
                .withMaritalStatus(person.getMaritalStatus())
                .build();
    }

    public static Person getPersonModelFromDto(PersonDto personDto) {
        return Person.Builder.aPerson()
                .withName(personDto.getName())
                .withSurname(personDto.getSurname())
                .withBirthDate(personDto.getBirthDate())
                .withMaritalStatus(personDto.getMaritalStatus())
                .withPesel(personDto.getPesel())
                .withSex(personDto.getSex())
                .build();
    }
}
