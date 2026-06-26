public class Demo {
    public static void main(String[] args) {

        System.out.println("=== SIMPLE NOTEPAD ===");

        Page firstPage = new Page(1, "FirstPage");

        firstPage.setText("Initial text might be ");
        firstPage.addText("something");
        System.out.println(firstPage.viewPage());
        firstPage.deleteText();

        INotepad firstNotepad = new SimpleNotepad();

        firstNotepad.addNewPage("Title1", "First page in the list");
        firstNotepad.addNewPage("Title2", "Second page in the list");
        firstNotepad.replaceText(1, "The text have been changed");
        firstNotepad.deleteText(2);
        firstNotepad.printAllPages();

        System.out.println("\n=== SECURED NOTEPAD ===");
        // SecuredNotepad prompts for the password on every operation (interactive).
        INotepad securedNotepad = new SecuredNotepad("1234");

        securedNotepad.addNewPage("Secrets", "My password is not for sharing");
        securedNotepad.addNewPage("Notes", "This is a secured note");
        securedNotepad.replaceText(1, "Updated secret text");
        securedNotepad.printAllPages();
    }
}
