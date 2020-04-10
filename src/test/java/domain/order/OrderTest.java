package domain.order;

import domain.Menu;
import domain.MenuRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderTest {
    @DisplayName("주문 정보 생성")
    @Test
    void orderConstructorTest() {
        Menu friedChicken = MenuRepository.menus().get(0);
        Quantity quantity = new Quantity(1);
        Order order = new Order(friedChicken, quantity);

        Assertions.assertThat(order).isInstanceOf(Order.class);
    }

    @DisplayName("동일 주문에 수량 추가")
    @Test
    void addQuantityTest() {
        Menu friedChicken = MenuRepository.menus().get(0);
        Quantity quantity = new Quantity(1);
        Order order = new Order(friedChicken, quantity);
        order.addQuantity(5);

        Assertions.assertThat(order).extracting("quantity").extracting("quantity").isEqualTo(6);
    }
}
