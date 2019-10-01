package pl.noCompany.handlingApplicationsForFamilyBenefits.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import pl.noCompany.handlingApplicationsForFamilyBenefits.requestForms.PeselForm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class PeselValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return aClass== PeselForm.class;
    }

    @Override
    public void validate(Object o, Errors errors) {

        PeselForm form = (PeselForm) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"pesel","Field.required","Field is required.");

        Pattern pattern = Pattern.compile("[0-9]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(form.getPesel());

        if(form.getPesel().length()<11) {
            errors.rejectValue("pesel","Pesel.minLong","PESEL should have a 11 digits.");
        }

        if(form.getPesel().length()>11) {
            errors.rejectValue("pesel","Pesel.maxLong","PESEL should have a 11 digits.");
        }

    }
}
