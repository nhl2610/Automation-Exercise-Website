package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.BaseTest;
import utils.Helper;

public class RegisterWhileCheckout extends BaseTest {
    HomePage homePage;
    ProductPage productPage;
    CartPage cartPage;
    SignupPage signupPage;
    LoginPage loginPage;
    AccountCreatedPage accountCreatedPage;
    Helper helper;

    String name = "nhl13";
    String emailAddress = "nhl13@gmail.com";

    @Test
    public void testRegisterWhileCheckout() throws Exception {
        helper =new Helper(driver);
        homePage = new HomePage(driver);
        productPage = homePage.openProductPage();
        helper.closeGoogleAd();
        productPage.addProductToCart("37");
        productPage.clickContinueShoppingButton();
        cartPage = homePage.openCartPage();
        Assert.assertTrue(cartPage.verifyThatCartPageIsDisplayed());
        loginPage = cartPage.goToLoginPage();

        signupPage = loginPage.signUp(name,emailAddress);

        accountCreatedPage = signupPage.signUp();
        Thread.sleep(2000);
        accountCreatedPage.veryfyAccountCreated();

        homePage.usernameIsDisplay();
        homePage.openCartPage();

    }

}
