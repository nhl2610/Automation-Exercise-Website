package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BasePage;

import java.util.List;

public class BrandPage extends BasePage {
    WebDriver driver;
    By leftSidebarBrandTitle = By.cssSelector("div[class='brands_products'] h2");
    By brands = By.xpath("//a[contains(@href,'/brand_products/')]");

    By brandTitle = By.cssSelector(".title.text-center");
    public BrandPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public boolean verifyThatBrandAreVisibleOnLeft() {
        Point location = driver.findElement(leftSidebarBrandTitle).getLocation();
        int x = driver.manage().window().getSize().width;
        if(location.getX() < x/3)
        {
            return true;
        }
        else {
            return false;
        }
    }

    public void clickBrand(String brand) throws Exception {
        List<WebElement> listBrands = driver.findElements(brands);
        for (WebElement element : listBrands)
        {
            System.out.println("CLick brand" + brand);
            System.out.println(element.getText());

            if(element.getText().contains(brand))
            {
                hoverAndClick(element,element);
                System.out.println("CLick brand" + brand);
                break;
            }
        }
    }

    public String getBrandTitle()
    {
        return getTextByLocator(brandTitle);
    }
}
