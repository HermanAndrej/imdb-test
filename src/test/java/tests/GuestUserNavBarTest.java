package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.FindPage;
import pages.HomePage;

import java.time.Duration;

public class GuestUserNavBarTest extends BaseTest {

    @Test
    public void logoIconTestRef() {
        HomePage homePage = new HomePage(driver);

        homePage.getNavBarLogo().click();

        Assertions.assertEquals("https://www.imdb.com/?ref_=nv_home", driver.getCurrentUrl(), "Clicking on the logo icon doesn't redirect to the home page!");
    }

    @Test
    public void imdbProIconTestRef() {
        HomePage homePage = new HomePage(driver);
        String expectedUrl = "^https:\\/\\/pro\\.imdb\\.com\\/login.*";

        homePage.getNavBarIMDBProIcon().click();

        Assertions.assertTrue(driver.getCurrentUrl().matches(expectedUrl), "Clicking on the imdb pro icon doesn't redirect to pro sign in page!");
    }

    @Test
    public void watchlistIconTestRef() {
        HomePage homePage = new HomePage(driver);
        String expectedURL = "^https:\\/\\/www\\.imdb\\.com\\/registration\\/signin.*";

        homePage.getNavBarWatchlistButton().click();

        Assertions.assertTrue(driver.getCurrentUrl().matches(expectedURL), "Invalid");
    }

    @Test
    public void signInIconTestRef() {
        HomePage homePage = new HomePage(driver);
        String expectedURL = "^https:\\/\\/www\\.imdb\\.com\\/registration\\/signin.*";

        homePage.getNavBarSignInButton().click();

        Assertions.assertTrue(driver.getCurrentUrl().matches(expectedURL), "Invalid");
    }

    @Test
    public void menuShownTest() {
        HomePage homePage = new HomePage(driver);

        homePage.getNavBarMenu().click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement navBarMenu = wait.until(ExpectedConditions.visibilityOf(homePage.getNavBarMenuShown()));

        Assertions.assertTrue(navBarMenu.isDisplayed(), "Menu not shown!");
    }

    @Test
    public void languageMenuShownTest() {
        HomePage homePage = new HomePage(driver);

        homePage.getNavBarLanguageSelectorButton().click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement navBarLanguageMenu = wait.until(ExpectedConditions.visibilityOf(homePage.getNavBarLanguageMenu()));

        Assertions.assertTrue(navBarLanguageMenu.isDisplayed(), "Language menu not shown!");
    }

    @Test
    public void findPageToHomePageTest() {
        HomePage homePage = new HomePage(driver);
        FindPage findPage = new FindPage(driver);

        homePage.searchForText("parasite");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(findPage.getTitleSection()));

        homePage.getNavBarLogo().click();

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait2.until((driver) -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));

        Assertions.assertEquals("https://www.imdb.com/?ref_=nv_home", driver.getCurrentUrl(), "Navigation from find page to home page through imdb logo icon is not correct!");
    }
}
