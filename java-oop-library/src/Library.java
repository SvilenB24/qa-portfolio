import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<LibraryItem> items;

    public Library() {
        items = new ArrayList<>();
    }

    public void addItem(LibraryItem item) {
        items.add(item);
    }

    public void listAll() {
        for (LibraryItem item : items) {
            System.out.println(item);
        }
    }

    public int countItems() {
        return items.size();
    }

    public boolean borrowItem(String title) {
        for (LibraryItem item : items) {
            if (item.getTitle().equals(title)) {
                return item.borrow(); // true = borrowed, false = already taken
            }
        }
        throw new IllegalArgumentException("No item found with title: " + title);
    }
}
