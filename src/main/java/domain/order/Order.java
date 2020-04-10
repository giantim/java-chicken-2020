package domain.order;

import domain.Menu;

public class Order {
    private Menu menu;
    private Quantity quantity;

    public Order(Menu menu, Quantity quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    public void addQuantity(int quantity) {
        this.quantity = this.quantity.add(quantity);
    }
}
