// File 1: EdgeCaseNullTest.java - Tests null handling and edge cases
package folder2;

import folder1.*;

public class EdgeCaseNullTest {
    
    public static void runTests() {
        System.out.println("=== Running Null/Edge Case Tests ===\n");
        
        // Test 1: User with null email
        User user1 = new User("U1", "John", null);
        System.out.println("User with null email - valid: " + user1.validate());
        
        // Test 2: User with empty ID
        User user2 = new User("", "Jane", "jane@test.com");
        System.out.println("User with empty ID - valid: " + user2.validate());
        
        // Test 3: Product with negative price
        Product prod1 = new Product("P1", "Test Product", -10.0, 5);
        System.out.println("Product with negative price - valid: " + prod1.validate());
        
        // Test 4: Product with zero stock
        Product prod2 = new Product("P2", "Zero Stock Item", 25.0, 0);
        System.out.println("Product with zero stock - valid: " + prod2.validate());
        System.out.println("Product with zero stock - inStock(1): " + prod2.isInStock(1));
        
        // Test 5: Order without items
        Order order1 = new Order("O1");
        System.out.println("Empty order - valid: " + order1.validate());
        System.out.println("Empty order total: " + order1.calculateTotal());
        
        // Test 6: Adding null to order
        order1.addItem(null, 5);
        System.out.println("Added null product to order - items count: " + order1.getItems().size());
        
        // Test 7: Adding negative quantity
        order1.addItem(prod2, -3);
        System.out.println("Added negative quantity - items count: " + order1.getItems().size());
        
        // Test 8: Update status to null
        order1.updateStatus(null);
        System.out.println("Order status after null update: " + order1.getStatus());
        
        System.out.println("\n=== Null/Edge Case Tests Complete ===\n");
    }
    
    public static void main(String[] args) {
        runTests();
    }
}
