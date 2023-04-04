package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrandPage;
import pages.CategoryPage;
import pages.HomePage;
import pages.ProductPage;
import utils.BaseTest;
import utils.Helper;

public class BrandTest extends BaseTest {
    HomePage homePage;
    Helper helper;
    ProductPage productPage;
    BrandPage brandPage;
    String brand1 = "BABYHUG";
    String brand2 = "POLO";
    @Test
    public void TC19_viewBrandProducts() throws Exception {
        helper = new Helper(driver);
        homePage = new HomePage(driver);
        productPage = homePage.openProductPage();
        brandPage = new BrandPage(driver);
        Assert.assertTrue(brandPage.verifyThatBrandAreVisibleOnLeft(),"Brand menu is not visible on left side");
        helper.closeGoogleAd();
        brandPage.clickBrand(brand1);
        boolean brandTitleCheck = brandPage.getBrandTitle().contains("BRAND") &&
                brandPage.getBrandTitle().contains(brand1);
        Assert.assertTrue(brandTitleCheck,"Brand Page displays wrong title");

        brandPage.clickBrand(brand2);
        brandTitleCheck = brandPage.getBrandTitle().contains("BRAND") &&
                brandPage.getBrandTitle().contains(brand2);
        Assert.assertTrue(brandTitleCheck,"Brand Page displays wrong title");


    }
}
