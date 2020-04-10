package view;

import domain.Menu;
import domain.Table;

import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String BOTTOM_ORDER_LINE = "└ ₩ ┘";

    public static void printMain() {
        System.out.println("## 메인화면");
        System.out.println("1 - 주문등록");
        System.out.println("2 - 결제하기");
        System.out.println("3 - 프로그램 종료");
        System.out.println();
    }

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printBottomLine(tables);
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    private static void printLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printBottomLine(final List<Table> tables) {
        for (Table table : tables) {
            printBottom(table);
        }
        System.out.println();
    }

    private static void printBottom(Table table) {
        if (table.hasOrder()) {
            System.out.print(BOTTOM_ORDER_LINE);
            return;
        }
        System.out.print(BOTTOM_LINE);
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    public static void printOrders(Table table) {
        System.out.println("메뉴 수량 금액");
        System.out.println(table.ordersHistory());
        System.out.println();
    }

    public static void printAmount(double money) {
        System.out.println("## 최종 결제할 금액");
        System.out.println(String.format("%.0f 원", money));
        System.out.println();
    }
}
