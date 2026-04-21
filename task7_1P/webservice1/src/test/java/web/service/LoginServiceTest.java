package web.service;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginServiceTest {

    private static final String LOGIN_HTML_FILE =
            "file:///Users/hirusharukmal/Documents/Deakin/SIT707/SIT707/task7_1P/pages/login.html";
    

    private void sleep(long sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private WebDriver openLoginPage() {
        System.setProperty("webdriver.chrome.driver",
                "/Users/hirusharukmal/Downloads/chromedriver-mac-arm64/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.navigate().to(LOGIN_HTML_FILE);
        sleep(2);
        return driver;
    }

    private void submitLogin(WebDriver driver, String username, String password, String dob) {
        WebElement ele = driver.findElement(By.id("username"));
        ele.clear();
        ele.sendKeys(username);

        ele = driver.findElement(By.id("passwd"));
        ele.clear();
        ele.sendKeys(password);

        ele = driver.findElement(By.id("dob"));
        ele.clear();
        ele.sendKeys(dob);

        ele = driver.findElement(By.cssSelector("[type=submit]"));
        ele.submit();

        sleep(2);
    }

    @Test
    public void testLoginSuccess() {
        WebDriver driver = openLoginPage();

        submitLogin(driver, "ahsan", "ahsan pass", "2000-01-15");

        String title = driver.getTitle();
        Assert.assertEquals("success", title);

        driver.close();
    }

    @Test
    public void testLoginFail_WrongPassword() {
        WebDriver driver = openLoginPage();

        submitLogin(driver, "ahsan", "wrongpass", "2000-01-15");

        String title = driver.getTitle();
        Assert.assertEquals("fail", title);

        driver.close();
    }

    @Test
    public void testLoginFail_WrongDob() {
        WebDriver driver = openLoginPage();

        submitLogin(driver, "ahsan", "ahsan pass", "2001-01-15");

        String title = driver.getTitle();
        Assert.assertEquals("fail", title);

        driver.close();
    }

    @Test
    public void testLoginFail_EmptyUsername() {
        WebDriver driver = openLoginPage();

        submitLogin(driver, "", "ahsan pass", "2000-01-15");

        String title = driver.getTitle();
        Assert.assertEquals("fail", title);

        driver.close();
    }

    @Test
    public void testLoginFail_EmptyPassword() {
        WebDriver driver = openLoginPage();

        submitLogin(driver, "ahsan", "", "2000-01-15");

        String title = driver.getTitle();
        Assert.assertEquals("fail", title);

        driver.close();
    }

    @Test
    public void testLoginFail_InvalidDobFormat() {
        WebDriver driver = openLoginPage();

        submitLogin(driver, "ahsan", "ahsan pass", "15-01-2000");

        String title = driver.getTitle();
        Assert.assertEquals("fail", title);

        driver.close();
    }
}