import java.util.regex.Pattern;

public class InputValidation {
    public static boolean isPasswordValid(String password) {
        if (password == null) {
            return false; // Password is non-existing
        }

        // Minimum 9 symbols
        if (password.length() < 9) {
            return false;
        }

        // Minimum 1 upper case letter
        if (!Pattern.compile("[A-Z]").matcher(password).find()) {
            return false;
        }

        // Minimum 1 lower case letter
        if (!Pattern.compile("[a-z]").matcher(password).find()) {
            return false;
        }

        // Minimum 1 number
        if (!Pattern.compile("\\d").matcher(password).find()) {
            return false;
        }

        // Minimum 1 special symbol
        if (!Pattern.compile("[^a-zA-Z0-9]").matcher(password).find()) {
            return false;
        }

        return true; // All cases are true
    }

    public static boolean isEmailValid(String email) {
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return Pattern.matches(emailRegex, email);
    }

    public static boolean isPhoneValid(String phone) {
        String phoneRegex = "^\\+?[0-9]+$";
        return Pattern.matches(phoneRegex, phone);
    }
}
