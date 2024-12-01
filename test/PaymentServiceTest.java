package test;
import Service.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import Orders.*;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentServiceTest {

    @ParameterizedTest
    @DisplayName("Test getPrice for valid order types")
    @CsvSource({
        "delivery_order, 10.0",
        "dine_in_order, 20.0",
        "take_away_order, 15.0"
    })
    void testGetPriceForValidOrderType(String orderTypeName, double expectedPrice) {
        PaymentService payment = new PaymentService();
        OrderFactory.OrderType orderType = OrderFactory.OrderType.valueOf(orderTypeName);
        assertEquals(expectedPrice, payment.getPrice(orderType), 
            "Price for " + orderTypeName + " is incorrect");
    }

    @ParameterizedTest
    @DisplayName("Test getPrice for invalid or null order type")
    @CsvSource({
        ", 0.0"
    })
    void testGetPriceForInvalidOrderType(String orderTypeName, double expectedPrice) {
        PaymentService payment = new PaymentService();
        OrderFactory.OrderType orderType = orderTypeName == null ? null : OrderFactory.OrderType.valueOf(orderTypeName);
        assertEquals(expectedPrice, payment.getPrice(orderType), 
            "Price for invalid or null order type is incorrect");
    }
}

