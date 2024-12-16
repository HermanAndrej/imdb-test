package tests.guestuser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import tests.BaseTest;

public class NavBarTest extends BaseTest {

    @Test
    public void logoIconTestRef() {
        HomePage homePage = new HomePage(driver);

        homePage.getNavBarLogo().click();

        Assertions.assertEquals("https://www.imdb.com/?ref_=nv_home", driver.getCurrentUrl(), "Clicking on the logo icon doesn't redirect to the home page!");
    }

    @Test
    public void imdbProIconTestRef() {
        HomePage homePage = new HomePage(driver);

        homePage.getNavBarIMDBProIcon().click();

        Assertions.assertEquals("https://pro.imdb.com/login/ap?u=/login/lwa&imdbPageAction=signUp&rf=cons_nb_hm&ref_=cons_nb_hm", driver.getCurrentUrl(), "Clicking on the imdb pro icon doesn't redirect to pro sign in page!");
    }

    @Test
    public void watchlistIconTestRef() {
        HomePage homePage = new HomePage(driver);
        String expectedURL = "^https:\\/\\/www\\.imdb\\.com\\/registration\\/signin.*";

        homePage.getNavBarWatchlistButton().click();

        Assertions.assertTrue(driver.getCurrentUrl().matches(expectedURL), "Invalid");
    }

    @Test
    public void signInIconTestRef() {
        HomePage homePage = new HomePage(driver);
        String expectedURL = "^https:\\/\\/www\\.imdb\\.com\\/registration\\/signin.*";

        homePage.getNavBarSignInButton().click();

        Assertions.assertTrue(driver.getCurrentUrl().matches(expectedURL), "Invalid");
    }
}
