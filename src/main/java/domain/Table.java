package domain;

import domain.order.Orders;
import domain.order.Quantity;
import domain.pay.Money;
import domain.pay.Payment;

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

    public boolean hasOrder() {
        return this.orders.hasOrder();
    }

    public String ordersHistory() {
        return this.orders.history();
    }

    public void clearOrders() {
        this.orders.clear();
    }

    public Money pay(Payment payment) {
        return this.orders.getPrice(payment);
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
