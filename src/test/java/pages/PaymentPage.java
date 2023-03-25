package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BasePage;

public class PaymentPage extends BasePage {
    WebDriver driver;
    By nameOnCartInput = By.xpath("//input[@name='name_on_card']");
    By cardNumberInput = By.xpath("//input[@name='card_number']");
    By cvcInput = By.xpath("//input[@name='cvc']");
    By expiryMonthInput = By.xpath("//input[@name='expiry_month']");
    By expiryYearInput = By.xpath("//input[@name='expiry_year']");
    By alertSucces = By.xpath("//div[@id='success_message']//div[@class='alert-success alert']");
    public PaymentPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public void payAndConfirmOrder()
    {
        setText(nameOnCartInput,"NHL");
        setText(cardNumberInput,"123456");
        setText(cvcInput,"313");
        setText(expiryMonthInput,"12");
        setText(expiryYearInput,"2025");
    }
    public boolean verifySeccessMessage()
    {
        return getTextByLocator(alertSucces).contains("Your order has been placed successfully");
    }

}
