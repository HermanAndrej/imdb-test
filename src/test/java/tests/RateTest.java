package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.FindPage;
import pages.TitlePage;

import java.time.Duration;

public class RateTest extends BaseTest {

    @Test
    public void guestUserRateTest() {
        FindPage findPage = new FindPage(driver);
        TitlePage titlePage = new TitlePage(driver);
        String expectedURL = "^https:\\/\\/www\\.imdb\\.com\\/registration\\/signin.*";

        findPage.FindTitle("Reservoir Dogs");

        titlePage.rateMovie();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until((driver) -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));

        Assertions.assertTrue(driver.getCurrentUrl().equals(expectedURL));
    }
}
