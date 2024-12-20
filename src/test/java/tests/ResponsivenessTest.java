package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import pages.HomePage;

public class ResponsivenessTest extends BaseTest {

    @Test
    public void testMobileResponsiveness() {
        HomePage homePage = new HomePage(driver);
        driver.manage().window().setSize(new Dimension(375, 800));

        Assertions.assertTrue(homePage.getNavBarLogo().isDisplayed(), "Logo is not visible on mobile view");
        Assertions.assertTrue(homePage.getNavBarMenu().isDisplayed(), "Menu is not visible on mobile view");
        Assertions.assertTrue(homePage.getNavBarSignInButton().isDisplayed(), "Sign in button is not visible on mobile view");
    }

    @Test
    public void testTabletResponsiveness() {
        HomePage homePage = new HomePage(driver);
        driver.manage().window().setSize(new Dimension(768, 1024));

        Assertions.assertTrue(homePage.getNavBarLogo().isDisplayed(), "Logo is not visible on tablet view");
        Assertions.assertTrue(homePage.getNavBarMenu().isDisplayed(), "Menu is not visible on tablet view");
        Assertions.assertTrue(homePage.getNavBarSignInButton().isDisplayed(), "Sign in button is not visible on tablet view");
    }

}
