package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.SignInPage;

public class SignUpTest extends BaseTest {

    @Test
    public void signUpInvalidEmailTest() {
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = new SignInPage(driver);

        homePage.getNavBarSignInButton().click();
        signInPage.getCreateNewAccountButton().click();
        signInPage.signUpEnterName("Toge Inumaki");
        signInPage.enterEmail("invalidemailinput");
        signInPage.enterPassword("BonitoFlakes123");
        signInPage.reenterPassword("BonitoFlakes123");
        signInPage.getSignUpContinueButton().click();

        Assertions.assertTrue(signInPage.getInvalidEmailInput().isDisplayed(), "Invalid email was accepted!");
    }

    @Test
    public void signUpInvalidPasswordTest() {
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = new SignInPage(driver);

        homePage.getNavBarSignInButton().click();
        signInPage.getCreateNewAccountButton().click();
        signInPage.signUpEnterName("Gojo Satoru");
        signInPage.enterEmail("realemail@gmail.com");
        signInPage.enterPassword("gomen");
        signInPage.reenterPassword("gomen");
        signInPage.getSignUpContinueButton().click();

        Assertions.assertTrue(signInPage.getInvalidPasswordInput().isDisplayed(), "Invalid password was accepted!");
    }

    @Test
    public void signUpTestSuccess() {
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = new SignInPage(driver);

        homePage.getNavBarSignInButton().click();
        signInPage.getCreateNewAccountButton().click();
        signInPage.signUpEnterName("Toge Inumaki");
        signInPage.enterEmail("cofeya9840@owube.com");
        signInPage.enterPassword("BonitoFlakes123");
        signInPage.reenterPassword("BonitoFlakes123");
        signInPage.getSignUpContinueButton().click();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
