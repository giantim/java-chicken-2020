package domain.pay;

public class Money {
    private static final int MIN_MONEY = 1;

    private double money;

    public Money(double money) {
        if (money < MIN_MONEY) {
            throw new IllegalArgumentException("잘못된 금액을 입력하였습니다.");
        }

        this.money = money;
    }

    public Money add(double money) {
        return new Money(this.money + money);
    }

    public Money minus(double money) {
        return new Money(this.money - money);
    }

    public Money discount(double percent) {
        return new Money(this.money * percent);
    }

    public double getMoney() {
        return this.money;
    }
}
