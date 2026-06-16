public abstract class LibraryItem implements Borrowable {
    private String title;
    private String id;
    private boolean isAvailable;

    public static int totalItems = 0;

    public LibraryItem(String title, String id) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Id cannot be empty");
        }

        this.title = title;
        this.id = id;
        this.isAvailable = true;

        totalItems++; // counts every item created via subclasses (Book, DVD) through super(...)
    }

    public String getTitle() { return title; }
    public String getId() { return id; }

    @Override
    public boolean isAvailable() { return isAvailable; }

    @Override
    public boolean borrow() {
        if (isAvailable) {
            isAvailable = false;
            return true;  // successfully borrowed
        }
        return false;     // already taken
    }

    @Override
    public void returnItem() {
        if (!isAvailable) {
            isAvailable = true;
        }
    }

    // Abstract: every concrete type MUST define its own loan period (polymorphism)
    public abstract int getLoanPeriodDays();

    @Override
    public String toString() {
        return String.format("%s : %s | available: %b", title, id, isAvailable);
    }
}
