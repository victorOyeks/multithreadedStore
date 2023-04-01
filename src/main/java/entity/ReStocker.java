package entity;

public class ReStocker{
    private final Store store;
    private final int quantity;

    public ReStocker(Store store, int quantity) {
        this.store = store;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ReStocker{" +
                "store=" + store +
                ", quantity=" + quantity +
                '}';
    }
}
