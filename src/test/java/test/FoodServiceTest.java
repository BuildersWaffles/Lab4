package test;

import Service.*;
import Orders.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class FoodServiceTest {

    private static Stream<OrderType> orderTypeProvider() {
        return Stream.of(
                OrderType.delivery_order,
                OrderType.dine_in_order,
                OrderType.take_away_order
        );
    }

    @DisplayName("Test makeOrder with different order types")
    @ParameterizedTest(name = "Testing {0}")
    @MethodSource("orderTypeProvider")
    void testMakeOrderParameterized(OrderType orderType) {
        OrderFactory factory = new OrderFactory();
        KitchenService kitchen = new KitchenService();
        PaymentService payment = new PaymentService();
        FoodService foodService = new FoodService(factory, kitchen, payment);

        Orders order = foodService.makeOrder(orderType);

        switch (orderType) {
            case delivery_order -> assertEquals(DeliveryOrder.class, order.getClass(), "Expected a DeliveryOrder instance.");
            case dine_in_order -> assertEquals(DineInOrder.class, order.getClass(), "Expected a DineInOrder instance.");
            case take_away_order -> assertEquals(TakeAwayOrder.class, order.getClass(), "Expected a TakeAwayOrder instance.");
        }
    }

    @DisplayName("Test processOrder for different order types")
    @ParameterizedTest(name = "Processing {0}")
    @MethodSource("orderTypeProvider")
    void testProcessOrderParameterized(OrderType orderType) {
        OrderFactory factory = new OrderFactory();
        KitchenService kitchen = new KitchenService();
        PaymentService payment = new PaymentService();
        FoodService foodService = new FoodService(factory, kitchen, payment);

        assertDoesNotThrow(() -> foodService.processOrder(orderType), "Processing order threw an exception");
    }
}