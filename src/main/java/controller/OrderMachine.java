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
        Table table = validateTable(tables, tableNumber);

        OutputView.printMenus(menus.getMenus());
        int menuNumber = InputView.inputMenuNumber();
        Menu menu = validateMenu(menus, menuNumber);

        int quantityNumber = InputView.inputQuantityNumber();
        validateAddMenu(table, menu, quantityNumber);
    }

    private Table validateTable(Tables tables, int tableNumber) {
        try {
            return tables.of(tableNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return validateTable(tables, tableNumber);
        }
    }

    private Menu validateMenu(Menus menus, int menuNumber) {
        try {
            return menus.of(menuNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return validateMenu(menus, menuNumber);
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
