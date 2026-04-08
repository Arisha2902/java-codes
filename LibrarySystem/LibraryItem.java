package LibrarySystem;
public abstract class LibraryItem {
    protected String id;
    protected String title;

    public LibraryItem(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public abstract void displayDetails();
}