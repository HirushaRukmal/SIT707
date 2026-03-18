package sit707_week2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumOperations {

    public static final String CHROMEDRIVER_PATH =
            "/Users/hirusharukmal/Downloads/chromedriver-mac-arm64/chromedriver";

    public static void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void takeScreenshot(WebDriver driver, String fileName) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(srcFile.toPath(), new File(fileName).toPath(),
                    StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Screenshot saved to: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void officeworks_registration_page(String url) {
        System.out.println("Open Officeworks registration page.");

        System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_PATH);
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            driver.get(url);
            sleep(3);

            driver.findElement(By.id("firstname")).sendKeys("Hirusha");
            driver.findElement(By.id("lastname")).sendKeys("Rukmal");
            driver.findElement(By.id("phoneNumber")).sendKeys("0412345678");
            driver.findElement(By.id("email")).sendKeys("hirusha.test123@example.com");
            driver.findElement(By.id("password")).sendKeys("12345");
            driver.findElement(By.id("confirmPassword")).sendKeys("12345");

            sleep(2);

            driver.findElement(By.xpath("//button[contains(.,'Create account')]")).click();

            sleep(3);

            takeScreenshot(driver,
                    "/Users/hirusharukmal/Documents/Deakin/SIT707/task2_1P/officeworks_registration_result.png");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sleep(2);
            driver.quit();
        }
    }

    public static void alternative_registration_page(String url) {
        System.out.println("Open alternative registration page.");

        System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_PATH);
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            driver.get(url);
            sleep(2);

            driver.findElement(By.xpath("//input[@type='radio' and @value='m']")).click();

            driver.findElement(By.id("fname")).clear();
            driver.findElement(By.id("fname")).sendKeys("Hirusha");

            driver.findElement(By.id("lname")).clear();
            driver.findElement(By.id("lname")).sendKeys("Rukmal");

            driver.findElement(By.name("newsletter")).click();

            sleep(2);

            takeScreenshot(driver,
                    "/Users/hirusharukmal/Documents/Deakin/SIT707/task2_1P/alternative_registration_filled.png");

            driver.findElement(By.xpath("//input[@type='submit']")).click();

            sleep(2);

            takeScreenshot(driver,
                    "/Users/hirusharukmal/Documents/Deakin/SIT707/task2_1P/alternative_registration_result.png");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sleep(2);
            driver.quit();
        }
    }
}