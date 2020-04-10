package domain.strategy;

import domain.pay.Payment;

public class PaymentStrategyFactory {
    private PaymentStrategyFactory() {}

    public static DiscountStrategy of(Payment payment) {
        if (payment.isCredit()) {
            return new CreditDiscount();
        }
        return new CashDiscount();
    }
}
