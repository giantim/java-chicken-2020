package domain.order;

import domain.Menu;
import domain.pay.Money;
import domain.pay.Payment;
import domain.strategy.ChickenDiscount;
import domain.strategy.DiscountStrategy;
import domain.strategy.PaymentStrategyFactory;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Orders {
    private Map<Menu, Quantity> orders;

    public Orders() {
        this.orders = new HashMap<>();
    }

    public void add(Menu menu, Quantity quantity) {
        if (this.orders.containsKey(menu)) {
            Quantity originalQuantity = this.orders.get(menu);
            this.orders.put(menu, originalQuantity.add(quantity));
            return;
        }
        this.orders.put(menu, quantity);
    }

    public Money getPrice(Payment payment) {
        double ordersSum = this.orders.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue().getQuantity())
                .sum();
        Money ordersMenuSum = new Money(ordersSum);

        DiscountStrategy categoryStrategy = new ChickenDiscount();
        DiscountStrategy paymentStrategy = PaymentStrategyFactory.of(payment);
        Money discountChicken = ordersMenuSum.minus(categoryStrategy.discount(this.orders));
        Money discountPayment = discountChicken.discount(paymentStrategy.discount());

        return discountPayment;
    }

    public Map<Menu, Quantity> getOrders() {
        return Collections.unmodifiableMap(this.orders);
    }
}
