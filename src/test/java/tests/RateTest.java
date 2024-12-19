package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.FindPage;
import pages.SignInPage;
import pages.TitlePage;

import java.time.Duration;

import utils.Config;

public class RateTest extends BaseTest {

    @Test
    public void guestUserRateTest() {
        FindPage findPage = new FindPage(driver);
        TitlePage titlePage = new TitlePage(driver);

        findPage.FindTitle("Reservoir Dogs");

        titlePage.rateTitle();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until((driver) -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));

        Assertions.assertTrue(driver.getCurrentUrl().contains("https://www.imdb.com/registration/signin"));
    }

    @Test
    public void registeredUserRateTest() {
        SignInPage signInPage = new SignInPage(driver);
        FindPage findPage = new FindPage(driver);
        TitlePage titlePage = new TitlePage(driver);

        signInPage.signIn(Config.EMAIL, Config.PASSWORD);

        findPage.FindTitle("Reservoir Dogs");

        titlePage.rateTitle();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(titlePage.getTitleRating());
        Assertions.assertTrue(titlePage.getTitleUserRating().contains("9/10"));
    }

    @Test
    public void removeRatingTest() {
        SignInPage signInPage = new SignInPage(driver);
        FindPage findPage = new FindPage(driver);
        TitlePage titlePage = new TitlePage(driver);

        signInPage.signIn(Config.EMAIL, Config.PASSWORD);

        findPage.FindTitle("Reservoir Dogs");

        titlePage.removeTitleRating();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assertions.assertThrows(NoSuchElementException.class, () -> {titlePage.getTitleUserRatingElement().isDisplayed();});
    }
}
