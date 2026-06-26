public class AdminUserImpl extends AbstractUser implements AdminUser {

    private static final int DEFAULT_DB_SIZE = 10;

    private final DataBase dataBase;

    public AdminUserImpl(String username) {
        super(username);
        this.dataBase = new DataBase(DEFAULT_DB_SIZE);
    }

    @Override
    public User createUser(String username, boolean isAdmin) {
        if (username == null || username.trim().isEmpty()) {
            System.out.println("Cannot create user: username is empty.");
            return null;
        }

        if (dataBase.findIndexByUsername(username) != -1) {
            System.out.println("Cannot create user: '" + username.trim() + "' already exists.");
            return null;
        }

        if (dataBase.isFull()) {
            System.out.println("Cannot create user: database is full.");
            return null;
        }

        User newUser = isAdmin ? new AdminUserImpl(username.trim()) : new UserImpl(username.trim());

        boolean added = dataBase.addUser(newUser);
        if (!added) {
            System.out.println("Cannot create user: database is full.");
            return null;
        }

        return newUser;
    }

    @Override
    public void deleteUser(String username) {

        if (dataBase.isEmpty()) {
            System.out.println("Cannot delete user: database is empty.");
            return;
        }

        boolean deleted = dataBase.deleteByUsername(username);
        if (!deleted) {
            System.out.println("Cannot delete user: '" + (username == null ? "null" : username.trim()) + "' not found.");
        }
    }

    @Override
    public void printAllUsers() {
        User[] users = dataBase.getUsers();

        System.out.println("=== USERS IN DATABASE (owner admin: " + getUsername() + ") ===");
        boolean hasAny = false;

        for (User u : users) {
            if (u != null) {
                hasAny = true;

                String type = (u instanceof AdminUser) ? "ADMIN" : "USER";
                String logged = (u instanceof AbstractUser && ((AbstractUser) u).isLoggedIn()) ? "logged-in" : "logged-out";

                System.out.println(
                        "Type: " + type +
                                " | Username: " + u.getUsername() +
                                " | Registered: " + u.getRegistrationDate() +
                                " | State: " + logged
                );
            }
        }

        if (!hasAny) {
            System.out.println("(no users)");
        }
    }

    public DataBase getDataBase() {
        return dataBase;
    }
}
