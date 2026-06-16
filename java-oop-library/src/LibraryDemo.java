public class LibraryDemo {

    public static void main(String[] args) {

        Library library = new Library();
        library.addItem(new Book("The Great Gatsby", "Book 1", "F. Scott Fitzgerald"));
        library.addItem(new Book("The Super Gatsby", "Book 2", "F. Scott Fitzgerald"));
        library.addItem(new DVD("Inception", "DVD 1", 120));

        System.out.println("All items in the library:");
        library.listAll(); // polymorphism: Book and DVD print differently

        System.out.println("Total items: " + library.countItems());

        System.out.println("Borrow 'The Great Gatsby': " + library.borrowItem("The Great Gatsby"));
        System.out.println("Borrow 'The Great Gatsby' again: " + library.borrowItem("The Great Gatsby"));

        System.out.println("\nAfter borrowing:");
        library.listAll();

        // Borrowing a non-existent title throws; try-catch keeps the program alive
        try {
            library.borrowItem("Nonexistent Title");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught error: " + e.getMessage());
        }
        System.out.println("Program continues to run.");
    }
}
