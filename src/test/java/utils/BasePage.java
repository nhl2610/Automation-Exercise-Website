package utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Random;

public class BasePage extends Helper {
    private WebDriver driver;
    private Actions action;
    private WebDriverWait wait;
    private JavascriptExecutor js;
    private final int timeoutWaitForPageLoaded = 20;
    public BasePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
        js = (JavascriptExecutor) driver;
        action = new Actions(driver);
    }
    public void setText(By locator, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }
    public String getTextByLocator(By locator) {
        return driver.findElement(locator).getText();
    }

    public boolean isDisplayed(By locator) {
        return driver.findElement(locator).isDisplayed();
    }
    public void clickElement(By element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();
    }
    public void selectOptionByText(By locator, String text) {
        Select select = new Select(driver.findElement(locator));
        select.selectByVisibleText(text);
    }
    public void selectOptionByValue(By locator, String value) {
        Select select = new Select(driver.findElement(locator));
        select.selectByValue(value);
    }
    public void selectOptionByIndex(By locator, int index) {
        Select select = new Select(driver.findElement(locator));
        select.selectByIndex(index);
    }
    public void clickElementByJS(By element) {
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(element));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        js.executeScript("arguments[0].click();", driver.findElement(element));
    }
    public void srollToElement(By locator) {
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(locator));
    }
    public void waitForPageToLoad() {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            }
        };
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeoutWaitForPageLoaded);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for page to load failed");
        }
    }
    public void hoverAndClick(WebElement elementToHover, WebElement elementToClick){
        wait.until(ExpectedConditions.visibilityOf(elementToHover));
        js.executeScript("arguments[0].scrollIntoView(true);", elementToHover);
        action.moveToElement(elementToHover).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(elementToClick));
        elementToClick.click();
    }
    public String currentURL(){
        return driver.getCurrentUrl();
    }
    public void hoverElement(By elementToHover) {
        action.moveToElement(driver.findElement(elementToHover)).perform();
    }

}
