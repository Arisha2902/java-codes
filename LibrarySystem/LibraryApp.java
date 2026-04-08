package LibrarySystem;
public class LibraryApp {
    public static void main(String[] args) {
        Library myLibrary = new Library();

        // Adding different types of items (Dependency Injection)
        myLibrary.addItem(new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald"));
        myLibrary.addItem(new DVD("D505", "Inception", 148));

        myLibrary.showInventory();
    }
}