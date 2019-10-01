package pl.noCompany.handlingApplicationsForFamilyBenefits.Person.model;

public enum MaritalStatus {
    MARRIED("żonaty/zamężna"),
    DIVORCED("rozwiedziony/rozwiedziona"),
    COHABITANT("konkubent/konkubina"),
    SINGLE("kawaler/panna"),
    WIDOWED("wdowiec/wdowa");



    private final String description;

    MaritalStatus(String description){
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }
}
