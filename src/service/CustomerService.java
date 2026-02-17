package service;

import domain.Customer;
import exception.ResourceNotFoundException;
import repositories.CustomerRepository;

import java.util.List;

public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer insert(Customer customer) {
        return repository.save(customer);
    }

    public Customer findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Could not find customer with id " + id));
    }

    public List<Customer> findAll() {
        return repository.findAll();
    }

    public void deleteCustomer(Long id) {
        repository.deleteById(id);
    }
}
