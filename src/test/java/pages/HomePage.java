package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.BasePage;
import utils.Helper;

import java.util.List;

public class HomePage extends BasePage {
    private WebDriver driver;
    Helper helper;
    By loginLink = By.xpath("//a[normalize-space()='Signup / Login']");
    By logoutLink = By.xpath("//a[normalize-space()='Logout']");
    By contactLink = By.xpath("//a[normalize-space()='Contact us']");
    By testCasePageLink = By.xpath("//a[normalize-space()='Test Cases']");
    By deleteAccountLink = By.xpath("//a[normalize-space()='Delete Account']");
    By productLink = By.xpath("//a[@href='/products']");
    By cartLink = By.xpath("//a[@href='/view_cart']");

    By username = By.xpath("//i[@class='fa fa-user']//parent::a");
    By footerTitle = By.cssSelector("div[class='single-widget'] h2");
    By susbscribe_email = By.xpath("//input[@id='susbscribe_email']");
    By susbscribe_button = By.xpath("//button[@id='subscribe']");
    By alert_success_subscibe = By.xpath("//div[@class='alert-success alert']");
    By viewProductButtons = By.xpath("//a[contains(@href,'/product_details')]");

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public LoginPage openLoginPage() {
        clickElement(loginLink);
        return new LoginPage(driver);
    }
    public CartPage openCartPage() {
        clickElement(cartLink);
        return new CartPage(driver);
    }

    public TestCasePage openTestCasePage() throws Exception {

        clickElement(testCasePageLink);
        Thread.sleep(2000);
        closeGoogleAd();
        Assert.assertTrue(driver.getCurrentUrl().contains("test_cases"), "Page not match");
        return new TestCasePage(driver);
    }

    public ProductPage openProductPage() {
        clickElement(productLink);
        return new ProductPage(driver);
    }

    public ContactPage openContactPage() {
        clickElement(contactLink);
        return new ContactPage(driver);
    }

    public void logout() {
        clickElement(logoutLink);
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "Page not match");
    }

    public DeleteAccountPage deleteAccount() {
        clickElement(deleteAccountLink);
        return new DeleteAccountPage(driver);
    }

    public void usernameIsDisplay() {
        Assert.assertTrue(getTextByLocator(username).contains("Logged in as "));
    }

    public String getFooterTitle() {
        srollToElement(footerTitle);
        return getTextByLocator(footerTitle);
    }

    public void sendEmailSubscription(String email) {
        setText(susbscribe_email, email);
        clickElement(susbscribe_button);
    }

    public String getAlertSuccessSubscibe() {
        return getTextByLocator(alert_success_subscibe);
    }

    public List<WebElement> getAllProductByLocator(By locator) {
        return driver.findElements(locator);
    }

    public ProductDetailPage goToAnyProductPage() {
        helper = new Helper(driver);
        List<WebElement> products = getAllProductByLocator(viewProductButtons);
        int randomNumber = helper.randomNumber(1,products.size());
        products.get(randomNumber).click();
        return new ProductDetailPage(driver);
    }

}
