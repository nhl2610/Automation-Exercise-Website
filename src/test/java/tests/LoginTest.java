package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DeleteAccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.BaseTest;
import utils.Helper;

import java.util.List;

public class LoginTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;
    DeleteAccountPage deleteAccountPage;
    Helper helper;
    String email = "nhl10@gmail.com";
    String password = "123456";

    String emailInvalid = "nhl10zvg@gmail.com";
    String passwordInvalid = "123456";

    @Test(enabled = false)
    public void tessst()
    {
        driver.get("https://www.automationexercise.com/products");
        List<WebElement> list = driver.findElements(By.xpath("//a[contains(@href,'/product_details')]"));
        for (WebElement element : list) {

        System.out.println(element.getAttribute("href"));
        }
    }

    @Test
    public void TC2_loginUserSuccessful() throws InterruptedException {
        homePage = new HomePage(driver);
        loginPage = homePage.openLoginPage();
        loginPage.login(email, password);
        homePage.usernameIsDisplay();
        Thread.sleep(2000);
        deleteAccountPage = homePage.deleteAccount();
        helper.closeGoogleAd();
        deleteAccountPage.deleteAccount();
    }


    @Test
    public void TC3_loginUserFailed() throws InterruptedException {
        homePage = new HomePage(driver);

        loginPage = homePage.openLoginPage();
        loginPage.login(emailInvalid, passwordInvalid);
        Assert.assertEquals(loginPage.getErrorLoginMessage(),"Your email or password is incorrect!","Error Message");
    }
}
