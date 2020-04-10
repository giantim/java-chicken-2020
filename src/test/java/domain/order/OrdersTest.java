package domain.order;

import domain.MenuFixture;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.AbstractMap;

public class OrdersTest {
    @DisplayName("주문 목록에 메뉴 추가")
    @Test
    void addTest() {
        Orders orders = new Orders();
        orders.add(MenuFixture.FRIED_CHICKEN, new Quantity(1));
        orders.add(MenuFixture.SOURCE_CHICKEN, new Quantity(1));

        Assertions.assertThat(orders.getOrders()).contains(
                new AbstractMap.SimpleEntry<>(MenuFixture.FRIED_CHICKEN, new Quantity(1)),
                new AbstractMap.SimpleEntry<>(MenuFixture.SOURCE_CHICKEN, new Quantity(1))
        );
    }

    @DisplayName("기존 메뉴 추가 시 수량 변경")
    @Test
    void addAlreadyMenuTest() {
        Orders orders = new Orders();
        orders.add(MenuFixture.FRIED_CHICKEN, new Quantity(1));
        orders.add(MenuFixture.FRIED_CHICKEN, new Quantity(5));

        Assertions.assertThat(orders.getOrders().get(MenuFixture.FRIED_CHICKEN)).isEqualTo(new Quantity(6));
    }

    @DisplayName("주문이 있는지 확인")
    @Test
    void hasOrderTest() {
        Orders noOrders = new Orders();
        Orders hasOrders = new Orders();
        hasOrders.add(MenuFixture.SOURCE_CHICKEN, new Quantity(1));

        Assertions.assertThat(noOrders.hasOrder()).isFalse();
        Assertions.assertThat(hasOrders.hasOrder()).isTrue();
    }

    @DisplayName("주문 내역 출력")
    @Test
    void historyTest() {
        Orders orders = new Orders();
        orders.add(MenuFixture.FRIED_CHICKEN, new Quantity(1));
        orders.add(MenuFixture.SOURCE_CHICKEN, new Quantity(5));

        Assertions.assertThat(orders.history()).isEqualTo(
                "후라이드 1 16000\n양념치킨 5 80000"
        );
    }
}
