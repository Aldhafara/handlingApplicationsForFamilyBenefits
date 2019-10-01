package pl.noCompany.handlingApplicationsForFamilyBenefits.Person.transformer;

import pl.noCompany.handlingApplicationsForFamilyBenefits.Person.dto.PersonDto;
import pl.noCompany.handlingApplicationsForFamilyBenefits.Person.form.CreatePersonRequestForm;

public class CreatePersonFormToPersonDtoTransformer {
    public static PersonDto transform(CreatePersonRequestForm form){

        return PersonDto.Builder.aPersonDto()
                .withName(form.getFirstName())
                .withSurname(form.getLastName())
                .withPesel(form.getPesel())
                .withBirthDate(form.getDateOfBirth())
                .withSex(form.getSex())
                .withMaritalStatus(form.getMaritalStatus())
                .build();
    }
}
