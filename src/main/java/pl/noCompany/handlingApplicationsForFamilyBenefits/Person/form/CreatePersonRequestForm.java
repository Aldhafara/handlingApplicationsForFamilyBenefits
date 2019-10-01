package pl.noCompany.handlingApplicationsForFamilyBenefits.Person.form;

import org.hibernate.validator.constraints.pl.PESEL;
import pl.noCompany.handlingApplicationsForFamilyBenefits.Person.model.MaritalStatus;
import pl.noCompany.handlingApplicationsForFamilyBenefits.Person.model.SexEnum;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

public class CreatePersonRequestForm {
    @NotEmpty
    private String firstName;

    @NotBlank
    private String lastName;

    private LocalDate dateOfBirth;

//    @PESEL
    private Long pesel;

    private SexEnum sex;

    private MaritalStatus maritalStatus;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        byte[] peselArray = longToBytes(pesel);

        for (byte b : peselArray) {
            System.out.println(b);
        }

        LocalDate date = peselToDate(peselArray);
        setDateOfBirth(date);

        switch (peselArray[6]%2){
            case 0:
                setSex(SexEnum.FEMALE);
                break;
            case 1:
                setSex(SexEnum.MALE);
                break;
        }

        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getPesel() {
        return pesel;
    }

    public void setPesel(Long pesel) {
        this.pesel = pesel;
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

    private LocalDate peselToDate(byte[] peselArray) {

        int century;
        int cent = peselArray[1] / 20;

        switch (cent){
            case 0:
                century = 1900;
                break;
            case 1:
                century = 2000;
                break;
            case 2:
                century = 2100;
                break;
            case 3:
                century = 2200;
                break;
            case 4:
                century = 1800;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + cent);
        }

        return LocalDate.of(century+peselArray[0],peselArray[1]%20,peselArray[2]);
    }

    private byte[] longToBytes(Long x) {

        Long pesel = x;
        byte x1 = (byte) (pesel/ 1000000000);
        pesel = pesel - x1 * 1000000000L;

        byte x2 = (byte) (pesel/ 10000000);
        pesel = pesel - x2 * 10000000L;

        byte x3 = (byte) (pesel/ 100000);
        pesel = pesel - x3 * 100000L;

        byte x4 = (byte) (pesel/ 10000);
        pesel = pesel - x4 * 10000L;

        byte x5 = (byte) (pesel/ 1000);
        pesel = pesel - x5 * 1000L;

        byte x6 = (byte) (pesel/ 100);
        pesel = pesel - x6 * 100L;

        byte x7 = (byte) (pesel/ 10);
        pesel = pesel - x7 * 10L;

        byte x8 = (byte) (pesel/1);

        return new byte[] {
                x1,
                x2,
                x3,
                x4,
                x5,
                x6,
                x7,
                x8
        };


/*       // byte x1 = (byte) x/ 1000000000;
        System.out.println(x/ 1000000000);



        String peselString = String.valueOf(x);

        System.out.println("peselString" + peselString);
        for (int i = 0; i <peselString.length() ; i++) {
            System.out.println("char " + i + ": " + peselString.charAt(i));

        }

        return new byte[]{
                Byte.valueOf(peselString.substring(0,2)),
                Byte.valueOf(peselString.substring(2,4)),
                Byte.valueOf(peselString.substring(4,6)),
                Byte.valueOf(peselString.substring(6,7)),
                Byte.valueOf(peselString.substring(7,8)),
                Byte.valueOf(peselString.substring(8,9)),
                Byte.valueOf(peselString.substring(9,10)),
                (byte) peselString.charAt(10)
        };*/
    }
}
