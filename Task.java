package Task6;

interface Order {
    void order();
}

class DineInOrder implements Order {
    public void order() {
        System.out.println("DineInOrder");
    }
}

class TakeAwayOrder implements Order {
    public void order() {
        System.out.println("TakeAwayOrder");
    }
}

class DeliveryOrder implements Order {
    public void order() {
        System.out.println("DeliveryOrder");
    }
}

class OrderFactory {
    public enum OrderType {
        delivery_order,
        dine_in_order,
        take_away_order
    }

    public Order createOrder(OrderType type) {
        switch (type) {
            case delivery_order:
                return new DeliveryOrder();
            case dine_in_order:
                return new DineInOrder();
            case take_away_order:
                return new TakeAwayOrder();
            default:
                throw new IllegalArgumentException("Unknown order type: " + type);
        }
    }
}

class FoodService {
    private final OrderFactory orderFactory;

    public FoodService(OrderFactory orderFactory) {
        this.orderFactory = orderFactory;
    }

    public Order makeOrder(OrderFactory.OrderType type) {
        Order order = orderFactory.createOrder(type); // Fix: call the correct method
        order.order(); // Fix: call the instance's method, not the interface
        return order;
    }
}

public class Task {
    public static void main(String[] args) {
        OrderFactory factory = new OrderFactory();
        FoodService creator = new FoodService(factory);

        // Example: Create and execute an order
        creator.makeOrder(OrderFactory.OrderType.dine_in_order);
        creator.makeOrder(OrderFactory.OrderType.take_away_order);
        creator.makeOrder(OrderFactory.OrderType.delivery_order);
    }
}
