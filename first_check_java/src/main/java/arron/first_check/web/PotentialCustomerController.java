package arron.first_check.web;

import java.util.List;

import arron.first_check.data.models.PotentialCustomer;
import arron.first_check.data.repository.PotentialCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import arron.first_check.exception.ResourceNotFound;


@RestController
@RequestMapping("/api/potential")
public class PotentialCustomerController {

    @Autowired
    private PotentialCustomerRepository potentialCustomerRepository;

    // get all users
    @GetMapping
    public List <PotentialCustomer> getAllCustomers() {
        System.out.println("success");
        return this.potentialCustomerRepository.findAll();
    }

    // get user by id
    @GetMapping("/{id}")
    public PotentialCustomer getCustomerById(@PathVariable(value = "id") long customerId) {
        return this.potentialCustomerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFound("User not found with id :" + customerId));
    }

    // create user
    @PostMapping
    public PotentialCustomer createCustomer(@RequestBody PotentialCustomer potentialCustomer) {
        return this.potentialCustomerRepository.save(potentialCustomer);
    }

    // update user
    @PutMapping("/{id}")
    public PotentialCustomer updateCustomer(@RequestBody PotentialCustomer potentialCustomer, @PathVariable("id") long customerId) {
        PotentialCustomer existingCustomer = this.potentialCustomerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFound("User not found with id :" + customerId));
        existingCustomer.setName(potentialCustomer.getName());
        existingCustomer.setJob(potentialCustomer.getJob());
        existingCustomer.setMarriage(potentialCustomer.getMarriage());
        existingCustomer.setFk_customer_id(potentialCustomer.getFk_customer_id());
        existingCustomer.setAge(potentialCustomer.getAge());
        existingCustomer.setStockAmount(potentialCustomer.getStockAmount());
        existingCustomer.setRealEstateAmount(potentialCustomer.getRealEstateAmount());
        existingCustomer.setOthersAmount(potentialCustomer.getOthersAmount());
        return this.potentialCustomerRepository.save(existingCustomer);
    }

    // delete user by id
    @DeleteMapping("/{id}")
    public ResponseEntity < PotentialCustomer > deleteCustomerById(@PathVariable("id") long customerId) {
        PotentialCustomer existingCustomer = this.potentialCustomerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFound("User not found with id :" + customerId));
        this.potentialCustomerRepository.delete(existingCustomer);
        return ResponseEntity.ok().build();
    }


}
