package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.BaseTest;
import utils.Helper;

public class LoginBeforeCheckout extends BaseTest {
    HomePage homePage;
    ProductPage productPage;
    CartPage cartPage;
    LoginPage loginPage;
    CheckoutPage checkoutPage;
    PaymentPage paymentPage;
    DeleteAccountPage deleteAccountPage;
    Helper helper;
    String email = "nhl12@gmail.com";
    String password = "123456";

    @Test
    public void TC16_testLoginBeforeCheckout() throws Exception {
        helper = new Helper(driver);
        homePage = new HomePage(driver);
        loginPage = homePage.openLoginPage();
        loginPage.login(email, password);
        homePage.usernameIsDisplay();
        Thread.sleep(2000);

        productPage = homePage.openProductPage();
        helper.closeGoogleAd();
        productPage.addProductToCart("42");
        productPage.clickContinueShoppingButton();
        cartPage = homePage.openCartPage();
        Assert.assertTrue(cartPage.verifyThatCartPageIsDisplayed());
        checkoutPage = cartPage.goToCheckoutPage();
        paymentPage = checkoutPage.placeOrder();
        paymentPage.payAndConfirmOrder();
        paymentPage.verifySeccessMessage();

    }
}
