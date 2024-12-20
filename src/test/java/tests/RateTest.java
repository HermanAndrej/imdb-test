package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.FindPage;
import pages.SignInPage;
import pages.TitlePage;

import java.io.File;
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

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assertions.assertTrue(driver.getCurrentUrl().contains("https://www.imdb.com/registration/signin"));
    }

    @Test
    public void registeredUserRateTest() {
        signInOrLoadCookies();
        FindPage findPage = new FindPage(driver);
        TitlePage titlePage = new TitlePage(driver);

        findPage.FindTitle("Reservoir Dogs");

        titlePage.rateTitle();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assertions.assertTrue(titlePage.getTitleUserRating().contains("9\n" + "/10"));
    }

    @Test
    public void removeRatingTest() {
        signInOrLoadCookies();
        FindPage findPage = new FindPage(driver);
        TitlePage titlePage = new TitlePage(driver);


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
