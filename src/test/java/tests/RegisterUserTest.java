package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.BaseTest;
import utils.Helper;

public class RegisterUserTest extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;
    SignupPage signupPage;
    DeleteAccountPage deleteAccountPage;
    AccountCreatedPage accountCreatedPage;
    Helper helper;
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
/*
        Get element in frame by ID
        List<WebElement> frames = driver.findElements(By.tagName("iframe"));
        Switch to frame with element
        driver.switchTo().frame(frame1);
        Check button X or Close displays
        for(int i=0; i<frames.size(); i++)
        {
            driver.switchTo().frame(i);
            List<WebElement> checkButtonX = driver.findElements(By.xpath("//div[@id='dismiss-button']"));
            System.out.println("checkButtonX: " + checkButtonX.size());
            if (checkButtonX.size() > 0) {
                driver.findElement(By.xpath("//div[@id='dismiss-button']")).click();
                driver.switchTo().defaultContent();
                break;
            }
            driver.switchTo().defaultContent();
        }
        */

        homePage.usernameIsDisplay();
        deleteAccountPage = homePage.deleteAccount();
        Thread.sleep(10000);
        deleteAccountPage.deleteAccount();
    }
    String registeredName = "nhl1";
    String registeredEmailAddress = "nhl13@gmail.com";
    @Test
    public void TC5_registerUserWithExistingEmail()
    {
        homePage = new HomePage(driver);
        loginPage = homePage.openLoginPage();
        loginPage.signUp(registeredName,registeredEmailAddress);
        Assert.assertEquals(loginPage.getErrorSignUpMessage(),"Email Address already exist!");
    }
}