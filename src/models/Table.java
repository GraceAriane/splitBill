package models;

import java.util.List;

public class Table {
    private Long id;
    private String name;
    private List<Order> Orders;

    public Table(Long id, String name, List<Order> Orders) {
        this.id = id;
        this.name = name;
        this.Orders = Orders;
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public List<Order> getOrders() {
        return Orders;
    }
    
}
