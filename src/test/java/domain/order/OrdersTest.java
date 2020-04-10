package domain.order;

import domain.MenuFixture;
import domain.MenuRepository;
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
}
