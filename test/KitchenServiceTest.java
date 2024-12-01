package test;
import Service.*;
import Orders.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class KitchenServiceTest {

	
    @Test
    void testProcessDineInOrder() {
    	KitchenService kitchen = new KitchenService();
        Orders dineInOrder = new DineInOrder();

        assertEquals("DineInOrder", dineInOrder.getClass().getSimpleName(), "Order type mismatch for DineInOrder");
        kitchen.processOrder(dineInOrder);
    }

    @Test
    void testProcessTakeAwayOrder() {
    	KitchenService kitchen = new KitchenService();
        Order takeAwayOrder = new TakeAwayOrder();

        assertEquals("TakeAwayOrder", takeAwayOrder.getClass().getSimpleName(), "Order type mismatch for TakeAwayOrder");
        kitchen.processOrder(takeAwayOrder);
    }

    @Test
    void testProcessDeliveryOrder() {
    	KitchenService kitchen = new KitchenService();
        Orders deliveryOrder = new DeliveryOrder();

        assertEquals("DeliveryOrder", deliveryOrder.getClass().getSimpleName(), "Order type mismatch for DeliveryOrder");
        kitchen.processOrder(deliveryOrder);
    }
}