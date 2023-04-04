package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.BaseTest;
import utils.PropertiesFile;

public class LogoutTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;
    PropertiesFile  propertiesFile;

    @Test
    public void TC4_testLogout() throws Exception {
        String emailAddress = propertiesFile.getPropValue("/src/test/resources/testdata/user.properties","email");
        String password = propertiesFile.getPropValue("/src/test/resources/testdata/user.properties","password");
        homePage = new HomePage(driver);
        loginPage = homePage.openLoginPage();
        loginPage.login(emailAddress, password);
        homePage.usernameIsDisplay();
        homePage.logout();
    }
}
