package controller;

import domain.Menu;
import domain.Menus;
import domain.Table;
import domain.Tables;
import domain.order.Quantity;
import view.InputView;
import view.OutputView;

public class OrderMachine implements PosMachine {
    @Override
    public void execute(Tables tables, Menus menus) {
        OutputView.printTables(tables.getTables());

        int tableNumber = InputView.inputTableNumber();
        Table table = tables.of(tableNumber);

        OutputView.printMenus(menus.getMenus());

        int menuNumber = InputView.inputMenuNumber();
        Menu menu = menus.of(menuNumber);

        int quantityNumber = InputView.inputQuantityNumber();
        Quantity quantity = new Quantity(quantityNumber);
        table.addMenu(menu, quantity);
    }
}
