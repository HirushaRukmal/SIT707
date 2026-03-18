package sit707_week2;

/**
 * Main program entry point.
 */
public class Main {
    public static void main(String[] args) {
        SeleniumOperations.officeworks_registration_page(
                "https://www.officeworks.com.au/app/identity/create-account"
        );

        String alternativeUrl = Main.class
                .getResource("/sit707_week2/webpage1.html")
                .toExternalForm();

        SeleniumOperations.alternative_registration_page(alternativeUrl);
    }
}
