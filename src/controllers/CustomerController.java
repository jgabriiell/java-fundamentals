package controllers;

import domain.Customer;
import service.CustomerService;

import java.util.List;

public class CustomerController {

    private CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    public void createCustomer(String name, String email) {
        service.insert(new Customer(name, email));
    }

    public Customer findConsumer(Long id) {
        return service.findById(id);
    }

    public List<Customer> findAllCustomers() {
        return service.findAll();
    }

    public void deleteConsumer(Long id) {
        service.deleteCustomer(id);
    }
}
