package domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class Order {

    private Long id;
    private LocalDateTime moment;
    private Customer customer;
    private Double totalValue;

    public Order() {
    }

    public Order(LocalDateTime moment, Customer customer, Double totalValue) {
        this.moment = moment;
        this.customer = customer;
        this.totalValue = totalValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Order order)) return false;
        return Objects.equals(getId(), order.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return String.format("Order %d: Customer: %s; Total value: %.2f", getId(), getCustomer().getName(), getTotalValue());
    }
}
