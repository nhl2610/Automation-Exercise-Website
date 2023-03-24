package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.BaseTest;

public class LogoutTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;

    String password = "123456";
    String emailAddress = "nhl11@gmail.com";

    @Test
    public void testLogout() throws Exception {
        homePage = new HomePage(driver);

        loginPage = homePage.openLoginPage();
        loginPage.login(emailAddress, password);

        homePage.usernameIsDisplay();

        homePage.logout();
    }
}
