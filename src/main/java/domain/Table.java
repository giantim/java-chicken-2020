package domain;

import domain.order.Orders;
import domain.order.Quantity;

public class Table {
    private final int number;
    private final Orders orders;

    public Table(final int number) {
        this.number = number;
        this.orders = new Orders();
    }

    public void addMenu(Menu menu, Quantity quantity) {
        this.orders.add(menu, quantity);
    }

    public boolean isSelectTable(int tableNumber) {
        return this.number == tableNumber;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
