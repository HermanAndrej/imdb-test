package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.SignInPage;
import utils.Config;

import java.time.Duration;

public class SignInTest extends BaseTest {

    @Test
    public void signInTestSuccess() {
        SignInPage signInPage = new SignInPage(driver);

        signInPage.signIn(Config.EMAIL, Config.PASSWORD);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until((driver) -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));

        Assertions.assertEquals("https://www.imdb.com/?ref_=login", driver.getCurrentUrl(), "Login was unsuccessful!");
    }

    @Test
    public void signInTestFailure() {
        SignInPage signInPage = new SignInPage(driver);

        signInPage.signIn("wrongemail@gmail.com", "wrong password");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until((driver) -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));

        Assertions.assertNotEquals("https://www.imdb.com/?ref_=login", driver.getCurrentUrl(), "Login was successful!");

        // WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        // wait2.until(ExpectedConditions.visibilityOf(signInPage.getAuthErrorMsgBox()));

        Assertions.assertTrue(signInPage.getAuthErrorMsgBox().isDisplayed(), "Authentication error message not shown!");
    }
}
