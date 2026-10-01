package models;

import java.math.BigDecimal;
import java.util.List;

public class Order {
    private Long id;
    private Person person;
    private List<Product> products;
    private BigDecimal totalPrice;

    public Order(Long id, Person person, List<Product> products, BigDecimal totalPrice) {
        this.id = id;
        this.person = person;
        this.products = products;
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }

    public List<Product> getProducts() {
        return products;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }
}
