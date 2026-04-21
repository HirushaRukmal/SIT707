package web.service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class LoginService {

	private static final String VALID_USERNAME = "ahsan";
    private static final String VALID_PASSWORD = "ahsan pass";
    private static final String VALID_DOB = "2000-01-15";

    public static boolean login(String username, String password, String dob) {
        if (username == null || password == null || dob == null) {
            return false;
        }

        username = username.trim();
        password = password.trim();
        dob = dob.trim();

        if (username.isEmpty() || password.isEmpty() || dob.isEmpty()) {
            return false;
        }

        if (!isValidDobFormat(dob)) {
            return false;
        }

        return VALID_USERNAME.equals(username)
                && VALID_PASSWORD.equals(password)
                && VALID_DOB.equals(dob);
    }

    public static boolean isValidDobFormat(String dob) {
        try {
            LocalDate.parse(dob);
            return true;
        } catch (DateTimeParseException ex) {
            return false;
        }
    }
}