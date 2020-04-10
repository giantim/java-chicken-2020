package domain.strategy;

import domain.Menu;
import domain.order.Quantity;

import java.util.Map;

public class CreditDiscount implements DiscountStrategy {
    private static final double CREDIT_RATE = 0.95;

    @Override
    public double discount(Map<Menu, Quantity> orders) {
        throw new UnsupportedOperationException();
    }

    @Override
    public double discount() {
        return CREDIT_RATE;
    }
}
