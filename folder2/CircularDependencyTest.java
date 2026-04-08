// File 2: CircularDependencyTest.java - Tests circular references and complex dependencies
package folder2;

import folder1.*;
import java.util.Arrays;
import java.util.List;

public class CircularDependencyTest {
    
    public static void runTests() {
        System.out.println("=== Running Circular Dependency Tests ===\n");
        
        // Test 1: Create circular reference - User <-> Order
        User user = new User("U1", "Alice", "alice@test.com");
        Order order = new Order("O1");
        
        System.out.println("Before linking:");
        System.out.println("  User orders: " + user.getOrders().size());
        System.out.println("  Order user: " + (order.getUser() == null ? "null" : "set"));
        
        // This creates circular: User -> Order -> User
        user.addOrder(order);
        
        System.out.println("\nAfter linking:");
        System.out.println("  User orders: " + user.getOrders().size());
        System.out.println("  Order user: " + (order.getUser() == null ? "null" : order.getUser().getName()));
        System.out.println("  Order user's orders: " + order.getUser().getOrders().size());
        
        // Test 2: Multiple orders to same user
        Order order2 = new Order("O2");
        Order order3 = new Order("O3");
        user.addOrder(order2);
        user.addOrder(order3);
        
        System.out.println("\nMultiple orders test:");
        System.out.println("  User total orders: " + user.getOrders().size());
        System.out.println("  Order2 user: " + order2.getUser().getName());
        System.out.println("  Order3 user: " + order3.getUser().getName());
        
        // Test 3: Product sharing across orders
        Product prod1 = new Product("P1", "Laptop", 999.99, 10);
        Product prod2 = new Product("P2", "Mouse", 25.50, 50);
        
        order.addItem(prod1, 1);
        order.addItem(prod2, 2);
        order2.addItem(prod1, 1);
        order3.addItem(prod2, 5);
        
        System.out.println("\nShared products test:");
        System.out.println("  Order 1 total: $" + order.calculateTotal());
        System.out.println("  Order 2 total: $" + order2.calculateTotal());
        System.out.println("  Order 3 total: $" + order3.calculateTotal());
        System.out.println("  User total spending: $" + user.getTotalOrderValue());
        
        // Test 4: Stock reduction edge case
        System.out.println("\nStock management test:");
        System.out.println("  Laptop stock before: " + prod1.getStock());
        prod1.reduceStock(1);
        System.out.println("  Laptop stock after order: " + prod1.getStock());
        
        // Test 5: Category filtering with overlaps
        prod1.addCategory("Electronics");
        prod1.addCategory("Computers");
        prod2.addCategory("Electronics");
        prod2.addCategory("Accessories");
        
        List<Product> allProducts = Arrays.asList(prod1, prod2);
        List<Product> electronics = Product.filterByCategory(allProducts, "Electronics");
        
        System.out.println("\nCategory filter test:");
        System.out.println("  Electronics count: " + electronics.size());
        
        System.out.println("\n=== Circular Dependency Tests Complete ===\n");
    }
    
    public static void main(String[] args) {
        runTests();
    }
}
