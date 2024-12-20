package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import pages.SignInPage;
import utils.Config;
import utils.DriverManager;

import java.io.*;
import java.util.Set;

public class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        driver.get(Config.BASE_URL);
    }

    @AfterEach
    public void tearDown() {
        DriverManager.quitDriver();
    }

    void loadCookies() {
        try (FileInputStream fileIn = new FileInputStream("cookies.pkl");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            Set<Cookie> cookies = (Set<Cookie>) in.readObject();
            for (Cookie cookie : cookies) {
                driver.manage().addCookie(cookie);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.navigate().refresh();
    }

    public void signInOrLoadCookies() {
        File cookiesFile = new File("cookies.pkl");
        if (cookiesFile.exists()) {
            loadCookies();
        } else {
            SignInPage signInPage = new SignInPage(driver);
            signInPage.signIn(Config.EMAIL, Config.PASSWORD);
            saveCookies();
        }
    }

    void saveCookies() {
        Set<Cookie> cookies = driver.manage().getCookies();
        try (FileOutputStream fileOut = new FileOutputStream("cookies.pkl");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(cookies);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}