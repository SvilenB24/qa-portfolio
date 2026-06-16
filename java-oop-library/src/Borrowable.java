public interface Borrowable {
    boolean borrow();
    void returnItem();
    boolean isAvailable();
}
