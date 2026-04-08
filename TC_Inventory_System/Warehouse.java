package TC_Inventory_System;
import java.util.HashMap;

public class Warehouse {
    private HashMap<String, Item> stock = new HashMap<>();

    public void store(Item item) {
        stock.put(item.getId(), item);
    }

    public Item retrieve(String id) {
        return stock.get(id);
    }
}