
public class Main {
    public static void main(String[] args) {
        // 1. Create dependencies
        Customer user = new Customer("JavaDev_99");
        Product laptop = new Product("MacBook", 1299.99);
        Product mouse = new Product("Magic Mouse", 79.00);

        // 2. Inject dependencies into the Order
        Order myOrder = new Order(user);
        myOrder.addProduct(laptop);
        myOrder.addProduct(mouse);

        // 3. Execute logic
        myOrder.printInvoice();
    }
}