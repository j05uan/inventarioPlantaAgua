package plantaagua.plantaagua.customer.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import plantaagua.plantaagua.customer.entity.Customer;
import plantaagua.plantaagua.customer.entity.CustomerDto;
import plantaagua.plantaagua.customer.repository.CustomerRepository;
import plantaagua.plantaagua.exceptions.ResourceNotFoundException;

@AllArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper mapper;

    public Iterable<Customer> findAll(){
        return customerRepository.findAll();
    }
    public Customer findById(Integer id){
        return customerRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public Customer create(CustomerDto customerDto){
        Customer customer = mapper.map(customerDto,Customer.class);
        return customerRepository.save(customer);   
    }

    public Customer update(Integer id, CustomerDto customerDto){
        Customer customerFromDb = findById(id);
        mapper.map(customerDto, customerFromDb);
        return customerRepository.save(customerFromDb);
    }

    public void delete(Integer id){
        Customer customerFromDb = findById(id);
        customerRepository.delete(customerFromDb);
    }


}
