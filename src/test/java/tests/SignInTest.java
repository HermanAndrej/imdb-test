package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.SignInPage;
import utils.Config;
import org.openqa.selenium.Cookie;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Set;
import java.time.Duration;

public class SignInTest extends BaseTest {

    @Test
    public void signInTestSuccess() {
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn(Config.EMAIL, Config.PASSWORD);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until((driver) -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));

        Assertions.assertEquals("https://www.imdb.com/?ref_=login", driver.getCurrentUrl(), "Login was unsuccessful!");

        saveCookies();
    }

    @Test
    public void signInTestFailure() {
        SignInPage signInPage = new SignInPage(driver);

        signInPage.signIn("wrongemail@gmail.com", "wrong password");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until((driver) -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));

        Assertions.assertNotEquals("https://www.imdb.com/?ref_=login", driver.getCurrentUrl(), "Login was successful!");
    }

    @Test
    public void signInEmptyFieldsTestFailure() {
        SignInPage signInPage = new SignInPage(driver);

        signInPage.signIn("", "");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until((driver) -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));

        Assertions.assertNotEquals("https://www.imdb.com/?ref_=login", driver.getCurrentUrl(), "Login was successful!");

        // WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        // wait2.until(ExpectedConditions.visibilityOf(signInPage.getAuthErrorMsgBox()));

        Assertions.assertTrue(signInPage.getAuthErrorMsgBox().isDisplayed(), "Authentication error message not shown!");
    }

    @Test
    public void showPasswordTest() {
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = new SignInPage(driver);

        homePage.getNavBarSignInButton().click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until((driver) -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));


        signInPage.getSignInWithImdb().click();

        signInPage.getPasswordField().sendKeys("goldenwind");
        signInPage.getShowPasswordBox().click();

        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement visiblePasswordContainer = wait3.until(ExpectedConditions.visibilityOf(signInPage.getVisiblePasswordContainer()));

        Assertions.assertTrue(signInPage.getVisiblePasswordContainer().getText().contains("goldenwind"), "Doesn't work!");
    }
}
