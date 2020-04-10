package domain.strategy;

import domain.Menu;
import domain.order.Quantity;

import java.util.Map;

public class CashDiscount implements DiscountStrategy {
    private static final int CASH_RATE = 1;

    @Override
    public double discount(Map<Menu, Quantity> orders) {
        throw new UnsupportedOperationException();
    }

    @Override
    public double discount() {
        return CASH_RATE;
    }
}
