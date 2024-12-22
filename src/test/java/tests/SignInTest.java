package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.SignInPage;
import utils.Config;

import java.time.Duration;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SignInTest extends BaseTest {

    @Order(1)
    @Test
    public void signInTestSuccess() {
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn(Config.EMAIL, Config.PASSWORD);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until((driver) -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));

        Assertions.assertEquals("https://www.imdb.com/?ref_=login", driver.getCurrentUrl(), "Login was unsuccessful!");

        saveCookies();
    }

    @Order(3)
    @Test
    public void signInTestFailure() {
        SignInPage signInPage = new SignInPage(driver);

        signInPage.signIn("wrongemail@gmail.com", "wrong password");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until((driver) -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));

        Assertions.assertNotEquals("https://www.imdb.com/?ref_=login", driver.getCurrentUrl(), "Login was successful!");
    }

    @Order(2)
    @Test
    public void signInEmptyFieldsTestFailure() {
        SignInPage signInPage = new SignInPage(driver);

        signInPage.signIn("", "");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until((driver) -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));

        Assertions.assertNotEquals("https://www.imdb.com/?ref_=login", driver.getCurrentUrl(), "Login was successful!");

        Assertions.assertTrue(signInPage.getAuthErrorMsgBox().isDisplayed(), "Authentication error message not shown!");
    }
}
