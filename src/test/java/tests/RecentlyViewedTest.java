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

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.navigate().to("https://www.imdb.com");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        homePage.goToRecentlyViewedSection();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assertions.assertTrue(homePage.getRecentlyViewedSection().getText().contains("Breaking Bad"));
    }

    @Test
    void clearRecentlyViewedTest() {
        HomePage homePage = new HomePage(driver);
        FindPage findPage = new FindPage(driver);

        findPage.FindTitle("Abbas Kiarostami");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.navigate().to("https://www.imdb.com");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        homePage.goToRecentlyViewedSection();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getClearRecentlyViewed()));

        homePage.goToRecentlyViewedSection();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", homePage.getClearRecentlyViewed());

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assertions.assertThrows(NoSuchElementException.class, () -> {homePage.getRecentlyViewedSection().isDisplayed();});
    }
}
