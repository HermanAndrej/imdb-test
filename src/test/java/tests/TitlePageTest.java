package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.FindPage;
import pages.TitlePage;

import java.time.Duration;

public class TitlePageTest extends BaseTest {

    @Test
    public void findTitlePageTest() {
        FindPage findPage = new FindPage(driver);

        findPage.FindTitle("Nobody Knows");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until((driver) -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));

        Assertions.assertEquals("https://www.imdb.com/title/tt0408664/?ref_=fn_all_ttl_1", driver.getCurrentUrl(), "Not redirected to title page!");
    }

    @Test
    public void titleDetailsTest() {
        FindPage findPage = new FindPage(driver);
        TitlePage titlePage = new TitlePage(driver);

        findPage.FindTitle("Shoplifters");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until((driver) -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));

        Assertions.assertEquals("Shoplifters" ,titlePage.getTitleName(), "Title name doesn't match!");
        Assertions.assertTrue(titlePage.getOriginalTitleName().contains("Manbiki kazoku"));
        String[] titleDetails = {"2018", "15", "2h 1m"};
        for(String detail : titleDetails) {
            Assertions.assertTrue(titlePage.getTitleDetails().contains(detail));
        }
        Assertions.assertTrue(titlePage.getTitleRating().contains("/10"), "Title rating is not displayed!");
        Assertions.assertTrue(titlePage.getCastSection().isDisplayed(), "Cast not displayed!");
    }

    @Test
    public void getActorTest() {
        FindPage findPage = new FindPage(driver);
        TitlePage titlePage = new TitlePage(driver);

        findPage.FindTitle("Mean Girls");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until((driver) -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));

        titlePage.getCastSectionActor();

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait2.until((driver) -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));

        Assertions.assertEquals("https://www.imdb.com/name/nm0517820/?ref_=tt_cst_t_1", driver.getCurrentUrl(), "Not redirected to actor page!");
    }

}
