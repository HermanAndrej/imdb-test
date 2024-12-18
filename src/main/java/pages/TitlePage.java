package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TitlePage extends BasePage {
    public TitlePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[data-testid='hero__primary-text']")
    private WebElement titleName;

    @FindBy(css = "div.sc-70a366cc-0.bxYZmb > div")
    private WebElement originalTitleName;

    @FindBy(css = "div.sc-70a366cc-0.bxYZmb > ul")
    private WebElement titleDetails;

    // https://www.imdb.com/title/tt0408664/ratings/?ref_=tt_ov_rat
    @FindBy(css = "div.sc-3a4309f8-0.jJkxPn.sc-70a366cc-1.kUfGfN > div > div:nth-child(1) > a")
    private WebElement titleRating;

    @FindBy(css = "div.sc-3a4309f8-0.jJkxPn.sc-70a366cc-1.kUfGfN > div > div:nth-child(2) > button")
    private WebElement rateButton;

    @FindBy(css = "[data-testid='promptable__pc']")
    private WebElement ratePromptWindow;

    @FindBy(css = "section.ipc-page-section.ipc-page-section--base.sc-cd7dc4b7-0.ycheS.title-cast.title-cast--movie.celwidget")
    private WebElement castSection;

    @FindBy(css = "[data-testid='title-cast-item__actor']")
    private WebElement castSectionActor;

    @FindBy(css = "div.ipc-starbar__rating > button:nth-child(9)")
    private WebElement rateNineStars;

    //@FindBy(xpath = "/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div[2]/div/div[2]/button[9]")
    //private WebElement rateNineStars;

    @FindBy(css = "div.ipc-rating-prompt__rating-container > button")
    private WebElement sumbitRatingButton;

    public String getTitleName() {
        return titleName.getText();
    }

    public String getOriginalTitleName() {
        return originalTitleName.getText();
    }

    public String getTitleDetails() {
        return titleDetails.getText();
    }

    public String getTitleRating() {
        return titleRating.getText();
    }

    public WebElement getCastSection() {
        return castSection;
    }

    public void rateMovie() {
        rateButton.click();
        rateNineStars.click();
        sumbitRatingButton.click();
    }

    public void getCastSectionActor() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", castSectionActor);
        castSectionActor.click();
    }
}
