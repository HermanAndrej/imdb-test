package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "home_img_holder")
    private WebElement navBarLogo;

    @FindBy(id = "imdbHeader-navDrawerOpen")
    private WebElement navBarMenu;

    @FindBy(css = ".ipc-btn--core-base")
    private WebElement navBarSearchFilter;

    @FindBy(css = "#nav-search-form > div:nth-child(1) > div > div > div > div > ul > li:nth-child(2)")
    private WebElement navBarSearchTitleFilter;

    @FindBy(css = ".gUPgwv.drawer")
    private WebElement navBarMenuShown;

    @FindBy(id = "suggestion-search")
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

    @FindBy(id = "nav-language-selector-contents")
    private WebElement navBarLanguageMenu;

    // Shown only if user is logged in
    @FindBy(css = ".navbar__user-menu-toggle__button")
    private WebElement navBarProfileIcon;

    // Shown only if user is logged in
    @FindBy(id = "navUserMenu-contents")
    private WebElement navBarProfileMenu;

    // Shown only if user is logged in
    @FindBy(css = "#navUserMenu-contents > ul > a:nth-child(3)")
    private WebElement navBarProfileMenuProfile;

    @FindBy(css = "div.ipc-shoveler.ipc-shoveler--base.ipc-shoveler--page0.rvi-shoveler")
    private WebElement recentlyViewedSection;

    @FindBy(css = "div.ipc-title.ipc-title--baseAlt.ipc-title--subsection-title.ipc-title--on-textPrimary.sc-10b3b195-0.cxKMzQ > div > div > button")
    private WebElement clearRecentlyViewed;

    @FindBy(id = "captcha-container")
    private WebElement captchaContainer;

    public WebElement getCaptchaContainer() {
        return captchaContainer;
    }

    public WebElement getNavBarLogo() {
        return navBarLogo;
    }

    public WebElement getClearRecentlyViewed() {
        return clearRecentlyViewed;
    }

    public WebElement getNavBarSearch() {
        return navBarSearch;
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

    public WebElement getRecentlyViewedSection() {
        return recentlyViewedSection;
    }

    public void searchForText(String query) {
        navBarSearch.sendKeys(query);
        navBarSearchFindButton.click();
    }

    public void searchForTextTitleFilter(String query) {
        navBarSearch.sendKeys(query);
        navBarSearchFilter.click();
        navBarSearchTitleFilter.click();
        navBarSearchFindButton.click();
    }

    public void goToRecentlyViewedSection() {
        scrollToElement(recentlyViewedSection);

        implicitWait(500);
    }

    public void switchLanguage(String language) {
        navBarLanguageSelectorButton.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;

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
