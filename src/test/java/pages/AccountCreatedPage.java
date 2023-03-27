package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.BasePage;

public class AccountCreatedPage extends BasePage {
    private WebDriver driver;
    By title = By.cssSelector(".title.text-center b");
    By continueButton = By.cssSelector(".btn.btn-primary");

    public AccountCreatedPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
    }
    public void veryfyAccountCreated()
    {
        Assert.assertEquals(getTextByLocator(title).toLowerCase(), ("ACCOUNT CREATED!").toLowerCase());
        clickElement(continueButton);
    }


}
