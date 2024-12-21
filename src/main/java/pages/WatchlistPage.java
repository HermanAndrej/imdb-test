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

    @FindBy(css = "[data-testid = 'input-list-name']")
    private WebElement enterListNameField;

    @FindBy(css = "[data-testid = 'input-list-description']")
    private WebElement enterListDescriptionField;

    @FindBy(css = "[data-testid = 'list-create-button']")
    private WebElement createListButton;

    @FindBy(css = "div.ipc-title.ipc-title--base.ipc-title--title.ipc-title-link-no-icon.ipc-title--on-textPrimary.sc-a69a4297-2.bqNXEn.dli-title.with-margin > a > h3")
    private WebElement watchlistTitle;

    @FindBy(css = "div.sc-65d2a03-1.hLElui.ipc-page-grid__item.ipc-page-grid__item--span-2")
    private WebElement watchlistBody;

    public WebElement getWatchlistTitle() {
        return watchlistTitle;
    }

    public void createNewList(String listName, String listDescription) {
        createNewListButton.click();

        enterListNameField.sendKeys(listName);
        enterListDescriptionField.sendKeys(listDescription);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        createListButton.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public WebElement getWatchlistBody() {
        return watchlistBody;
    }

    public String getWatchlistTitleText() {
        return watchlistTitle.getText();
    }

    public String getWatchlistBodyText() {
        return watchlistBody.getText();
    }

}
