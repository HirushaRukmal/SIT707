package web.service;

/**
 * Business logic to handle login functions.
 */
public class LoginService {

    public static boolean login(String username, String password, String dob) {
        if (username == null || password == null || dob == null) {
            return false;
        }

        if (username.trim().isEmpty() || password.trim().isEmpty() || dob.trim().isEmpty()) {
            return false;
        }

        return "ahsan".equals(username)
                && "ahsan_pass".equals(password)
                && "2000-01-15".equals(dob);
    }
}