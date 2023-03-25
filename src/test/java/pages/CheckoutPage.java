package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utils.BasePage;

public class CheckoutPage extends BasePage {
    WebDriver driver;
    By descriptionTextarea = By.xpath("//textarea[@name='message']");
    By placeOrderButton = By.xpath("//a[@class='btn btn-default check_out']");
    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public PaymentPage placeOrder()
    {
        setText(descriptionTextarea,"Description text ");
        clickElement(placeOrderButton);
        return new PaymentPage(driver);
    }
}
