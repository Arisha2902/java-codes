package UserValidation;

public class RegistrationApp {
    public static void main(String[] args) {
        Validator val = new Validator();
        String testEmail = "test@example.com";
        
        if (val.isValidEmail(testEmail)) {
            System.out.println(testEmail + " is a valid user email.");
        } else {
            System.out.println("Invalid email format detected.");
        }
    }
}