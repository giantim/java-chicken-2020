package domain.order;

public class Quantity {
    private static final int MIN_QUANTITY = 0;
    private static final int MAX_QUANTITY = 99;

    private final int quantity;

    public Quantity(int quantity) {
        if (quantity < MIN_QUANTITY || quantity > MAX_QUANTITY) {
            throw new IllegalArgumentException("수량은 0 이상 99 이하이어야 합니다.");
        }

        this.quantity = quantity;
    }

    public Quantity add(Quantity quantity) {
        return new Quantity(this.quantity + quantity.quantity);
    }

    public int getQuantity() {
        return this.quantity;
    }
}
