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

        Table table = getTable(tables);

        OutputView.printMenus(menus.getMenus());
        Menu menu = getMenu(menus);

        int quantityNumber = InputView.inputQuantityNumber();
        validateAddMenu(table, menu, quantityNumber);
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

    private Menu getMenu(Menus menus) {
        try {
            int menuNumber = InputView.inputMenuNumber();
            return menus.of(menuNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getMenu(menus);
        }
    }

    private void validateAddMenu(Table table, Menu menu, int quantityNumber) {
        try {
            Quantity quantity = new Quantity(quantityNumber);
            table.addMenu(menu, quantity);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
