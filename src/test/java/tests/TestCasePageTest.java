package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.TestCasePage;
import utils.BasePage;
import utils.BaseTest;

public class TestCasePageTest extends BaseTest {
    HomePage homePage;
    TestCasePage testCasePage;
    BasePage basePage;
    @Test
    public void homepageRedirectToTestCasePage() throws Exception {
        basePage = new BasePage(driver);
        homePage = new HomePage(driver);
        homePage.openTestCasePage();
    }
}
