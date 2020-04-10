package domain.order;

import domain.Menu;

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

    public Map<Menu, Quantity> getOrders() {
        return Collections.unmodifiableMap(this.orders);
    }
}
