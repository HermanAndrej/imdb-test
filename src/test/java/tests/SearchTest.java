package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.FindPage;
import pages.HomePage;

import java.time.Duration;

public class SearchTest extends BaseTest {

    @Test
    public void searchTitleSuccess() {
        HomePage homePage = new HomePage(driver);
        FindPage findPage = new FindPage(driver);

        homePage.searchForText("parasite");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement titleSection = wait.until(ExpectedConditions.visibilityOf(findPage.getTitleSection()));

        Assertions.assertTrue(titleSection.getText().contains("Parasite"), "Search result does not include 'Parasite'");
    }

    @Test
    public void searchTitleFailure() {
        HomePage homePage = new HomePage(driver);
        FindPage findPage = new FindPage(driver);

        homePage.searchForText("some nonexisting movie");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement firstResult = wait.until(ExpectedConditions.visibilityOf(findPage.getTitleSection()));

        Assertions.assertTrue(findPage.getTitleSection().isDisplayed());
        Assertions.assertTrue(firstResult.getText().contains("No results found for \"some nonexisting movie\""), "Test for invalid title search failed.");
    }

    @Test
    public void searchEmptyField() {
        HomePage homePage = new HomePage(driver);
        FindPage findPage = new FindPage(driver);

        homePage.searchForText(" ");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until((driver) -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));

        Assertions.assertThrows(NoSuchElementException.class ,() -> {findPage.getInterestSection().isDisplayed();}, "Interest section is displayed!");
        Assertions.assertThrows(NoSuchElementException.class ,() -> {findPage.getActorSection().isDisplayed();}, "Actor section is displayed!");
        Assertions.assertThrows(NoSuchElementException.class ,() -> {findPage.getTitleSection().isDisplayed();}, "Title section is displayed!");
    }
}
