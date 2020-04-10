package controller;

import domain.Menus;
import domain.Tables;
import view.InputView;
import view.OutputView;

public class PosController {
    public void run() {
        Tables tables = new Tables();
        Menus menus = new Menus();
        Command command = null;

        do {
            OutputView.printMain();
            command = getCommand();
            PosMachine posMachine = command.getPosMachine();
            posMachine.execute(tables, menus);
        } while (!command.isTerminate());
    }

    private Command getCommand() {
        try {
            int command = InputView.inputCommand();
            return Command.of(command);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCommand();
        }
    }
}
