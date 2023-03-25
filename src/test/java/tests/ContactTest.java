package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactPage;
import pages.HomePage;
import utils.BaseTest;

public class ContactTest extends BaseTest {

    HomePage homePage;
    ContactPage contactPage;

    @Test
    public void TC6_userCanSendContact() throws Exception {
        homePage = new HomePage(driver);
        contactPage = homePage.openContactPage();

//        System.out.println(contactPage.getTitlePage());
        Assert.assertEquals(contactPage.getTitlePage(),"GET IN TOUCH","Contact title should be GET IN TOUCH");
        contactPage.sendContact("nhl","nhl@gmail.com","contact","content message");

        Assert.assertTrue(contactPage.getAlertStatus().contains("Success! Your details have been submitted successfully"));

        contactPage.goToHomePage();
    }

    @FindBy(xpath ="//div[@class='contact-form']/h2[@class='title text-center']")
     WebElement contactTitle;

    @Test
    public void test()
    {
        driver.get("https://www.automationexercise.com/contact_us");
        System.out.println(contactTitle.getText());
    }
}
