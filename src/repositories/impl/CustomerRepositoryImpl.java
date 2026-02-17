package repositories.impl;

import domain.Customer;
import repositories.CustomerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerRepositoryImpl implements CustomerRepository {

    private List<Customer> database = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public List<Customer> findAll() {
        return database;
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return database.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    @Override
    public Customer save(Customer customer) {
        if (customer.getId() == null) {
            customer.setId(nextId++);
            database.add(customer);
        }
        return customer;
    }

    @Override
    public void deleteById(Long id) {
        database.removeIf(c -> c.getId().equals(id));
    }
}
