package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputCommand() {
        try {
            System.out.println("\n## 원하는 기능을 선택하세요.");
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return inputCommand();
        }
    }

    public static int inputTableNumber() {
        try {
            System.out.println("\n## 테이블을 선택하세요.");
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return inputTableNumber();
        }
    }

    public static int inputMenuNumber() {
        try {
            System.out.println("\n## 등록할 메뉴를 선택하세요.");
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return inputMenuNumber();
        }
    }

    public static int inputQuantityNumber() {
        try {
            System.out.println("\n## 메뉴의 수량을 입력하세요.");
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return inputQuantityNumber();
        }
    }

    public static int inputPaymentNumber(int tableNumber) {
        try {
            System.out.println(String.format("## %d번 테이블의 결제를 진행합니다.", tableNumber));
            System.out.println("## 신용카드는 1번, 현금은 2번");
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return inputPaymentNumber(tableNumber);
        }
    }
}
