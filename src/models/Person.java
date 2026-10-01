package models;

import java.math.BigDecimal;

public class Person {
    private Long id;
    private String name;
    private BigDecimal amountPaid;
    private BigDecimal amountToPay;
    private BigDecimal amountToReceive;
    private BigDecimal balance;

    public Person(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String setName(String name) {
        this.name = name;
        return name;
    }
    public BigDecimal getamountPaid() {
        return amountPaid;
    }
    public void setamountPaid(BigDecimal amountPaid) {
        this.amountPaid = amountPaid;
    }
    public BigDecimal getamountToPay() {
        return amountToPay;
    }
    public void setamountToPay(BigDecimal amountToPay) {
        this.amountToPay = amountToPay;
    }
    public BigDecimal getamountToReceive() {
        return amountToReceive;
    }
    public void setamountToReceive(BigDecimal amountToReceive) {
        this.amountToReceive = amountToReceive;
    }
    public BigDecimal getBalance() {
        return balance;
    }
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

}
