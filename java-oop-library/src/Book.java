public class Book extends LibraryItem {
    private String author;

    public Book(String title, String id, String author) {
        super(title, id); // build the parent (LibraryItem) part first
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("Author cannot be empty");
        }
        this.author = author;
    }

    @Override
    public int getLoanPeriodDays() {
        return 30; // books can be borrowed for 30 days
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | author: %s", author);
    }
}
