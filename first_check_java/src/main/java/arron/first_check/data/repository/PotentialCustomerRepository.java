package arron.first_check.data.repository;
import arron.first_check.data.models.PotentialCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PotentialCustomerRepository extends JpaRepository<PotentialCustomer, Long> {
}


