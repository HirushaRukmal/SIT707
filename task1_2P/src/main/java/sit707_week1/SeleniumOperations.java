package sit707_week1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Ahsan Habib
 */
public class SeleniumOperations {
    
    public static void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public static void open_chrome_and_close() {
        // WebDriverManager automatically downloads correct ChromeDriver version
        WebDriverManager.chromedriver().setup();
        
        System.out.println("Fire up chrome browser.");
        WebDriver driver = new ChromeDriver();
        
        System.out.println("Driver info: " + driver);
        sleep(5);
        driver.close();
    }
    
    public static void open_chrome_maximize_close() {
        WebDriverManager.chromedriver().setup();
        
        System.out.println("Fire up chrome browser.");
        WebDriver driver = new ChromeDriver();
        
        System.out.println("Driver info: " + driver);
        sleep(5);
        
        driver.manage().window().maximize();
        sleep(5);
        
        driver.close();
    }
    
    public static void load_web_page_close() {
        WebDriverManager.chromedriver().setup();
        
        System.out.println("Fire up chrome browser.");
        WebDriver driver = new ChromeDriver();
        
        System.out.println("Driver info: " + driver);
        sleep(5);
        
        driver.get("https://selenium.dev");
        sleep(5);
        
        driver.close();
    }
    
    public static void open_chrome_loadpage_resize_close() {
        // IMPORTANT: Replace with your actual student ID and name
        System.out.println("Hello from s224830206, Hirusha Rukmal"); // CHANGE THIS TO YOUR DETAILS
        
        // WebDriverManager handles ChromeDriver setup automatically
        WebDriverManager.chromedriver().setup();
        
        System.out.println("Fire up chrome browser.");
        WebDriver driver = new ChromeDriver();
        
        System.out.println("Driver info: " + driver);
        sleep(2);
        
        // Open Google
        System.out.println("Opening Google page...");
        driver.get("https://www.google.com");
        sleep(2);
        
        // Resize to 640x480
        System.out.println("Resizing window to 640x480");
        Dimension size640x480 = new Dimension(640, 480);
        driver.manage().window().setSize(size640x480);
        sleep(2);
        
        // Resize to 1280x960
        System.out.println("Resizing window to 1280x960");
        Dimension size1280x960 = new Dimension(1280, 960);
        driver.manage().window().setSize(size1280x960);
        sleep(2);
        
        System.out.println("Closing browser...");
        driver.close();
    }
}