import java.util.Scanner;

public class SecuredNotepad extends SimpleNotepad {

    private String password;
    private Scanner scanner;

    public SecuredNotepad(String password) {
        super();
        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be empty.");
        }
        this.password = password;
        this.scanner = new Scanner(System.in);
    }

    private boolean checkPassword() {
        System.out.print("Enter password: ");
        String inputPassword = scanner.nextLine();
        return password.equals(inputPassword);
    }

    @Override
    public void addNewPage(String title, String text) {
        if (!checkPassword()) {
            System.out.println("Wrong password. Operation denied.");
            return;
        }
        super.addNewPage(title, text);
    }

    @Override
    public void replaceText(int pageNumber, String text) {
        if (!checkPassword()) {
            System.out.println("Wrong password. Operation denied.");
            return;
        }
        super.replaceText(pageNumber, text);
    }

    @Override
    public void deleteText(int pageNumber) {
        if (!checkPassword()) {
            System.out.println("Wrong password. Operation denied.");
            return;
        }
        super.deleteText(pageNumber);
    }

    @Override
    public void printAllPages() {
        if (!checkPassword()) {
            System.out.println("Wrong password. Operation denied.");
            return;
        }
        super.printAllPages();
    }
}
