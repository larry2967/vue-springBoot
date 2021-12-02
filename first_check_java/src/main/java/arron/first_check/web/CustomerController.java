package arron.first_check.web;

import java.util.Arrays;
import java.util.List;

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

import arron.first_check.data.models.Customer;
import arron.first_check.exception.ResourceNotFound;
import arron.first_check.data.repository.CustomerRepository;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    // get all users
    @GetMapping
    public List < Customer > getAllCustomers() {
        return this.customerRepository.findAll();
    }

    // get user by id
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable(value = "id") long customerId) {
        return this.customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFound("User not found with id :" + customerId));
    }

    // create user
    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return this.customerRepository.save(customer);
    }

    // update user
    @PutMapping("/{id}")
    public Customer updateCustomer(@RequestBody Customer customer, @PathVariable("id") long customerId) {
        Customer existingCustomer = this.customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFound("User not found with id :" + customerId));
        existingCustomer.setName(customer.getName());
        existingCustomer.setJob(customer.getJob());
        existingCustomer.setMarriage(customer.getMarriage());
        existingCustomer.setAge(customer.getAge());
        existingCustomer.setStockAmount(customer.getStockAmount());
        existingCustomer.setRealEstateAmount(customer.getRealEstateAmount());
        existingCustomer.setOthersAmount(customer.getOthersAmount());
        return this.customerRepository.save(existingCustomer);
    }

    // delete user by id
    @DeleteMapping("/{id}")
    public ResponseEntity < Customer > deleteCustomerById(@PathVariable("id") long customerId) {
        Customer existingCustomer = this.customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFound("User not found with id :" + customerId));
        this.customerRepository.delete(existingCustomer);
        return ResponseEntity.ok().build();
    }


//    // delete user by id
//    @DeleteMapping("/[id]")
//    public ResponseEntity < Customer > deleteCustomersWithIds(@PathVariable("id") Integer[] ids) {
//        Customer existingCustomer = this.customerRepository.deleteCustomersWithIds(Arrays.asList(ids))
//                .orElseThrow(() -> new ResourceNotFound("User not found with id :" + ids));
//        this.customerRepository.delete(existingCustomer);
//        return ResponseEntity.ok().build();
//    }
}