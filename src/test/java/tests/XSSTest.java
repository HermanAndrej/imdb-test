package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.HomePage;

public class XSSTest extends BaseTest {

    @Test
    public void xssSearchBarInputTest() {
        HomePage homePage = new HomePage(driver);

        homePage.searchForText("<script>alert('XSS')</script>");

        Assertions.assertTrue(homePage.getCaptchaContainer().isDisplayed(), "Bot check not sent!");
    }

    @Test
    public void xssURLInputTest() {
        HomePage homePage = new HomePage(driver);

        driver.navigate().to("https://www.imdb.com/find/?q=%3Cscript%3Ealert(%27XSS%27)%3C/script%3E");

        Assertions.assertTrue(homePage.getCaptchaContainer().isDisplayed(), "Bot check not sent!");
    }

    @Test
    public void xssSearchBarAlertLinkInputTest() {
        HomePage homePage = new HomePage(driver);

        homePage.searchForText("<a href='javascript:alert(\"XSS\")'>Click me</a>");

        Assertions.assertTrue(homePage.getCaptchaContainer().isDisplayed(), "Bot check not sent!");
    }
}
