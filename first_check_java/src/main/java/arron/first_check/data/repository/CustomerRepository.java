package arron.first_check.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import arron.first_check.data.models.Customer;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
//    @Modifying
//    @Query("delete from User u where u.id in ?1")
//    void deleteCustomersWithIds(List<Integer> ids);

}


