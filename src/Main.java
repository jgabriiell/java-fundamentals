import controllers.CustomerController;
import controllers.OrderController;
import domain.Customer;
import repositories.CustomerRepository;
import repositories.OrderRepository;
import repositories.impl.CustomerRepositoryImpl;
import repositories.impl.OrderRepositoryImpl;
import service.CustomerService;
import service.OrderService;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        CustomerService customerService = new CustomerService(customerRepository);
        CustomerController customerController = new CustomerController(customerService);

        customerController.createCustomer("jhonny", "jhonny@gmail.com");
        customerController.createCustomer("Wayne", "wayne@gmail.com");

        System.out.println(customerController.findAllCustomers());
        System.out.println(customerController.findConsumer(1L));

        customerController.deleteConsumer(2L);
        System.out.println(customerController.findAllCustomers());

        OrderRepository orderRepository = new OrderRepositoryImpl();
        OrderService orderService = new OrderService(orderRepository);
        OrderController orderController = new OrderController(orderService);

        orderController.insertOrder(LocalDateTime.now(), new Customer("Bruce", "bruce@gmail.com"), 100.00);
        orderController.insertOrder(LocalDateTime.now(), new Customer("Kate", "kate@gmail.com"), 150.00);

        System.out.println(orderController.findAllOrders());

        System.out.println(orderController.findOrderById(2L));

        orderController.findOrderById(3L);
    }
}
