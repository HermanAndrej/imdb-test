package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.NoSuchElementException;
import pages.FindPage;
import pages.HomePage;

public class SearchFilterTest extends BaseTest {

    @Test
    public void searchWithoutFilterTest() {
        HomePage homePage = new HomePage(driver);
        FindPage findPage = new FindPage(driver);

        homePage.searchForText("House");

        Assertions.assertTrue(findPage.getTitleSection().isDisplayed(), "Title section is not displayed!");
        Assertions.assertTrue(findPage.getPeopleSection().isDisplayed(), "People section is not displayed!");
    }

    @Test
    public void searchWithTitleFilterTest() {
        HomePage homePage = new HomePage(driver);
        FindPage findPage = new FindPage(driver);

        homePage.searchForTextTitleFilter("House");

        Assertions.assertTrue(findPage.getTitleSection().isDisplayed(), "Title section is not displayed!");
        Assertions.assertThrows(NoSuchElementException.class, () -> {findPage.getPeopleSection().isDisplayed();});
    }
}
