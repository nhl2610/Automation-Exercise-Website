package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BasePage;

public class TestCasePage extends BasePage {

    By pageTitle = By.xpath("//h2[@class='title text-center']/b");
    public TestCasePage(WebDriver driver)
    {
        super(driver);
    }

    public String getPageTitle()
    {
        return getTextByLocator(pageTitle);
    }
}
