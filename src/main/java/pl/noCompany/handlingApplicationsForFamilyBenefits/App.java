package pl.noCompany.handlingApplicationsForFamilyBenefits;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.noCompany.handlingApplicationsForFamilyBenefits.Adress.model.Address;
import pl.noCompany.handlingApplicationsForFamilyBenefits.Person.model.MaritalStatus;
import pl.noCompany.handlingApplicationsForFamilyBenefits.Person.model.Person;
import pl.noCompany.handlingApplicationsForFamilyBenefits.Person.model.SexEnum;

import java.time.LocalDate;

@SpringBootApplication
public class App {

    public static void main(String[] args) throws Throwable {
        System.out.println("Hello!");


        Address address = new Address("Toruń","Wojska Polskiego","22","8","87-100");
        Person ojciec = new Person("Jan", "Kowalski",99121525487L, LocalDate.of(1999,12,15), SexEnum.MALE, MaritalStatus.DIVORCED, address);

        SpringApplication.run(App.class, args);
    }

    public void run(String... strings) throws Exception {}
}
