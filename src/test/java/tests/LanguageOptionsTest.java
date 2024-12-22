package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;

import java.time.Duration;

public class LanguageOptionsTest extends BaseTest {

    @ParameterizedTest
    @CsvSource({
            "German, https://www.imdb.com/de/, Anmelden, DE",
            "Italian, https://www.imdb.com/it/, Accedi, IT",
            "English, https://www.imdb.com/, Sign In, EN"
    })
    void testSwitchLanguage(String language, String expectedUrl, String expectedSignInText, String expectedLanguageCode) {
        HomePage homePage = new HomePage(driver);
        homePage.switchLanguage(language);

        Assertions.assertEquals(expectedUrl, driver.getCurrentUrl(), "URL not changed correctly!");
        Assertions.assertEquals(expectedSignInText, homePage.getNavBarSignInButton().getText(), "Sign in not translated correctly!");
        Assertions.assertEquals(expectedLanguageCode, homePage.getNavBarLanguageSelectorButton().getText(), "Language selector code mismatch!");
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
        Assertions.assertEquals("EN", homePage.getNavBarLanguageSelectorButton().getText(), "Language code not set to IT!");
    }
}
