package pl.noCompany.handlingApplicationsForFamilyBenefits.Adress.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import pl.noCompany.handlingApplicationsForFamilyBenefits.Adress.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long>, JpaSpecificationExecutor<Address> {
}
