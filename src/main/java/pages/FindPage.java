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

    public WebElement getInterestSection() {
        return interestSection;
    }

    public WebElement getActorSection() {
        return actorSection;
    }

    public WebElement getTitleSection() {
        return titleSection;
    }
}
