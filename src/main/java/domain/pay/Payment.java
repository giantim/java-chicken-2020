package domain.pay;

import java.util.Arrays;

public enum Payment {
    CREDIT(1),
    CASH(2);

    private int paymentType;

    Payment(int paymentType) {
        this.paymentType = paymentType;
    }

    public static Payment of(int paymentType) {
        return Arrays.stream(values())
                .filter(p -> p.paymentType == paymentType)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 결제수단을 입력했습니다."));
    }

    public boolean isCredit() {
        return this == CREDIT;
    }
}
