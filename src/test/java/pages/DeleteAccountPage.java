package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.BasePage;

public class DeleteAccountPage extends BasePage {
    WebDriver driver;

    By title = By.cssSelector(".title.text-center b");
    By continueButton = By.cssSelector(".btn.btn-primary");

    public DeleteAccountPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
    }

    public void deleteAccount()
    {
        Assert.assertEquals(getTextByLocator(title).toUpperCase(),"ACCOUNT DELETED!");
        clickElement(continueButton);
    }
}
