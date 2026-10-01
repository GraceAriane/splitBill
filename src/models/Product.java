package models;

import java.math.BigDecimal;

public class Product {
    private Long id;
    private String name;
    private BigDecimal price;
    private String type;
    private int quantity;
    private BigDecimal subtotal;

    public Product(Long id, String name, BigDecimal price, String type, int quantity, BigDecimal subtotal) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
        this.quantity = quantity;
        this.subtotal = subtotal;
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public String getType() {
        return type;
    }
    public int getQuantity() {
        return quantity;
    }
    public BigDecimal getSubtotal() {
        if(quantity == 0){
            return BigDecimal.ZERO;
        }else{
            return price.multiply(BigDecimal.valueOf(quantity));
        }
    }
}
