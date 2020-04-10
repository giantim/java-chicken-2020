package domain.strategy;

import domain.MenuFixture;
import domain.order.Orders;
import domain.order.Quantity;
import domain.pay.Payment;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ChickenDiscountTest {
    @DisplayName("치킨 메뉴가 10개 이상일 때 금액 할인")
    @Test
    void discountTest() {
        Orders orders = new Orders();
        orders.add(MenuFixture.FRIED_CHICKEN, new Quantity(10));
        orders.add(MenuFixture.SOURCE_CHICKEN, new Quantity(15));

        Assertions.assertThat(orders.getPrice(Payment.CASH)).extracting("money").isEqualTo(380_000d);
    }
}
