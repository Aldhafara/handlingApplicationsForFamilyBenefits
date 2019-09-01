package pl.noCompany.handlingApplicationsForFamilyBenefits.User.model;

enum SexEnum {
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
