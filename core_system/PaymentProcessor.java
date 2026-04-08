package core_system;

import java.util.ArrayList;
import java.util.List;

public class PaymentProcessor {
    private String processorId;
    private List<String> transactionLog;

    public PaymentProcessor(String processorId) {
        this.processorId = processorId;
        this.transactionLog = new ArrayList<>();
    }

    public boolean processPayment(Loan loan, Customer customer, double amount) {
        if (loan == null || customer == null || amount <= 0) {
            logTransaction("FAILED: Invalid parameters");
            return false;
        }

        if (!loan.getCustomer().equals(customer)) {
            logTransaction("FAILED: Customer mismatch");
            return false;
        }

        loan.makePayment(amount);
        logTransaction("SUCCESS: $" + amount + " paid to loan " + loan.getName());

        if (loan.isPaidOff()) {
            logTransaction("INFO: Loan " + loan.getName() + " fully paid");
        }

        return true;
    }

    private void logTransaction(String message) {
        transactionLog.add("[" + processorId + "] " + message);
    }

    public List<String> getTransactionLog() {
        return new ArrayList<>(transactionLog);
    }

    public String getProcessorId() {
        return processorId;
    }
}
