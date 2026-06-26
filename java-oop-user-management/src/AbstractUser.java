import java.util.Date;

public abstract class AbstractUser implements User {
    private final String username;
    private final Date registrationDate;
    private boolean loggedIn;

    public AbstractUser(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty.");
        }
        this.username = username.trim();
        this.registrationDate = new Date();
        this.loggedIn = false;
    }

    @Override
    public void login() {
        loggedIn = true;
    }

    @Override
    public void logout() {
        loggedIn = false;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getRegistrationDate() {
        return registrationDate.toString();
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }
}
