package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

    @FindBy(css = "[data-testid='hero-rating-bar__user-rating__score']")
    private WebElement titleUserRating;

    @FindBy(css = "div.sc-3a4309f8-0.jJkxPn.sc-70a366cc-1.kUfGfN > div > div:nth-child(2) > button")
    private WebElement rateButton;

    @FindBy(css = "[data-testid='promptable__pc']")
    private WebElement ratePromptWindow;

    @FindBy(css = "section.ipc-page-section.ipc-page-section--base.sc-cd7dc4b7-0.ycheS.title-cast.title-cast--movie.celwidget")
    private WebElement castSection;

    @FindBy(css = "div.sc-cd7dc4b7-7.vCane > a")
    private WebElement castSectionActor;

    @FindBy(css = "div.ipc-starbar__rating > button:nth-child(9)")
    private WebElement rateNineStars;

    @FindBy(css = ".ipc-text-button.ipc-rating-prompt__secondary-button > span")
    private WebElement removeRatingButton;

    @FindBy(css = "[data-testid='tm-box-wl-button']")
    private WebElement addTitleToWatchlist;

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

    public String getTitleUserRating() {
        return titleUserRating.getText();
    }

    public WebElement getCastSection() {
        return castSection;
    }

    public WebElement getTitleUserRatingElement() {
        return titleUserRating;
    }

    public void rateTitle() {
        rateButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(rateNineStars));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", rateNineStars);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sumbitRatingButton.click();
    }

    public void removeTitleRating() {
        rateButton.click();
        removeRatingButton.click();
    }

    public void getCastSectionActor() {
        scrollToElement(castSectionActor);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        castSectionActor.click();
    }

    public void addTitleToWatchList() {
        scrollToElement(addTitleToWatchlist);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        addTitleToWatchlist.click();
    }
}
