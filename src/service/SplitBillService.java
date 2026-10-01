package service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

import exception.InvalidAmountException;
import models.Order;
import models.Person;
import models.Product;

public class SplitBillService {

    private Map<Person, List<Order>> ordersMap;
    private Map<Person, BigDecimal> totalAmountConsumedMap;

    public SplitBillService(Map<Person, List<Order>> ordersMap) {
        this.ordersMap = ordersMap;
        this.totalAmountConsumedMap = new HashMap<>();
    }

    public void totalAmountConsumedMap() {
        for(Person p : ordersMap.keySet()){
            List<Order> orders = ordersMap.get(p);
            orders.forEach(order -> {
                BigDecimal totalPrice = order.getProducts().stream()
                        .map(Product::getSubtotal)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
                totalAmountConsumedMap.put(p, totalAmountConsumedMap.getOrDefault(p, BigDecimal.ZERO).add(totalPrice));
            });
        }
    }

    public BigDecimal getTotalBill(){
        BigDecimal total = BigDecimal.ZERO;
        for(Person p : totalAmountConsumedMap.keySet()){
            total = totalAmountConsumedMap.get(p).add(total);
        }
        if(total.compareTo(BigDecimal.ZERO) < 0){
            throw new InvalidAmountException("Total bill cannot be negative");
        }
        return total;
    } 
    public void splitBill() {
        // Implement the logic to split the bill among persons
        BigDecimal totalBill = getTotalBill();
        if(totalAmountConsumedMap.isEmpty()){
            throw new ArithmeticException("No persons to split the bill");
        }
        BigDecimal amountPerPerson = totalBill.divide(BigDecimal.valueOf(totalAmountConsumedMap.size()),2, RoundingMode.HALF_UP);
        
        
        for(Person p : totalAmountConsumedMap.keySet()){
            if(p.getAmountPaid() == null){
                throw new InvalidAmountException("Le montant payé doit exister pour chaque personne");
            }
            BigDecimal balance = p.getAmountPaid().subtract(amountPerPerson);
            p.setBalance(balance);
        }
        

    }


}
