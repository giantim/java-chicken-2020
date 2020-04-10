package domain.order;

public class Quantity {
    private static final int MIN_QUANTITY = 1;
    private static final int MAX_QUANTITY = 99;

    private final int quantity;

    public Quantity(int quantity) {
        if (quantity < MIN_QUANTITY || quantity > MAX_QUANTITY) {
            throw new IllegalArgumentException("수량은 1 이상 99 미만이어야 합니다.");
        }

        this.quantity = quantity;
    }

    public Quantity add(int quantity) {
        return new Quantity(this.quantity + quantity);
    }
}
