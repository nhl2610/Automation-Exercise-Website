package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailPage;
import pages.ProductPage;
import utils.BasePage;
import utils.BaseTest;
import utils.Helper;

public class ProductTest extends BaseTest {
    HomePage homePage;
    ProductPage productPage;
    ProductDetailPage productDetailPage;
    BasePage basePage;
    Helper helper;

    @Test
    public void TC8_verifyAllProductsAndProductDetailPage() throws Exception {
        helper = new Helper(driver);
        //basePage = new BasePage(driver);
        homePage = new HomePage(driver);
        productPage = homePage.openProductPage();
        Thread.sleep(2000);
        helper.closeGoogleAd();
        Assert.assertTrue(productPage.getPageTitle().contains("ALL PRODUCTS"),"Product Page Title");
        productDetailPage = productPage.goToFirstProductPage();
        Assert.assertTrue(productDetailPage.getPageTitle().contains("Product Details"));
        Assert.assertTrue(productDetailPage.productDetailIsVisible());
    }

}
