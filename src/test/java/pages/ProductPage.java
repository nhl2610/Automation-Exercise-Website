package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BasePage;

import java.util.ArrayList;
import java.util.List;

public class ProductPage extends BasePage {
    WebDriver driver;
    By pageTitle = By.cssSelector(".title.text-center");
    By firstProduct = By.cssSelector("a[href='/product_details/1']");
    By searchInput = By.xpath("//input[@id='search_product']");
    By searchSubmitButton = By.xpath("//button[@id='submit_search']");
    By titleOfProducts = By.xpath("//div[@class='productinfo text-center']//p");
    By continueShoppingButton = By.xpath("//button[normalize-space()='Continue Shopping']");
    By viewCartButton = By.xpath("//div[@id='cartModal']//a");
    By productsInfoAddButton = By.xpath("//div[@class='productinfo text-center']/a");
    By productsOverlayAddButton = By.xpath("//div[@class='product-overlay']//a");
    public ProductPage  (WebDriver driver)
    {
        super(driver);
        this.driver = driver;
    }

    public String getPageTitle()
    {
        return getTextByLocator(pageTitle);
    }

    public ProductDetailPage goToFirstProductPage()
    {
        clickElement(firstProduct);
        return new ProductDetailPage(driver);
    }

    public void searchProduct(String search)
    {
        setText(searchInput,search);
        clickElement(searchSubmitButton);
    }
    public List<WebElement> getAllProductByLocator(By locator)
    {
        return driver.findElements(locator);
    }
    public List<String> getAllProductName()
    {
        List<WebElement> products = driver.findElements(titleOfProducts);
        List<String> result = new ArrayList<String>();
        for(WebElement product : products)
        {
            result.add(product.getText());
        }
        return result;
    }
    public void addProductToCart(String productId) throws Exception
    {
        List<WebElement> productsInfoAdd = driver.findElements(productsInfoAddButton);
        List<WebElement> productsOverlayAdd = driver.findElements(productsOverlayAddButton);
        for (int i=0; i<productsInfoAdd.size(); i++)
        {
            if(productsInfoAdd.get(i).getAttribute("data-product-id").equals(productId)) {
                hoverAndClick(productsInfoAdd.get(i), productsOverlayAdd.get(i));
            }
        }

    }
    public void clickContinueShoppingButton(){
        clickElement(continueShoppingButton);
    }
    public CartPage clickViewCartButton(){
        clickElement(viewCartButton);
        return new CartPage(driver);
    }
    public boolean verifyProductList(String productNameExpected)
    {
        List<String> result = getAllProductName();
        for(String productName : result)
        {
            if(!productName.contains(productNameExpected)) return false;
        }
        return true;
    }
}

