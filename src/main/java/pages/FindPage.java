package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FindPage extends BasePage {
    public FindPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[data-testid='find-results-section-name']")
    private WebElement actorSection;

    @FindBy(css = "[data-testid='find-results-section-title']")
    private WebElement titleSection;

    @FindBy(css = "[data-testid='find-results-section-interest']")
    private WebElement interestSection;

    @FindBy(css = "[data-testid='find-results-section-name']")
    private WebElement peopleSection;

    @FindBy(css = "div.sc-b03627f1-2.gWHDBT > ul > li:nth-child(1)")
    private WebElement titleSectionFirstMatch;

    public WebElement getInterestSection() {
        return interestSection;
    }

    public WebElement getActorSection() {
        return actorSection;
    }

    public WebElement getTitleSection() {
        return titleSection;
    }

    public WebElement getPeopleSection() {
        return peopleSection;
    }

    public void FindTitle(String titleName) {
        HomePage homePage = new HomePage(driver);
        homePage.searchForText(titleName);
        implicitWait(2000);
        titleSectionFirstMatch.click();
    }
}
