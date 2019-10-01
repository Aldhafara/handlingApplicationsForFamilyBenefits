package pl.noCompany.handlingApplicationsForFamilyBenefits.Person.model;

public enum SexEnum {
    MALE("mężczyzna"),
    FEMALE("kobieta");

    private final String description;

    SexEnum(String description){
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }
}
