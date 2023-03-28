package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BasePage;

import java.util.List;

public class CategoryPage extends BasePage {
    WebDriver driver;
    By leftSidebarTitle = By.xpath("//h2[normalize-space()='Category']");
    By categories = By.xpath("//h4[contains(@class,'panel-title')]//a");
    By subCategories = By.xpath("//div[contains(@class,'category-products')]//div[contains(@class,'panel-collapse')]//a");
    By categoryTitle = By.xpath("//h2[@class='title text-center']");

    public CategoryPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public boolean verifyThatCategoryAreVisibleOnLeft() {
        Point location = driver.findElement(leftSidebarTitle).getLocation();
        int x = driver.manage().window().getSize().width;
        if(location.getX() < x/3)
        {
            return true;
        }
        else {
            return false;
        }
    }

    public void clickCategory(String menu, String subMenu) throws Exception {
        List<WebElement> listCategories = driver.findElements(categories);
        List<WebElement> listSubCategories = driver.findElements(subCategories);
        for (WebElement element : listCategories)
        {
            if(element.getText().toLowerCase().equals(menu.toLowerCase()))
            {
                hoverAndClick(element,element);
                Thread.sleep(2000);
                for (WebElement element2 : listSubCategories)
                {
                    System.out.println(element2.getText());
                    if(element2.getText().contains(subMenu)) {
                        System.out.println("gbiugiu");
                        element2.click();
                        break;
                    }
                }
                break;
            }
        }
    }

    public String getCategoryTitle()
    {
        return getTextByLocator(categoryTitle);
    }
}
