package sit707_week2;

public class LoginForm {
    private static final String VALID_USERNAME = "hiruau@gmail.com";
    private static final String VALID_PASSWORD = "hiru@123";

    public boolean authenticate(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        if (username.trim().isEmpty() || password.trim().isEmpty()) {
            return false;
        }

        return VALID_USERNAME.equals(username) && VALID_PASSWORD.equals(password);
    }
}