package pl.noCompany.handlingApplicationsForFamilyBenefits.Person.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.noCompany.handlingApplicationsForFamilyBenefits.Person.dto.PersonDto;
import pl.noCompany.handlingApplicationsForFamilyBenefits.Person.model.Person;
import pl.noCompany.handlingApplicationsForFamilyBenefits.Person.repository.PersonRepository;
import pl.noCompany.handlingApplicationsForFamilyBenefits.Person.transformer.PersonTransformer;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<PersonDto> getAllPersons(){
        return personRepository.findAll().stream().map(PersonTransformer::getPersonDtoFromModel)
                .collect(Collectors.toList());
    }

    public PersonDto createUser(PersonDto personDto) {
        Person person = PersonTransformer.getPersonModelFromDto(personDto);
        personRepository.save(person);
        return personDto;
    }
}
