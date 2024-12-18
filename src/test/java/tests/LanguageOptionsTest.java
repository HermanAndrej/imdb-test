package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;

import java.time.Duration;

public class LanguageOptionsTest extends BaseTest {

    @Test
    void germanTest() {
        HomePage homePage = new HomePage(driver);

        homePage.switchLanguage("German");

        Assertions.assertEquals("https://www.imdb.com/de/", driver.getCurrentUrl(), "Url not changed to German!");
        Assertions.assertEquals("Anmelden", homePage.getNavBarSignInButton().getText(), "Sign in not translated correctly!");
        Assertions.assertEquals("DE", homePage.getNavBarLanguageSelectorButton().getText(), "Language selector not set to DE!");
    }

    @Test
    void italianTest() {
        HomePage homePage = new HomePage(driver);

        homePage.switchLanguage("Italian");

        Assertions.assertEquals("https://www.imdb.com/it/", driver.getCurrentUrl(), "Url not changed to Italian!");
        Assertions.assertEquals("Accedi", homePage.getNavBarSignInButton().getText(), "Sign in not translated correctly!");
        Assertions.assertEquals("IT", homePage.getNavBarLanguageSelectorButton().getText(), "Language selector not set to IT!");
    }

    @Test
    void backToEnglish() {
        HomePage homePage = new HomePage(driver);

        homePage.switchLanguage("Italian");

        homePage.switchLanguage("English");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until((driver) -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));


        Assertions.assertEquals("https://www.imdb.com/", driver.getCurrentUrl(), "Url not changed to English!");
        Assertions.assertEquals("Sign In", homePage.getNavBarSignInButton().getText(), "Sign in not translated correctly!");
        Assertions.assertEquals("EN", homePage.getNavBarLanguageSelectorButton().getText(), "Language selector not set to IT!");
    }
}
