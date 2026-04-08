import java.util.ArrayList;
import java.util.List;

public class Order {
    private Customer customer;
    private List<Product> items = new ArrayList<>();

    public Order(Customer customer) {
        this.customer = customer;
    }

    public void addProduct(Product product) {
        items.add(product);
    }

    public void printInvoice() {
        double total = 0;
        System.out.println("Invoice for: " + customer.getUsername());
        for (Product p : items) {
            System.out.println("- " + p.getName() + ": $" + p.getPrice());
            total += p.getPrice();
        }
        System.out.println("Total: $" + total);
    }
}