package sit707_week2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Main test class for unit tests and Selenium functional tests.
 */
public class MainTest {

    private LoginForm loginForm;

    public MainTest() {
        System.out.println("MainTest");
    }

    private void sleep(long sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Before
    public void setUp() {
        loginForm = new LoginForm();
    }

    @Test
    public void testStudentIdentity() {
        String studentId = "s224830206";
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "hirusharu";
        Assert.assertNotNull("Student name is null", studentName);
    }

    /*
     * -----------------------------
     * UNIT TESTS FOR LoginForm
     * -----------------------------
     */

    @Test
    public void testValidLogin() {
        Assert.assertTrue(loginForm.authenticate("hiruau@gmail.com", "hiru@123"));
    }

    @Test
    public void testInvalidUsername() {
        Assert.assertFalse(loginForm.authenticate("wrongemail@gmail.com", "hiru@123"));
    }

    @Test
    public void testInvalidPassword() {
        Assert.assertFalse(loginForm.authenticate("hiruau@gmail.com", "wrongPassword"));
    }

    @Test
    public void testInvalidUsernameAndPassword() {
        Assert.assertFalse(loginForm.authenticate("wrongemail@gmail.com", "wrongPassword"));
    }

    @Test
    public void testEmptyUsername() {
        Assert.assertFalse(loginForm.authenticate("", "hiru@123"));
    }

    @Test
    public void testEmptyPassword() {
        Assert.assertFalse(loginForm.authenticate("hiruau@gmail.com", ""));
    }

    @Test
    public void testEmptyUsernameAndPassword() {
        Assert.assertFalse(loginForm.authenticate("", ""));
    }

    @Test
    public void testNullUsername() {
        Assert.assertFalse(loginForm.authenticate(null, "hiru@123"));
    }

    @Test
    public void testNullPassword() {
        Assert.assertFalse(loginForm.authenticate("hiruau@gmail.com", null));
    }

    @Test
    public void testNullUsernameAndPassword() {
        Assert.assertFalse(loginForm.authenticate(null, null));
    }

    @Test
    public void testBlankUsername() {
        Assert.assertFalse(loginForm.authenticate("   ", "hiru@123"));
    }

    @Test
    public void testBlankPassword() {
        Assert.assertFalse(loginForm.authenticate("hiruau@gmail.com", "   "));
    }

    @Test
    public void testBlankUsernameAndPassword() {
        Assert.assertFalse(loginForm.authenticate("   ", "   "));
    }

    @Test
    public void testUsernameDifferentCase() {
        Assert.assertFalse(loginForm.authenticate("HIRUAU@GMAIL.COM", "hiru@123"));
    }

    @Test
    public void testPasswordDifferentCase() {
        Assert.assertFalse(loginForm.authenticate("hiruau@gmail.com", "HIRU@123"));
    }

    @Test
    public void testUsernameWithLeadingTrailingSpaces() {
        Assert.assertFalse(loginForm.authenticate(" hiruau@gmail.com ", "hiru@123"));
    }

    @Test
    public void testPasswordWithLeadingTrailingSpaces() {
        Assert.assertFalse(loginForm.authenticate("hiruau@gmail.com", " hiru@123 "));
    }

    @Test
    public void testVeryLongUsername() {
        String longUsername = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@gmail.com";
        Assert.assertFalse(loginForm.authenticate(longUsername, "hiru@123"));
    }

    @Test
    public void testVeryLongPassword() {
        String longPassword = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        Assert.assertFalse(loginForm.authenticate("hiruau@gmail.com", longPassword));
    }

    /*
     * -----------------------------
     * SELENIUM HELPER FOR BUNNINGS
     * -----------------------------
     * This method is optional unless you are adding Selenium tests.
     */

    private WebDriver openBunningsLoginPage() {
        System.setProperty(
                "webdriver.chrome.driver",
                "/Users/hirusharukmal/Downloads/chromedriver-mac-arm642/chromedriver"
        );

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");

        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("https://www.bunnings.com.au/login");
        sleep(4);
        return driver;
    }
}