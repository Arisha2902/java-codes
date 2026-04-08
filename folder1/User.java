// File 2: User.java - Extends BaseModel, depends on BaseModel
package folder1;

import java.util.ArrayList;
import java.util.List;

public class User extends BaseModel {
    private String name;
    private String email;
    private List<Order> orders;
    
    public User(String id, String name, String email) {
        super(id);
        this.name = name;
        this.email = email;
        this.orders = new ArrayList<>();
    }
    
    @Override
    public String getType() {
        return "USER";
    }
    
    @Override
    public boolean validate() {
        return id != null && !id.isEmpty() && 
               email != null && email.contains("@");
    }
    
    public void addOrder(Order order) {
        if (order != null) {
            orders.add(order);
            order.assignToUser(this);
        }
    }
    
    public List<Order> getOrders() {
        return new ArrayList<>(orders);
    }
    
    public double getTotalOrderValue() {
        return orders.stream()
            .mapToDouble(Order::calculateTotal)
            .sum();
    }
    
    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
}
