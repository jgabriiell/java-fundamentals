package controllers;

import domain.Customer;
import domain.Order;
import service.OrderService;

import java.time.LocalDateTime;
import java.util.List;

public class OrderController {

    private OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    public Order insertOrder(LocalDateTime time, Customer customer, Double totalValue) {
        return service.insert(new Order(time, customer, totalValue));
    }

    public List<Order> findAllOrders() {
        return service.findAll();
    }

    public Order findOrderById(Long id) {
        return service.findById(id);
    }

    public void deleteOrder(Long id) {
        service.deleteById(id);
    }
}
