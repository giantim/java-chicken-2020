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

        int tableNumber = InputView.inputTableNumber();
        Table table = tables.of(tableNumber);

        if (table.hasOrder()) {
            OutputView.printOrders(table);

            int paymentNumber = InputView.inputPaymentNumber(tableNumber);
            Payment payment = Payment.of(paymentNumber);
            Money amount = table.pay(payment);
            OutputView.printAmount(amount.getMoney());
            table.clearOrders();
            return;
        }
        System.out.println("주문이 없습니다.");
    }
}
