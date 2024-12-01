package Orders;

public class OrderFactory {
    public enum OrderType {
        delivery_order,
        dine_in_order,
        take_away_order
    }

    public Orders createOrder(OrderType type) {
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