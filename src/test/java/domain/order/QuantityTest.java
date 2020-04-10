package domain.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class QuantityTest {
    @DisplayName("잘못된 수량으로 생성시 예외 출력 테스트")
    @ParameterizedTest
    @ValueSource(ints = {-1, 100})
    void quantityConstructorTest(int input) {
        Assertions.assertThatThrownBy(() -> {
            new Quantity(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("수량 더하기 기능")
    @Test
    void addQuantityTest() {
        Quantity fiveQuantity = new Quantity(5);
        Quantity sevenQuantity = fiveQuantity.add(new Quantity(2));

        Assertions.assertThat(sevenQuantity.getQuantity()).isEqualTo(7);
    }
}
