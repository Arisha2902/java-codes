package core_system;

import java.util.ArrayList;
import java.util.List;

public class Customer extends BaseEntity {
    private String email;
    private List<Loan> loans;

    public Customer(String id, String name, String email) {
        super(id, name);
        this.email = email;
        this.loans = new ArrayList<>();
    }

    @Override
    public String getEntityType() {
        return "CUSTOMER";
    }

    @Override
    public boolean isValid() {
        return id != null && email != null && email.contains("@");
    }

    public void addLoan(Loan loan) {
        if (loan != null) {
            loans.add(loan);
            loan.setCustomer(this);
        }
    }

    public List<Loan> getLoans() {
        return new ArrayList<>(loans);
    }

    public double getTotalDebt() {
        return loans.stream()
            .mapToDouble(Loan::getRemainingBalance)
            .sum();
    }

    public String getEmail() {
        return email;
    }
}
