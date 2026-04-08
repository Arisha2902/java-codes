package dependency_tests;

import core_system.*;
import java.util.List;

public class CircularDependencyTest {

    public static void runTests() {
        System.out.println("=== Circular Dependency Tests ===\n");

        Customer customer = new Customer("C1", "Alice", "alice@test.com");
        Loan loan1 = new Loan("L1", "Home Loan", 200000, 0.07);
        Loan loan2 = new Loan("L2", "Car Loan", 25000, 0.05);

        System.out.println("Before linking:");
        System.out.println("  Customer loans: " + customer.getLoans().size());
        System.out.println("  Loan1 customer: " + (loan1.getCustomer() == null ? "null" : "set"));

        customer.addLoan(loan1);
        customer.addLoan(loan2);

        System.out.println("\nAfter linking:");
        System.out.println("  Customer loans: " + customer.getLoans().size());
        System.out.println("  Loan1 customer: " + loan1.getCustomer().getName());
        System.out.println("  Loan2 customer: " + loan2.getCustomer().getName());

        System.out.println("\nCircular reference check:");
        System.out.println("  Customer -> Loan1 -> Customer: " +
            loan1.getCustomer().getLoans().contains(loan1));

        loan1.makePayment(5000);
        loan2.makePayment(1000);

        System.out.println("\nPayment tests:");
        System.out.println("  Loan1 remaining: $" + loan1.getRemainingBalance());
        System.out.println("  Loan2 remaining: $" + loan2.getRemainingBalance());
        System.out.println("  Customer total debt: $" + customer.getTotalDebt());

        PaymentProcessor pp = new PaymentProcessor("PP-Main");
        pp.processPayment(loan1, customer, 10000);
        pp.processPayment(loan2, customer, 5000);

        System.out.println("\nProcessor logs:");
        for (String log : pp.getTransactionLog()) {
            System.out.println("  " + log);
        }

        System.out.println("\nLoan1 paid off: " + loan1.isPaidOff());
        System.out.println("Loan2 paid off: " + loan2.isPaidOff());

        System.out.println("\n=== Tests Complete ===\n");
    }

    public static void main(String[] args) {
        runTests();
    }
}
