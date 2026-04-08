package TC_Inventory_System;

public class Item {
    private String id;
    private int quantity;

    public Item(String id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public String getId() { return id; }
    public int getQuantity() { return quantity; }
}