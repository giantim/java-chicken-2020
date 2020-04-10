package domain;

import domain.order.Quantity;
import domain.pay.Payment;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TableTest {
    @DisplayName("주문 추가")
    @Test
    void addMenuTest() {
        Table table = TableRepository.tables().get(0);
        table.addMenu(MenuFixture.FRIED_CHICKEN, new Quantity(1));

        Assertions.assertThat(table.ordersHistory()).isEqualTo(
                "후라이드 1 16000"
        );
    }

    @DisplayName("주문이 있는지 확인")
    @Test
    void hasOrderTest() {
        Table orderedTable = TableRepository.tables().get(0);
        orderedTable.addMenu(MenuFixture.FRIED_CHICKEN, new Quantity(1));
        Table nonOrderTable = TableRepository.tables().get(1);

        Assertions.assertThat(orderedTable.hasOrder()).isTrue();
        Assertions.assertThat(nonOrderTable.hasOrder()).isFalse();
    }

    @DisplayName("주문 비우기")
    @Test
    void clearOrdersTest() {
        Table table = TableRepository.tables().get(0);
        table.addMenu(MenuFixture.FRIED_CHICKEN, new Quantity(1));

        Assertions.assertThat(table.hasOrder()).isTrue();
        table.clearOrders();
        Assertions.assertThat(table.hasOrder()).isFalse();
    }

    @DisplayName("주문 내역의 총 금액 반환")
    @Test
    void payTest() {
        Table table = TableRepository.tables().get(0);
        table.addMenu(MenuFixture.FRIED_CHICKEN, new Quantity(1));
        table.addMenu(MenuFixture.SOURCE_CHICKEN, new Quantity(3));

        Assertions.assertThat(table.pay(Payment.CASH).getMoney()).isEqualTo(64_000d);
    }
}
