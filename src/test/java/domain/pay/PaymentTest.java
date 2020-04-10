package domain.pay;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PaymentTest {
    @DisplayName("입력한 값에 맞는 결제 수단 반환")
    @Test
    void paymentOfTest() {
        Payment credit = Payment.of(1);
        Payment cash = Payment.of(2);

        Assertions.assertThat(credit).isEqualTo(Payment.CREDIT);
        Assertions.assertThat(cash).isEqualTo(Payment.CASH);
    }

    @DisplayName("잘못된 결제수단 번호 입력시 예외 출력")
    @Test
    void paymentOfExceptionTest() {
        Assertions.assertThatThrownBy(() -> {
            Payment.of(3);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
