package Service;
import Orders.*;
import java.util.ArrayList;

public class FoodService {
    private final OrderFactory orderFactory;
    private final KitchenService kitchenservice;
    private final PaymentService paymentservice;

    public FoodService(OrderFactory orderFactory, KitchenService kitchenservice, PaymentService paymentservice) {
        this.orderFactory = orderFactory;
        this.kitchenservice = kitchenservice;
        this.paymentservice = paymentservice;
    }

    ArrayList<String> OrderList = new ArrayList<>();
    public Orders makeOrder(OrderType type) {
        Orders order = orderFactory.createOrder(type); //
        order.OrderObject(OrderList);
        return order;
    }

    public void displayOrderPrice(OrderType type) {
        double price = paymentservice.getPrice(type);
        System.out.println("The price for " + type + " is: $" + price);
    }

    public void processOrder(OrderType type) {
        Orders order = orderFactory.createOrder(type);
        double price = paymentservice.getPrice(type);
        kitchenservice.processOrder(order);
        System.out.println("Order for " + type + " processed. Total price: $" + price);
    }
}