package domain.strategy;

import domain.Menu;
import domain.order.Quantity;

import java.util.Map;

public class ChickenDiscount implements DiscountStrategy {
    private static final int CHICKEN_DISCOUNT = 10_000;
    private static final int CHICKEN_STANDARD = 10;

    @Override
    public double discount(Map<Menu, Quantity> orders) {
        int count = orders.entrySet().stream()
                .filter(entry -> entry.getKey().isChicken())
                .mapToInt(entry -> entry.getValue().getQuantity())
                .sum();

        return CHICKEN_DISCOUNT * (count / CHICKEN_STANDARD);
    }
}
