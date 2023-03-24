package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BasePage;

public class ProductDetailPage extends BasePage {
    WebDriver driver;
    By productName = By.cssSelector("div[class='product-information'] h2");
    By productCategory = By.xpath("//p[contains(text(),'Category')]");
    By productPrice = By.xpath("//div[@class='product-information']/span/span");
    By productAvailability = By.xpath("//div[@class='product-details']//p[2]");
    By productCondition = By.xpath("//div[@class='product-details']//p[3]");
    By productBrand = By.xpath("//div[@class='product-details']//p[4]");
    By productQuantity = By.xpath("//input[@id='quantity']");
    By addToCartButton = By.xpath("//button[normalize-space()='Add to cart']");
    By viewCartButton = By.xpath("//div[@id='cartModal']//a");

    public ProductDetailPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
    }
    public String getPageTitle(){
        return driver.getTitle();
    }
    public boolean productDetailIsVisible(){
        return isDisplayed(productName)&&isDisplayed(productCategory)&&isDisplayed(productAvailability)
                &&isDisplayed(productBrand)&&isDisplayed(productPrice)&&isDisplayed(productCondition);
    }
    public void addProductToCart(String quantity)
    {
        setText(productQuantity, quantity);
        clickElement(addToCartButton);
    }
    public CartPage clickViewCartButton(){
        clickElement(viewCartButton);
        return new CartPage(driver);
    }
    public String getProductId()
    {
        return currentURL().substring(47);
    }
}
