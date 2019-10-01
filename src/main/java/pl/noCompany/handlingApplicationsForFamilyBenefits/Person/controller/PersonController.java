package pl.noCompany.handlingApplicationsForFamilyBenefits.Person.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.noCompany.handlingApplicationsForFamilyBenefits.Person.dto.PersonDto;
import pl.noCompany.handlingApplicationsForFamilyBenefits.Person.form.CreatePersonRequestForm;
import pl.noCompany.handlingApplicationsForFamilyBenefits.Person.service.PersonService;
import pl.noCompany.handlingApplicationsForFamilyBenefits.Person.transformer.CreatePersonFormToPersonDtoTransformer;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/users")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public String getPersons(Model model) {

        List<PersonDto> allPersons = personService.getAllPersons();

        model.addAttribute("persons", allPersons);
        return "persons";
    }

    @GetMapping("/add")
    public String getAddUserForm(CreatePersonRequestForm requestForm) {
        return "person_add";
    }

    @PostMapping("/add")
    public String createUser(@ModelAttribute @Valid CreatePersonRequestForm requestForm, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            return "person_add";
        }
        PersonDto personDto = CreatePersonFormToPersonDtoTransformer.transform(requestForm);
        PersonDto createdPerson = personService.createUser(personDto);

        if(createdPerson!=null){
            model.addAttribute("createdPerson",createdPerson);

            List<PersonDto> allPersons = personService.getAllPersons();

            model.addAttribute("persons", allPersons);
            return "redirect:/users";
        }
        model.addAttribute("emailSendFailure");
        return "registration_failure";

    }

    @GetMapping("/details/{userId}")
    public String getPersonDetails(Model model, @PathVariable(required = true) Integer userId){
        return "error404";
    }


}
