package Task6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderFactoryTest {

    @Test
    void testCreateOrder_DineInOrder() {
        OrderFactory factory = new OrderFactory();
        Order order = factory.createOrder(OrderFactory.OrderType.dine_in_order);
        assertNotNull(order);
        assertTrue(order instanceof DineInOrder);
    }

    @Test
    void testCreateOrder_TakeAwayOrder() {
        OrderFactory factory = new OrderFactory();
        Order order = factory.createOrder(OrderFactory.OrderType.take_away_order);
        assertNotNull(order);
        assertTrue(order instanceof TakeAwayOrder);
    }

    @Test
    void testCreateOrder_DeliveryOrder() {
        OrderFactory factory = new OrderFactory();
        Order order = factory.createOrder(OrderFactory.OrderType.delivery_order);
        assertNotNull(order);
        assertTrue(order instanceof DeliveryOrder);
    }

}

