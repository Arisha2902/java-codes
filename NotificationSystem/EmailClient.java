package NotificationSystem;

public class EmailClient implements Observer {
    private String email;

    public EmailClient(String email) { this.email = email; }

    @Override
    public void update(String message) {
        System.out.println("Email sent to " + email + ": " + message);
    }
}