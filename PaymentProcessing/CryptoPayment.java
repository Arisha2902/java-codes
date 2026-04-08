package PaymentProcessing;

public class CryptoPayment implements PaymentStrategy {
    private String walletAddress;

    public CryptoPayment(String wallet) { this.walletAddress = wallet; }

    @Override
    public void pay(double amount) {
        System.out.println("Transferred $" + amount + " to Wallet: " + walletAddress);
    }
}