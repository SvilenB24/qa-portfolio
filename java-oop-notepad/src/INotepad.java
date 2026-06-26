public interface INotepad {
    void addNewPage(String title, String text);
    void replaceText(int pageNumber, String text);
    void deleteText(int pageNumber);
    void printAllPages();
}
