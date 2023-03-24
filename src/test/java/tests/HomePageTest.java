package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.BaseTest;

public class HomePageTest extends BaseTest {
    HomePage homePage;
    @Test
    public void verifySubscriptionInHomePage()
    {
        homePage = new HomePage(driver);
        Assert.assertTrue(homePage.getFooterTitle().contains("SUBSCRIPTION"));
        homePage.sendEmailSubscription("nhl@gmail.com");
        Assert.assertTrue(homePage.getAlertSuccessSubscibe().contains("You have been successfully subscribed!"));
    }
}
