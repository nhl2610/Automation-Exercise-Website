package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CategoryPage;
import utils.BaseTest;
import utils.Helper;

public class CategoryTest extends BaseTest {
    CategoryPage categoryPage;
    Helper helper;
    String menu = "WOMEN";
    String submenu = "TOPS";

    @Test
    public void TC18_viewCategoryProducts() throws Exception {
        helper = new Helper(driver);
        categoryPage = new CategoryPage(driver);
        Assert.assertTrue(categoryPage.verifyThatCategoryAreVisibleOnLeft(),"Menu is not visible on left side");
        categoryPage.clickCategory(menu,submenu);
        helper.closeGoogleAd();
        boolean categoryTitleCheck = categoryPage.getCategoryTitle().contains(menu) &&
                categoryPage.getCategoryTitle().contains(submenu);
        Thread.sleep(2000);
        Assert.assertTrue(categoryTitleCheck,"Category Page displays wrong title");

        categoryPage.clickCategory("MEN","JEANS");
        categoryTitleCheck = categoryPage.getCategoryTitle().contains("MEN") &&
                categoryPage.getCategoryTitle().contains("JEANS");
        Assert.assertTrue(categoryTitleCheck,"Category Page displays wrong title");

    }
}
