
package TC_Inventory_System;

public class StockController {
    private Warehouse warehouse;

    public StockController(Warehouse w) { this.warehouse = w; }

    public boolean isAvailable(String id) {
        Item item = warehouse.retrieve(id);
        return item != null && item.getQuantity() > 0;
    }
}