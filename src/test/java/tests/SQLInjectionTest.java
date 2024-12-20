package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.SignInPage;

public class SQLInjectionTest extends BaseTest {

    @Test
    public void loginSQLInjectionTest() {
        SignInPage signInPage = new SignInPage(driver);

        String injectionString = "admin' OR '1'='1' --";

        signInPage.signIn(injectionString, injectionString);

        Assertions.assertNotEquals("https://www.imdb.com/?ref_=login", driver.getCurrentUrl(), "Login was successful!");
    }

    @Test
    public void searchSQLInjectionTest() {
        HomePage homePage = new HomePage(driver);

        String injectionString = "' OR '1'='1' --";

        homePage.searchForText(injectionString);

        Assertions.assertTrue(homePage.getCaptchaContainer().isDisplayed(), "Bot check not sent!");
    }
}
