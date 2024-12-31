package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            try {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } catch (Exception e) {
                System.err.println("Failed to initialize WebDriver: " + e.getMessage());
                e.printStackTrace();
                throw new RuntimeException("WebDriver setup failed", e);
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                System.err.println("Failed to quit WebDriver: " + e.getMessage());
                e.printStackTrace();
            } finally {
                driver = null;
            }
        }
    }
}
