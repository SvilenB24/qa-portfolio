public class DVD extends LibraryItem {
    private int durationMinutes;

    public DVD(String title, String id, int durationMinutes) {
        super(title, id);
        if (durationMinutes <= 0) {
            throw new IllegalArgumentException("Duration must be at least a minute");
        }
        this.durationMinutes = durationMinutes;
    }

    @Override
    public int getLoanPeriodDays() {
        return 7; // DVDs can be borrowed for 7 days
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | duration: %d min", durationMinutes);
    }
}
