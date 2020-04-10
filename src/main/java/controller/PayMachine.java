package controller;

import domain.Menus;
import domain.Table;
import domain.Tables;
import domain.pay.Money;
import domain.pay.Payment;
import view.InputView;
import view.OutputView;

public class PayMachine implements PosMachine {
    @Override
    public void execute(Tables tables, Menus menus) {
        OutputView.printTables(tables.getTables());

        Table table = getTable(tables);

        if (table.hasOrder()) {
            OutputView.printOrders(table);

            Payment payment = getPayment(table);
            Money amount = table.pay(payment);
            OutputView.printAmount(amount.getMoney());
            table.clearOrders();
            return;
        }
        System.out.println("주문이 없습니다.");
    }

    private Table getTable(Tables tables) {
        try {
            int tableNumber = InputView.inputTableNumber();
            return tables.of(tableNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getTable(tables);
        }
    }

    private Payment getPayment(Table table) {
        try {
            int paymentNumber = InputView.inputPaymentNumber(table.getNumber());
            return Payment.of(paymentNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPayment(table);
        }
    }
}
