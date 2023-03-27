package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BasePage;

public class ContactPage extends BasePage {
    By contactTitle = By.xpath("//div[@class='contact-form']/h2[@class='title text-center']");
    By nameInput = By.xpath("//input[@name='name']");
    By emailInput = By.xpath("//input[@name='email']");
    By subjectInput = By.xpath("//input[@name='subject']");
    By textArea = By.xpath("//textarea[@id='message']");
    By uploadFileButton = By.xpath("//input[@name='upload_file']");
    By submitButton = By.xpath("//input[@name='submit']");
    By alertStatus = By.xpath("//div[@class='status alert alert-success']");
    By homeButton = By.xpath("//a[@class='btn btn-success']");

    WebDriver driver;
    public ContactPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public String getTitlePage()
    {
        return getTextByLocator(contactTitle);
    }
    public String getAlertStatus()
    {
        return getTextByLocator(alertStatus);
    }
    public void sendContact(String name,String email,String subject,String message)
    {
        setText(nameInput,name);
        setText(emailInput,email);
        setText(subjectInput,subject);
        setText(textArea,message);

        setText(uploadFileButton,System.getProperty("user.dir") + "/src/test/resources/testdata/user.xlsx");

        clickElement(submitButton);
        driver.switchTo().alert().accept();
    }
    public void goToHomePage() {
        clickElement(homeButton);
    }

}
