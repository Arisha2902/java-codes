package TC_Inventory_System;

public class InventoryApp {
    public static void main(String[] args) {
        Warehouse w = new Warehouse();
        StockController controller = new StockController(w);
        w.store(new Item("SKU-100", 50));
        System.out.println("Item Available: " + controller.isAvailable("SKU-100"));
    }
}