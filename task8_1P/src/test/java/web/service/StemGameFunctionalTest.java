package web.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StemGameFunctionalTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private final String BASE_URL = "http://127.0.0.1:8082";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "/Users/hirusharukmal/Downloads/chromedriver-mac-arm642/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 10);
    }

    private void loginAsValidUser() {
        driver.get(BASE_URL + "/login");

        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("ahsan");

        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys("ahsan_pass");

        WebElement dobField = driver.findElement(By.id("dob"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='2000-01-15';", dobField);

        driver.findElement(By.cssSelector("input[type='submit']")).click();

        wait.until(ExpectedConditions.urlContains("/q1"));
    }

    @Test
    public void testLoginSuccessRedirectsToQ1() {
        loginAsValidUser();
        Assert.assertTrue(driver.getCurrentUrl().contains("/q1"));
    }

    @Test
    public void testQ1CorrectAnswerRedirectsToQ2() {
        loginAsValidUser();

        driver.findElement(By.id("number1")).sendKeys("2");
        driver.findElement(By.id("number2")).sendKeys("3");
        driver.findElement(By.id("result")).sendKeys("5");
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        wait.until(ExpectedConditions.urlContains("/q2"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/q2"));
    }

    @Test
    public void testQ2CorrectAnswerRedirectsToQ3() {
        loginAsValidUser();

        driver.findElement(By.id("number1")).sendKeys("2");
        driver.findElement(By.id("number2")).sendKeys("3");
        driver.findElement(By.id("result")).sendKeys("5");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        wait.until(ExpectedConditions.urlContains("/q2"));

        driver.findElement(By.id("number1")).sendKeys("9");
        driver.findElement(By.id("number2")).sendKeys("4");
        driver.findElement(By.id("result")).sendKeys("5");
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        wait.until(ExpectedConditions.urlContains("/q3"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/q3"));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}