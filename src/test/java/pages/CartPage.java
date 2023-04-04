package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BasePage;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {
    WebDriver driver;
    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    By productsLink = By.xpath("//a[contains(@href,'/product_details')]");
    By productsPrice = By.xpath("//td[@class='cart_price']/p");
    By productsQuantity = By.xpath("//button[@class='disabled']");
    By productsTotalPrice = By.xpath("//p[@class='cart_total_price']");
    By breadcrumbsLable = By.xpath("//div[@class='breadcrumbs']");
    By checkoutButton = By.xpath("//a[@class='btn btn-default check_out']");
    By registerLoginButton = By.xpath("//u[normalize-space()='Register / Login']");
    By removeProductButton = By.xpath("//a[@class='cart_quantity_delete']");

    public boolean verifyProductInList (String productId)
    {
        boolean flag = false;
        List<WebElement> listProductLink = driver.findElements(productsLink);
        for (WebElement link : listProductLink)
        {
            if(link.getAttribute("href").contains(productId)) flag = true;
        }
        return flag;
    }
    public boolean verifyProductNameList (String productName)
    {
        boolean flag = true;
        List<WebElement> listProductLink = driver.findElements(productsLink);
        for (WebElement link : listProductLink)
        {
            if(!link.getText().contains(productName)) flag = false;
        }
        return flag;
    }
    public boolean verifyTotalPrice()
    {
        boolean flag = true;
        List<WebElement> listProductPrice = driver.findElements(productsPrice);
        List<WebElement> listProductQuantity = driver.findElements(productsQuantity);
        List<WebElement> listProductTotal = driver.findElements(productsTotalPrice);
        for(int i=0; i<listProductPrice.size(); i++)
        {
            int price = Integer.parseInt(listProductPrice.get(i).getText().substring(4));
            int total = Integer.parseInt(listProductTotal.get(i).getText().substring(4));
            int quantity = Integer.parseInt(listProductQuantity.get(i).getText());
            System.out.println(price + " * " + quantity + " = " + total);
            if(price*quantity != total) return false;
        }
        return flag;
    }
    public String getQuantityOfProduct(String productId) {
        List<WebElement> listProductQuantity = driver.findElements(productsQuantity);
        List<WebElement> listProductLink = driver.findElements(productsLink);
        for (int i = 0; i < listProductQuantity.size(); i++) {
            System.out.println(listProductLink.get(i).getAttribute("href").substring(47));
            if (listProductLink.get(i).getAttribute("href").substring(47).equals(productId))
                return listProductQuantity.get(i).getText();
        }
        return "0";
    }
    public boolean verifyThatCartPageIsDisplayed()
    {
        return isDisplayed(breadcrumbsLable);
    }
    public LoginPage goToLoginPage()
    {
        clickElement(checkoutButton);
        clickElement(registerLoginButton);
        return new LoginPage(driver);
    }
    public CheckoutPage goToCheckoutPage()
    {
        clickElement(checkoutButton);
        return new CheckoutPage(driver);
    }
    public void removeFirstProduct()
    {
        List<WebElement> list = driver.findElements(removeProductButton);
        list.get(0).click();
    }
    public void removeAllProduct()
    {
        List<WebElement> list = driver.findElements(removeProductButton);
        for (WebElement element : list)
        {
            element.click();
        }
    }
    public boolean verifyCartEmpty(){
        return driver.findElements(removeProductButton).size() == 0;
    }

}
