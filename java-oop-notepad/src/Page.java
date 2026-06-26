public class Page {
    private String title;
    private String text;
    private int pageNumber;

    public Page(int pageNumber, String title) {
        this.pageNumber = pageNumber;
        this.title = (title == null) ? "" : title.trim();
        this.text = "";
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void addText(String newText) {
        if (newText == null) {
            return;
        }
        text += newText;
    }

    public void deleteText() {
        text = "";
    }

    public void setText(String newText) {
        text = (newText == null) ? "" : newText;
    }

    public String viewPage() {
        return "Page " + pageNumber + ": " + title + "\n" + text;
    }
}
