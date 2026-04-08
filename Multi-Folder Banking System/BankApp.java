import com.bank.models.SavingsAccount;
import com.bank.services.TransactionProcessor;

public class BankApp {
    public static void main(String[] args) {
        SavingsAccount mySavings = new SavingsAccount("SA-123", 1000.0, 0.05);

        mySavings.applyInterest();
        System.out.println("Balance after interest: " + mySavings.getBalance());

        TransactionProcessor.deposit(mySavings, 500.0);
    }
}
