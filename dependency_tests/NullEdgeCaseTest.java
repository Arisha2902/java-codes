package dependency_tests;

import core_system.*;

public class NullEdgeCaseTest {

    public static void runTests() {
        System.out.println("=== Null/Edge Case Tests ===\n");

        Customer c1 = new Customer("C1", "Alice", null);
        System.out.println("Customer with null email - valid: " + c1.isValid());

        Customer c2 = new Customer("", "Bob", "bob@test.com");
        System.out.println("Customer with empty ID - valid: " + c2.isValid());

        Loan l1 = new Loan("L1", "Bad Loan", -500.0, 0.05);
        System.out.println("Loan with negative principal - valid: " + l1.isValid());

        Loan l2 = new Loan("L2", "Zero Interest", 1000.0, 0);
        System.out.println("Loan with zero interest - valid: " + l2.isValid());

        PaymentProcessor pp = new PaymentProcessor("PP1");

        boolean result1 = pp.processPayment(null, c2, 100.0);
        System.out.println("Payment with null loan: " + result1);

        boolean result2 = pp.processPayment(l2, null, 100.0);
        System.out.println("Payment with null customer: " + result2);

        boolean result3 = pp.processPayment(l2, c2, -50.0);
        System.out.println("Payment with negative amount: " + result3);

        l2.makePayment(0);
        System.out.println("Zero payment - balance: " + l2.getRemainingBalance());

        System.out.println("\n=== Tests Complete ===\n");
    }

    public static void main(String[] args) {
        runTests();
    }
}
