package service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

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
        return total;
    } 
    public void splitBill() {
        // Implement the logic to split the bill among persons
        BigDecimal totalBill = getTotalBill();
        BigDecimal amountPerPerson = totalBill.divide(BigDecimal.valueOf(totalAmountConsumedMap.size()),2, RoundingMode.HALF_UP);
        
        
        for(Person p : totalAmountConsumedMap.keySet()){

            BigDecimal balance = totalAmountConsumedMap.get(p).subtract(amountPerPerson);
            p.setBalance(balance);
        }

        

    }


}
