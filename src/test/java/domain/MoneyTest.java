package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {
    @DisplayName("금액 생성")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void moneyConstructorTest(int input) {
        Assertions.assertThatThrownBy(() -> {
            new Money(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액 더하기")
    @Test
    void addTest() {
        Money money = new Money(5000);
        Money addMoney = money.add(1000);

        Assertions.assertThat(addMoney).extracting("money").isEqualTo(6000d);
    }

    @DisplayName("금액 빼기")
    @Test
    void minusMoney() {
        Money money = new Money(5000);
        Money minusMoney = money.minus(3000d);

        Assertions.assertThat(minusMoney).extracting("money").isEqualTo(2000d);
    }

    @DisplayName("금액 할인하기")
    @Test
    void discountMoney() {
        Money money = new Money(10000);
        Money discountMoney = money.discount(0.95);

        Assertions.assertThat(discountMoney).extracting("money").isEqualTo(9500d);
    }
}
