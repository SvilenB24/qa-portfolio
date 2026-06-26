import java.util.ArrayList;
import java.util.List;

public class SimpleNotepad implements INotepad {

    protected List<Page> notepad;

    public SimpleNotepad() {
        notepad = new ArrayList<>();
    }

    protected Page findPage(int pageNumber) {
        for (Page p : notepad) {
            if (p.getPageNumber() == pageNumber) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void addNewPage(String title, String text) {
        int newPageNumber = notepad.size() + 1;
        Page p = new Page(newPageNumber, title);
        p.addText(text);
        notepad.add(p);
    }

    @Override
    public void replaceText(int pageNumber, String text) {
        Page p = findPage(pageNumber);
        if (p == null) {
            System.out.println("No page with number " + pageNumber);
            return;
        }
        p.setText(text);
    }

    @Override
    public void deleteText(int pageNumber) {
        Page p = findPage(pageNumber);
        if (p == null) {
            System.out.println("No page with number " + pageNumber);
            return;
        }
        p.deleteText();
    }

    @Override
    public void printAllPages() {
        if (notepad.isEmpty()) {
            System.out.println("(no pages)");
            return;
        }
        for (Page p : notepad) {
            System.out.println(p.viewPage());
            System.out.println("--------");
        }
    }
}
