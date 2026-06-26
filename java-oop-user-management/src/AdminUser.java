public interface AdminUser extends User {
    void deleteUser(String username);

    User createUser(String username, boolean isAdmin);

    void printAllUsers();
}
