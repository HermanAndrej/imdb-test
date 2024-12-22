package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.FindPage;
import pages.HomePage;

import java.time.Duration;

public class RecentlyViewedTest extends BaseTest {

    @Test
    void recentlyViewedTest() {
        HomePage homePage = new HomePage(driver);
        FindPage findPage = new FindPage(driver);

        findPage.FindTitle("Breaking Bad");

        implicitWait(2000);

        driver.navigate().to("https://www.imdb.com");

        implicitWait(2000);

        homePage.goToRecentlyViewedSection();

        implicitWait(2000);

        Assertions.assertTrue(homePage.getRecentlyViewedSection().getText().contains("Breaking Bad"));
    }

    @Test
    void clearRecentlyViewedTest() {
        HomePage homePage = new HomePage(driver);
        FindPage findPage = new FindPage(driver);

        findPage.FindTitle("Abbas Kiarostami");

        implicitWait(2000);

        driver.navigate().to("https://www.imdb.com");

        implicitWait(2000);

        homePage.goToRecentlyViewedSection();

        implicitWait(2000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getClearRecentlyViewed()));

        homePage.goToRecentlyViewedSection();

        implicitWait(2000);

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", homePage.getClearRecentlyViewed());

        implicitWait(2000);

        Assertions.assertThrows(NoSuchElementException.class, () -> {homePage.getRecentlyViewedSection().isDisplayed();});
    }
}
