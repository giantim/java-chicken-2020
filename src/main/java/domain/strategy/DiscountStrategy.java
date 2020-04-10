package domain.strategy;

import domain.Menu;
import domain.order.Quantity;

import java.util.Map;

public interface DiscountStrategy {
    double discount(Map<Menu, Quantity> orders);

    double discount();
}
