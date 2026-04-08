// File 3: InheritanceAndPolymorphismTest.java - Tests inheritance and polymorphism edge cases
package folder2;

import folder1.*;
import java.util.ArrayList;
import java.util.List;

public class InheritanceAndPolymorphismTest {
    
    // Anonymous inner class to test polymorphism edge case
    private static class InvalidProduct extends Product {
        public InvalidProduct(String id, String name, double price, int stock) {
            super(id, name, price, stock);
        }
        
        // Override to always return false - tests polymorphic behavior
        @Override
        public boolean validate() {
            return false;
        }
        
        @Override
        public String getType() {
            return "INVALID_PRODUCT";
        }
    }
    
    public static void runTests() {
        System.out.println("=== Running Inheritance & Polymorphism Tests ===\n");
        
        // Test 1: Polymorphic list with mixed types
        List<BaseModel> models = new ArrayList<>();
        models.add(new User("U1", "Bob", "bob@test.com"));
        models.add(new Product("P1", "Item1", 10.0, 5));
        models.add(new Order("O1"));
        models.add(new InvalidProduct("IP1", "Bad Product", 0.0, 0));
        
        System.out.println("Polymorphic list test:");
        for (BaseModel model : models) {
            System.out.println("  Type: " + model.getType() + 
                             ", ID: " + model.getId() + 
                             ", Valid: " + model.validate());
        }
        
        // Test 2: Invalid product addition to order
        System.out.println("\nInvalid product test:");
        Order order = new Order("O1");
        InvalidProduct invalidProd = new InvalidProduct("IP1", "Bad", -5.0, -1);
        
        order.addItem(invalidProd, 3);
        System.out.println("  Items after adding invalid product: " + order.getItems().size());
        
        // Test 3: Valid product then override
        Product validProd = new Product("P1", "Good Product", 50.0, 10);
        order.addItem(validProd, 2);
        System.out.println("  Items after adding valid product: " + order.getItems().size());
        System.out.println("  Order total: $" + order.calculateTotal());
        
        // Test 4: Type checking and casting
        System.out.println("\nType checking test:");
        BaseModel model = new User("U2", "Alice", "alice@test.com");
        if (model instanceof User) {
            User user = (User) model;
            System.out.println("  Cast successful - User name: " + user.getName());
            System.out.println("  User orders: " + user.getOrders().size());
        }
        
        // Test 5: Category filtering with inheritance
        Product prod1 = new Product("P2", "Laptop", 999.99, 10);
        Product prod2 = new Product("P3", "Phone", 599.99, 15);
        prod1.addCategory("Electronics");
        prod2.addCategory("Electronics");
        prod2.addCategory("Mobile");
        
        List<Product> products = new ArrayList<>();
        products.add(prod1);
        products.add(prod2);
        
        List<Product> electronics = Product.filterByCategory(products, "Electronics");
        List<Product> mobile = Product.filterByCategory(products, "Mobile");
        
        System.out.println("\nCategory filtering test:");
        System.out.println("  Electronics: " + electronics.size());
        System.out.println("  Mobile: " + mobile.size());
        
        // Test 6: Stock edge cases
        System.out.println("\nStock edge cases:");
        Product zeroStock = new Product("P4", "Out of Stock", 100.0, 0);
        System.out.println("  Zero stock valid: " + zeroStock.validate());
        System.out.println("  Zero stock isInStock(0): " + zeroStock.isInStock(0));
        System.out.println("  Zero stock isInStock(1): " + zeroStock.isInStock(1));
        
        // Test 7: Order status transitions
        System.out.println("\nOrder status transitions:");
        Order newOrder = new Order("O2");
        System.out.println("  Initial status: " + newOrder.getStatus());
        newOrder.updateStatus("PROCESSING");
        System.out.println("  After update: " + newOrder.getStatus());
        newOrder.updateStatus("SHIPPED");
        System.out.println("  Second update: " + newOrder.getStatus());
        newOrder.updateStatus("");
        System.out.println("  Empty string update: '" + newOrder.getStatus() + "'");
        
        System.out.println("\n=== Inheritance & Polymorphism Tests Complete ===\n");
    }
    
    public static void main(String[] args) {
        runTests();
    }
}
