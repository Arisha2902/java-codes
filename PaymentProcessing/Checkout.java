package PaymentProcessing;

public class Checkout {
    public static void main(String[] args) {
        PaymentStrategy strategy = new CryptoPayment("0x123ABC");
        // This is a "Dependency Injection" test
        processTransaction(strategy, 250.00);
    }

    public static void processTransaction(PaymentStrategy method, double total) {
        method.pay(total);
    }
}