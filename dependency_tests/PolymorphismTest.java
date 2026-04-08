package dependency_tests;

import core_system.*;
import java.util.ArrayList;
import java.util.List;

public class PolymorphismTest {

    private static class InvalidLoan extends Loan {
        public InvalidLoan(String id, String name, double principal, double rate) {
            super(id, name, principal, rate);
        }

        @Override
        public boolean isValid() {
            return false;
        }

        @Override
        public String getEntityType() {
            return "INVALID_LOAN";
        }
    }

    public static void runTests() {
        System.out.println("=== Polymorphism Tests ===\n");

        List<BaseEntity> entities = new ArrayList<>();
        entities.add(new Customer("C1", "Alice", "alice@test.com"));
        entities.add(new Loan("L1", "Home Loan", 100000, 0.06));
        entities.add(new InvalidLoan("IL1", "Bad Loan", 5000, 0.1));

        System.out.println("Polymorphic list:");
        for (BaseEntity entity : entities) {
            System.out.println("  Type: " + entity.getEntityType() +
                             ", ID: " + entity.getId() +
                             ", Valid: " + entity.isValid());
        }

        System.out.println("\nType casting test:");
        BaseEntity base = new Customer("C2", "Bob", "bob@test.com");
        if (base instanceof Customer) {
            Customer cust = (Customer) base;
            System.out.println("  Cast successful - Name: " + cust.getName());
            System.out.println("  Email: " + cust.getEmail());
        }

        System.out.println("\nInvalid loan payment test:");
        Customer cust = new Customer("C3", "Charlie", "charlie@test.com");
        InvalidLoan invalid = new InvalidLoan("IL2", "Invalid", -100, 0.5);
        cust.addLoan(invalid);
        System.out.println("  Customer loans: " + cust.getLoans().size());
        System.out.println("  Total debt: $" + cust.getTotalDebt());

        PaymentProcessor pp = new PaymentProcessor("PP-Test");
        boolean result = pp.processPayment(invalid, cust, 500);
        System.out.println("  Payment to invalid loan: " + result);

        System.out.println("\n=== Tests Complete ===\n");
    }

    public static void main(String[] args) {
        runTests();
    }
}
