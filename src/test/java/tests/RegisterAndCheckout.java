package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.BaseTest;
import utils.Helper;

public class RegisterAndCheckout extends BaseTest {
    HomePage homePage;
    ProductPage productPage;
    CartPage cartPage;
    SignupPage signupPage;
    LoginPage loginPage;
    AccountCreatedPage accountCreatedPage;
    CheckoutPage checkoutPage;
    PaymentPage paymentPage;
    DeleteAccountPage deleteAccountPage;
    Helper helper;

    String name = "nhl13";
    String emailAddress = "nhl13@gmail.com";

    @Test
    public void TC14_testRegisterWhileCheckout() throws Exception {
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
        cartPage = homePage.openCartPage();
        checkoutPage = cartPage.goToCheckoutPage();
        paymentPage = checkoutPage.placeOrder();
        paymentPage.payAndConfirmOrder();
        paymentPage.verifySeccessMessage();
        deleteAccountPage = homePage.deleteAccount();
        Thread.sleep(10000);
        deleteAccountPage.deleteAccount();
    }

    @Test
    public void TC15_registerBeforeCheckout() throws Exception {
        helper =new Helper(driver);
        homePage = new HomePage(driver);
        loginPage = homePage.openLoginPage();
        signupPage = loginPage.signUp(name,emailAddress);
        accountCreatedPage = signupPage.signUp();
        Thread.sleep(2000);
        accountCreatedPage.veryfyAccountCreated();
        helper.closeGoogleAd();
        homePage.usernameIsDisplay();
        productPage = homePage.openProductPage();
        productPage.addProductToCart("37");
        productPage.clickContinueShoppingButton();
        cartPage = homePage.openCartPage();
        Assert.assertTrue(cartPage.verifyThatCartPageIsDisplayed());
        checkoutPage = cartPage.goToCheckoutPage();
        paymentPage = checkoutPage.placeOrder();
        paymentPage.payAndConfirmOrder();
        paymentPage.verifySeccessMessage();
        deleteAccountPage = homePage.deleteAccount();
        Thread.sleep(10000);
        deleteAccountPage.deleteAccount();
    }
}
