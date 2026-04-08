package UserValidation;
import java.util.regex.Pattern;

public class Validator {
    public boolean isValidEmail(String email) {
        if (email == null) return false;
        return Pattern.compile(ValidationRules.EMAIL_PATTERN)
                      .matcher(email)
                      .matches();
    }
}