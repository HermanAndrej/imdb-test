package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {
    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#signin-options > div > div:nth-child(2) > a:nth-child(1)")
    private WebElement signInWithImdb;

    @FindBy(id = "ap_email")
    private WebElement emailField;

    @FindBy(id = "ap_password")
    private WebElement passwordField;

    @FindBy(id = "signInSubmit")
    private WebElement signInSubmit;

    @FindBy(id = "auth-error-message-box")
    private WebElement authErrorMsgBox;

    public void signIn(String email, String password) {
        HomePage homePage = new HomePage(driver);

        homePage.getNavBarSignInButton().click();
        signInWithImdb.click();
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signInSubmit.click();
    }

    public WebElement getAuthErrorMsgBox() {
        return authErrorMsgBox;
    }
}
