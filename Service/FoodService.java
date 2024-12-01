package Service;
import Orders.*;

public class FoodService {
    private final OrderFactory orderFactory;
    private final KitchenService kitchen; 
    private final PaymentService payment;
    
    public FoodService(OrderFactory orderFactory, KitchenService kitchen, PaymentService payment) {
        this.orderFactory = orderFactory;
        this.kitchen = kitchen;
        this.payment = payment;
    }

    public Orders makeOrder(OrderFactory.OrderType type) {
        Orders order = orderFactory.createOrder(type); //
        order.OrderObject(); 
        return order;
    }
    
    public void displayOrderPrice(OrderFactory.OrderType type) {
        double price = payment.getPrice(type);
        System.out.println("The price for " + type + " is: $" + price);
    }  
    
    public void processOrder(OrderFactory.OrderType type) {
        Orders order = orderFactory.createOrder(type);
        double price = payment.getPrice(type);        
        kitchen.processOrder(order);        
        System.out.println("Order for " + type + " processed. Total price: $" + price);
    }
}