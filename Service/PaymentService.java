package Service;

import Orders.*;
import Orders.OrderFactory.OrderType;

import java.util.HashMap;

public class PaymentService {
    private final HashMap<OrderType, Double> prices;

    public PaymentService() {
        prices = new HashMap<>();
        OrderFactory orderFactory = new OrderFactory();

        prices.put(OrderType.delivery_order, 10.0); 
        prices.put(OrderType.dine_in_order, 20.0);  
        prices.put(OrderType.take_away_order, 15.0);  
    }

    public double getPrice(OrderType type) {
        return prices.getOrDefault(type, 0.0);
    }
}
