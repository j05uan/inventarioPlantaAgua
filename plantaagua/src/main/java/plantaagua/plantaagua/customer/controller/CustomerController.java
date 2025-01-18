package plantaagua.plantaagua.customer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import plantaagua.plantaagua.customer.entity.Customer;
import plantaagua.plantaagua.customer.entity.CustomerDto;
import plantaagua.plantaagua.customer.service.CustomerService;

@AllArgsConstructor
@RequestMapping("/api/customer")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public Iterable<Customer> list(){
        return customerService.findAll();
    }

    @GetMapping("{id}")
    public Customer get(@PathVariable Integer id){
        return customerService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Customer create(@Validated @RequestBody CustomerDto customerDto){
        return customerService.create(customerDto);
    }

    @PutMapping("{id}")
    public Customer update(@PathVariable Integer id, @Validated @RequestBody CustomerDto customerDto){
        return customerService.update(id, customerDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        customerService.delete(id);
    }

}
