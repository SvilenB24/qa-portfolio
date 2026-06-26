public class DataBase {
    private final User[] users;

    public DataBase(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Database size must be > 0");
        }
        this.users = new User[size];
    }

    public User[] getUsers() {
        return users;
    }

    public boolean isFull() {
        return firstFreeIndex() == -1;
    }

    public boolean isEmpty() {
        for (User u : users) {
            if (u != null) return false;
        }
        return true;
    }

    public int firstFreeIndex() {
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) return i;
        }
        return -1;
    }

    public int findIndexByUsername(String username) {
        if (username == null) return -1;
        String target = username.trim();
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].getUsername().equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public boolean addUser(User user) {
        int idx = firstFreeIndex();
        if (idx == -1) return false;
        users[idx] = user;
        return true;
    }

    public boolean deleteByUsername(String username) {
        int idx = findIndexByUsername(username);
        if (idx == -1) return false;
        users[idx] = null;
        return true;
    }
}
