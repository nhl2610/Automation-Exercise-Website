package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.BasePage;
import utils.BaseTest;
import utils.Helper;
import utils.PropertiesFile;

public class SearchProductTest extends BaseTest {
    HomePage homePage;
    ProductPage productPage;
    CartPage cartPage;
    BasePage basePage;
    Helper helper;
    String productSearch = "Jeans";
    LoginPage loginPage;
    PropertiesFile propertiesFile;

    public void TC9_userCanSearchProduct() throws InterruptedException {
        helper = new Helper(driver);
        homePage = new HomePage(driver);
        productPage = homePage.openProductPage();
        Thread.sleep(2000);
        helper.closeGoogleAd();
        Assert.assertTrue(productPage.getPageTitle().contains("ALL PRODUCTS"),"Product Page Title");
        productPage.searchProduct(productSearch);
        Assert.assertTrue(productPage.verifyProductList(productSearch),"Product not match!");
    }

    @Test
    public void TC20_searchProductsAndVerifyCartAfterLogin()
    {
        helper = new Helper(driver);
        homePage = new HomePage(driver);
        productPage = homePage.openProductPage();
        helper.closeGoogleAd();
        Assert.assertTrue(productPage.getPageTitle().contains("ALL PRODUCTS"),"Product Page Title");
        productPage.searchProduct(productSearch);
        Assert.assertTrue(productPage.verifyProductList(productSearch),"Product not match!");
        productPage.addAllProductToCart();
        cartPage = productPage.openCartPage();
        Assert.assertTrue(cartPage.verifyProductNameList(productSearch));
        loginPage = cartPage.goToLoginPage();
        String emailAddress = propertiesFile.getPropValue("/src/test/resources/testdata/user.properties","email");
        String password = propertiesFile.getPropValue("/src/test/resources/testdata/user.properties","password");
        loginPage.login(emailAddress, password);
        cartPage = homePage.openCartPage();
        Assert.assertTrue(cartPage.verifyProductNameList(productSearch));
        cartPage.removeAllProduct();
    }
}
