package pl.noCompany.handlingApplicationsForFamilyBenefits.Person.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import pl.noCompany.handlingApplicationsForFamilyBenefits.Person.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long>, JpaSpecificationExecutor<Person> {
}
