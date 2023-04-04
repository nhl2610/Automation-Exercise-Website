package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.BaseTest;
import utils.Helper;
import utils.PropertiesFile;

public class RegisterUserTest extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;
    SignupPage signupPage;
    DeleteAccountPage deleteAccountPage;
    AccountCreatedPage accountCreatedPage;
    Helper helper;
    PropertiesFile propertiesFile;
    String name = "nhl";
    String emailAddress = "nhl12@gmail.com";
    @Test
    public void TC1_registerUser() throws InterruptedException {
        helper = new Helper(driver);
        homePage = new HomePage(driver);
        loginPage = homePage.openLoginPage();
        signupPage = loginPage.signUp(name,emailAddress);
        accountCreatedPage = signupPage.signUp();
        Thread.sleep(2000);
        accountCreatedPage.veryfyAccountCreated();
        helper.closeGoogleAd();
        homePage.usernameIsDisplay();
        deleteAccountPage = homePage.deleteAccount();
        Thread.sleep(10000);
        deleteAccountPage.deleteAccount();
    }
    @Test
    public void TC5_registerUserWithExistingEmail()
    {

        String emailAddress = propertiesFile.getPropValue("/src/test/resources/testdata/user.properties","email");
        homePage = new HomePage(driver);
        loginPage = homePage.openLoginPage();
        loginPage.signUp("nhl",emailAddress);
        Assert.assertEquals(loginPage.getErrorSignUpMessage(),"Email Address already exist!");
    }
}