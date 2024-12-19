package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import utils.Config;

import java.time.Duration;

public class WatchlistTest extends BaseTest{

    @BeforeEach
    public void loginUser() {
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn(Config.EMAIL, Config.PASSWORD);
    }

    // https://www.imdb.com/user/ur193367535/watchlist/
    // https://www.imdb.com/list/create/?ref_=wl_crte_lst_btn
    // https://www.imdb.com/list/ls590801835/edit/?ref_=cr_lst_crte

    @Test
    public void addToWatchlistTest() {
        FindPage findPage = new FindPage(driver);
        TitlePage titlePage = new TitlePage(driver);
        HomePage homePage = new HomePage(driver);
        WatchlistPage watchlistPage = new WatchlistPage(driver);

        findPage.FindTitle("Django Unchained");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until((driver) -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        titlePage.addTitleToWatchList();

        homePage.getNavBarWatchlistButton();

        wait.until((driver) -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));

        Assertions.assertTrue(watchlistPage.getWatchlistTitleText().contains("Django Unchained"));
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

        Assertions.assertTrue(driver.getCurrentUrl().contains("ref_=cr_lst_crte"));
    }

}
