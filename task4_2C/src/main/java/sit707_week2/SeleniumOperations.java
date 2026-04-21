package sit707_week2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumOperations {

    public static void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void loginToBunnings(String username, String password) {
        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "/Users/hirusharukmal/Downloads/chromedriver-mac-arm642/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to login page
            driver.get("https://www.bunnings.com.au/login");

            // Find username field and enter username
            WebElement usernameField = driver.findElement(By.id("okta-signin-username"));
            usernameField.sendKeys(username);

            // Find password field and enter password
            WebElement passwordField = driver.findElement(By.id("okta-signin-password"));
            passwordField.sendKeys(password);

            // Click on Sign In button
            WebElement signInButton = driver.findElement(By.id("okta-signin-submit"));
            signInButton.click();

            // Wait for page to load
            sleep(5); // Increase the sleep time if needed for the page to load completely

            // Print success message
            System.out.println("Login successful.");
        } catch (Exception e) {
            System.out.println("Login failed: " + e.getMessage());
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
