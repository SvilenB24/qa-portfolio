import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private String memberId;
    private List<LibraryItem> borrowedItems;   // items this member currently has

    public Member(String name, String memberId) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (memberId == null || memberId.isBlank()) {
            throw new IllegalArgumentException("Member id cannot be empty");
        }
        this.name = name;
        this.memberId = memberId;
        this.borrowedItems = new ArrayList<>();
    }

    public String getName() { return name; }
    public String getMemberId() { return memberId; }
    public List<LibraryItem> getBorrowedItems() { return borrowedItems; }

    public int borrowedCount() {
        return borrowedItems.size();
    }

    @Override
    public String toString() {
        return String.format("%s (%s) - borrowed %d item(s)", name, memberId, borrowedCount());
    }
}
