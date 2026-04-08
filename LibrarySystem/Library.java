
package LibrarySystem;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<LibraryItem> inventory = new ArrayList<>();

    public void addItem(LibraryItem item) {
        inventory.add(item);
    }

    public void showInventory() {
        System.out.println("--- Current Library Inventory ---");
        for (LibraryItem item : inventory) {
            item.displayDetails(); // Polymorphic call
        }
    }
}