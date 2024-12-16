package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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


    @FindBy(xpath = "//*[@id=\"imdbHeader\"]/div[2]/aside[1]")
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

    // when not visible class = ipc-menu mdc-menu ipc-menu--not-initialized ipc-menu--on-baseAlt ipc-menu--anchored ipc-menu--with-checkbox ipc-menu--expand-from-top-right navbar__flyout--menu ipc-menu--anim-exit-done
    // when visible class = ipc-menu mdc-menu ipc-menu--not-initialized ipc-menu--on-baseAlt ipc-menu--anchored ipc-menu--open ipc-menu--with-checkbox ipc-menu--expand-from-top-right navbar__flyout--menu ipc-menu--anim-enter-done
    @FindBy(css = "div.sc-jQAyio.sc-csTbTw.dUVOWS.cXNOwG.navbar__flyout--breakpoint-m > div")
    private WebElement navBarLanguageMenu;

    ////*[@id="nav-search-form"]/div[1]/div
    ////*[@id="nav-search-form"]/div[1]/div

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

    public void searchForText(String query) {
        navBarSearch.sendKeys(query); // Enter search text
        navBarSearchFindButton.click(); // Click search button
    }
}
