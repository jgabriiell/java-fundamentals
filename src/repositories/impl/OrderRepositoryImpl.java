package repositories.impl;

import domain.Order;
import repositories.OrderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderRepositoryImpl implements OrderRepository {

    private final List<Order> database = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public List<Order> findAll() {
        return database;
    }

    @Override
    public Optional<Order> findById(Long id) {
        return database.stream().filter(order -> order.getId().equals(id)).findFirst();
    }

    @Override
    public Order save(Order order) {
        if (order.getId() == null) {
            order.setId(nextId++);
            database.add(order);
        }
        return order;
    }

    @Override
    public void deleteById(Long id) {
        database.removeIf(order -> order.getId().equals(id));
    }
}
