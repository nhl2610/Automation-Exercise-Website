package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.BasePage;

import java.time.Year;

public class SignupPage extends BasePage {
    private WebDriver driver;
    //private Helper helper;

    By title = By.xpath("(//h2[@class='title text-center']/b)[1]");
    By passwordInput = By.xpath("//input[@id='password']");
    By daySelect = By.xpath("//select[@id='days']");
    By monthSelect = By.xpath("//select[@id='months']");
    By yearSelect = By.xpath("//select[@id='years']");
    By gender1 = By.xpath("//input[@id='id_gender1']");
    By gender2 = By.xpath("//input[@id='id_gender2']");

    By newletterCheckbox = By.xpath("//input[@id='newsletter']");
    By optinCheckbox = By.xpath("//input[@id='optin']");
    By firstname = By.xpath("//input[@id='first_name']");
    By lastname = By.xpath("//input[@id='last_name']");
    By company = By.xpath("//input[@id='company']");
    By address1 = By.xpath("//input[@id='address1']");
    By address2 = By.xpath("//input[@id='address2']");
    By countrySelect = By.xpath("//select[@id='country']");
    By state = By.xpath("//input[@id='state']");
    By city = By.xpath("//input[@id='city']");
    By zipcode = By.xpath("//input[@id='zipcode']");
    By mobilenumber = By.xpath("//input[@id='mobile_number']");
    By createButton = By.xpath("//button[normalize-space()='Create Account']");


    public SignupPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
    }
    public AccountCreatedPage signUp()
    {
        Assert.assertEquals(getTextByLocator(title).toLowerCase(),("Enter Account Information").toLowerCase(),"Title");
        int gender = randomNumber(1,2);
        if(gender == 1)
        {
            clickElement(gender1);
        }   else clickElement(gender2);
        String password = "123456";
//        System.out.println("Password: " + password);
        setText(passwordInput,password);
        selectOptionByValue(daySelect, Integer.toString(randomNumber(1,30)));
        selectOptionByValue(monthSelect, Integer.toString(randomNumber(1,11)));
        selectOptionByValue(yearSelect, Integer.toString(randomNumber(1900, Year.now().getValue())));
        clickElement(newletterCheckbox);
        clickElement(optinCheckbox);
        setText(firstname,generatingRandomString(16));
        setText(lastname,generatingRandomString(16));
        setText(company,generatingRandomString(16));
        setText(address1,generatingRandomString(16));
        setText(address2,generatingRandomString(16));
        selectOptionByIndex(countrySelect,randomNumber(1,7));
        setText(state,generatingRandomString(16));
        setText(city,generatingRandomString(16));
        setText(zipcode,randomNumberString(6));
        setText(mobilenumber,randomNumberString(10));
        clickElement(createButton);

        return new AccountCreatedPage(driver);
    }

}
