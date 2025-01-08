package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

import java.time.Duration;

public class WatchlistTest extends BaseTest{

    @BeforeEach
    public void callSignInOrLoadCookies() {
        signInOrLoadCookies();
    }

    @Test
    public void addToWatchlistTest() {
        FindPage findPage = new FindPage(driver);
        TitlePage titlePage = new TitlePage(driver);
        WatchlistPage watchlistPage = new WatchlistPage(driver);

        findPage.FindTitle("Django Unchained");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until((driver) -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));

        implicitWait(2000);

        titlePage.addTitleToWatchList();

        implicitWait(2000);

        driver.navigate().to("https://www.imdb.com/list/watchlist");

        implicitWait(2000);

        Assertions.assertTrue(watchlistPage.getWatchlistTitleText().contains("Django Unchained"), "Couldn't add title to the watchlist!");
    }

    @Test
    public void removeFromWatchlistTest() {
        FindPage findPage = new FindPage(driver);
        TitlePage titlePage = new TitlePage(driver);
        WatchlistPage watchlistPage = new WatchlistPage(driver);

        findPage.FindTitle("Django Unchained");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until((driver) -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));

        implicitWait(2000);

        titlePage.addTitleToWatchList();

        implicitWait(2000);

        driver.navigate().to("https://www.imdb.com/list/watchlist");

        wait.until(ExpectedConditions.elementToBeClickable(watchlistPage.getWatchlistBody()));

        Assertions.assertTrue(watchlistPage.getWatchlistBodyText().contains("This list is empty."), "Couldn't remove title from a watchlist!");
    }

    @Test
    public void createNewListTest() {
        HomePage homePage = new HomePage(driver);
        WatchlistPage watchlistPage = new WatchlistPage(driver);

        homePage.getNavBarWatchlistButton().click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until((driver) -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));

        watchlistPage.createNewList("Japanese movies list", "List of my favorite Japanese movies!");

        wait.until((driver) -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));

        Assertions.assertTrue(driver.getCurrentUrl().contains("ref_=cr_lst_crte"), "New list not created!");
    }

}
