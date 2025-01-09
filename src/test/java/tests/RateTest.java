package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.FindPage;
import pages.TitlePage;

import java.time.Duration;

public class RateTest extends BaseTest {

    @Test
    public void guestUserRateTest() {
        FindPage findPage = new FindPage(driver);
        TitlePage titlePage = new TitlePage(driver);

        findPage.FindTitle("Reservoir Dogs");

        titlePage.rateTitle();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until((driver) -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));

        implicitWait(2000);

        Assertions.assertTrue(driver.getCurrentUrl().contains("https://www.imdb.com/registration/signin"), "Guest user shouldn't be able to rate!");
    }

    @Test
    public void registeredUserRateTest() {
        signInOrLoadCookies();
        FindPage findPage = new FindPage(driver);
        TitlePage titlePage = new TitlePage(driver);

        findPage.FindTitle("Reservoir Dogs");

        implicitWait(2000);

        titlePage.rateTitle();

        implicitWait(2000);

        Assertions.assertTrue(titlePage.getTitleUserRating().contains("9\n" + "/10"), "Can't rate the title!");
    }

    @Test
    public void removeRatingTest() {
        signInOrLoadCookies();
        FindPage findPage = new FindPage(driver);
        TitlePage titlePage = new TitlePage(driver);

        findPage.FindTitle("Reservoir Dogs");

        implicitWait(2000);

        titlePage.removeTitleRating();

        implicitWait(2000);

        Assertions.assertThrows(NoSuchElementException.class, () -> {titlePage.getTitleUserRatingElement().isDisplayed();}, "Can't remove the rating!");
    }
}
