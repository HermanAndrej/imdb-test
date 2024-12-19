package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WatchlistPage extends BasePage {
    public WatchlistPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[data-testid = 'list-page-atf-add-to-list-btn']")
    private WebElement createNewListButton;

    @FindBy(id = "text-input__8184")
    private WebElement enterListNameField;

    @FindBy(id = "textarea__4")
    private WebElement enterListDescriptionField;

    @FindBy(css = "[data-testid = 'list-create-button']")
    private WebElement createListButton;

    @FindBy(css = "[data-testid ='list-page-mc-list-content']")
    private WebElement watchlistTitle;


    public void createNewList(String listName, String listDescription) {
        createNewListButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until((driver) -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));

        enterListNameField.sendKeys(listName);
        enterListDescriptionField.sendKeys(listDescription);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        createListButton.click();
    }

    public String getWatchlistTitleText() {
        return watchlistTitle.getText();
    }
}
