package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.SignInPage;

public class SignUpTest extends BaseTest {

    @Test
    public void signUpInvalidEmailTest() {
        SignInPage signInPage = new SignInPage(driver);

        signInPage.signUp("Toge Inumaki", "invalidemailinput", "BonitoFlakes123");

        Assertions.assertTrue(signInPage.getInvalidEmailInput().isDisplayed(), "Invalid email was accepted!");
    }

    @Test
    public void signUpInvalidPasswordTest() {
        SignInPage signInPage = new SignInPage(driver);

        signInPage.signUp("Gojo Satoru", "realemail@gmail.com", "gomen");

        Assertions.assertTrue(signInPage.getInvalidPasswordInput().isDisplayed(), "Invalid password was accepted!");
    }

    @Test
    public void signUpTestSuccess() {
        SignInPage signInPage = new SignInPage(driver);

        signInPage.signUp("Toge Inumaki", "realemail@gmail.com", "BonitoFlakes123");

        implicitWait(1000);
    }
}
