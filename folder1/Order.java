// File 3: Order.java - Depends on User and Product
package folder1;

import java.util.HashMap;
import java.util.Map;

public class Order extends BaseModel {
    private User user;
    private Map<Product, Integer> items;
    private String status;
    
    public Order(String id) {
        super(id);
        this.items = new HashMap<>();
        this.status = "PENDING";
    }
    
    @Override
    public String getType() {
        return "ORDER";
    }
    
    @Override
    public boolean validate() {
        return id != null && !id.isEmpty() && 
               user != null && !items.isEmpty();
    }
    
    public void assignToUser(User user) {
        this.user = user;
    }
    
    public void addItem(Product product, int quantity) {
        if (product != null && product.validate() && quantity > 0) {
            items.put(product, quantity);
        }
    }
    
    public double calculateTotal() {
        double total = 0;
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }
    
    public void updateStatus(String newStatus) {
        if (newStatus != null) {
            this.status = newStatus;
        }
    }
    
    public User getUser() {
        return user;
    }
    
    public Map<Product, Integer> getItems() {
        return new HashMap<>(items);
    }
    
    public String getStatus() {
        return status;
    }
}
