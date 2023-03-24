package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductDetailPage;
import pages.ProductPage;
import utils.BaseTest;
import utils.Helper;

public class CartTest extends BaseTest {
    HomePage homePage;
    ProductPage productPage;
    CartPage cartPage;
    ProductDetailPage productDetailPage;
    Helper helper;
    @Test
    public void TC12_addProductsToCart () throws Exception
    {
        helper =new Helper(driver);
        homePage = new HomePage(driver);
        productPage = homePage.openProductPage();
        helper.closeGoogleAd();
        productPage.addProductToCart("1");
        productPage.clickContinueShoppingButton();
        productPage.addProductToCart("2");
        cartPage = productPage.clickViewCartButton();
        boolean checkProductInCart = cartPage.verifyProductInList("1") && cartPage.verifyProductInList("2");
        Assert.assertTrue(checkProductInCart,"Product not found");
        Assert.assertTrue(cartPage.verifyTotalPrice());

    }

    @Test
    public void verifyProductQuantityInCart()
    {
        helper = new Helper(driver);
        homePage = new HomePage(driver);
        productDetailPage = homePage.goToAnyProductPage();
        helper.closeGoogleAd();
        Assert.assertTrue(driver.getCurrentUrl().contains("product_details/"));
        String productId = productDetailPage.getProductId();
        productDetailPage.addProductToCart("4");
        cartPage = productDetailPage.clickViewCartButton();
        System.out.println(productId);
        Assert.assertEquals(cartPage.getQuantityOfProduct(productId),"4","Product quantity is not true");
    }
}