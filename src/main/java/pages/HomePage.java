package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Navbar elements
    @FindBy(id = "home_img_holder")
    private WebElement navBarLogo;

    @FindBy(id = "imdbHeader-navDrawerOpen")
    private WebElement navBarMenu;

    @FindBy(css = ".ipc-btn--core-base")
    private WebElement navBarSearchFilter;


    @FindBy(css = ".gUPgwv.drawer")
    private WebElement navBarMenuShown;

    @FindBy(id = "suggestion-search") //??? couldn't click
    private WebElement navBarSearch;

    @FindBy(css = "#suggestion-search-button")
    private WebElement navBarSearchFindButton;

    @FindBy(css = "div.navbar__imdbpro.sc-GvgMv.ftVCet > div > a")
    private WebElement navBarIMDBProIcon;

    @FindBy(css = "div.sc-fcmLWC.jzOrdI.imdb-header__watchlist-button > a")
    private WebElement navBarWatchlistButton;

    @FindBy(css = "div.nav__userMenu.navbar__user.sc-fuISYh.hrzrxR > a")
    private WebElement navBarSignInButton;

    @FindBy(css = "div.sc-jQAyio.sc-csTbTw.dUVOWS.cXNOwG.navbar__flyout--breakpoint-m > label")
    private WebElement navBarLanguageSelectorButton;

    @FindBy(id = "language-option-en-US")
    private WebElement languageSelectorEnglish;

    @FindBy(id = "language-option-de-DE")
    private WebElement languageSelectorGerman;

    @FindBy(id = "language-option-it-IT")
    private WebElement languageSelectorItalian;

    // when not visible class = ipc-menu mdc-menu ipc-menu--not-initialized ipc-menu--on-baseAlt ipc-menu--anchored ipc-menu--with-checkbox ipc-menu--expand-from-top-right navbar__flyout--menu ipc-menu--anim-exit-done
    // when visible class = ipc-menu mdc-menu ipc-menu--not-initialized ipc-menu--on-baseAlt ipc-menu--anchored ipc-menu--open ipc-menu--with-checkbox ipc-menu--expand-from-top-right navbar__flyout--menu ipc-menu--anim-enter-done
    @FindBy(id = "nav-language-selector-contents")
    private WebElement navBarLanguageMenu;

    // Shown only if user is logged in
    @FindBy(css = ".navbar__user-menu-toggle__button")
    private WebElement navBarProfileIcon;

    // Shown only if user is logged in
    @FindBy(id = "navUserMenu-contents")
    private WebElement navBarProfileMenu;

    // Shown only if user is logged in
    @FindBy(xpath = "//label[text()='Your profile']")
    private WebElement navBarProfileMenuProfile;

    public WebElement getNavBarLogo() {
        return navBarLogo;
    }

    public WebElement getNavBarIMDBProIcon() {
        return navBarIMDBProIcon;
    }

    public WebElement getNavBarWatchlistButton() {
        return navBarWatchlistButton;
    }

    public WebElement getNavBarSignInButton() {
        return navBarSignInButton;
    }

    public WebElement getNavBarMenu() {
        return navBarMenu;
    }

    public WebElement getNavBarMenuShown() {
        return navBarMenuShown;
    }

    public WebElement getNavBarLanguageSelectorButton() {
        return navBarLanguageSelectorButton;
    }

    public WebElement getNavBarLanguageMenu() {
        return navBarLanguageMenu;
    }

    public WebElement getNavBarProfileIcon() {
        return navBarProfileIcon;
    }

    public WebElement getNavBarProfileMenu() {
        return navBarProfileMenu;
    }

    public WebElement getNavBarProfileMenuProfile() {
        return navBarProfileMenuProfile;
    }

    public void searchForText(String query) {
        navBarSearch.sendKeys(query); // Enter search text
        navBarSearchFindButton.click(); // Click search button
    }

    public void switchLanguage(String language) {
        navBarLanguageSelectorButton.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.visibilityOf(navBarLanguageMenu));

        switch(language) {
            case "English":
                js.executeScript("arguments[0].click();", languageSelectorEnglish);
                break;
            case "German":
                js.executeScript("arguments[0].click();", languageSelectorGerman);
                break;
            case "Italian":
                js.executeScript("arguments[0].click();", languageSelectorItalian);
                break;
            default:
                System.out.println("Choose between English, German and Italian!");
        }
    }
}
