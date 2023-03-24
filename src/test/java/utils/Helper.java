package utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class Helper {
    private WebDriver driver;
    public Helper(WebDriver driver) {
        this.driver = driver;
    }

    //Random 1 to total
    public int randomNumber(int low, int high) {
        Random rand = new Random();
        return rand.nextInt(high-low) + low;
    }

    public String generatingRandomString(int length) {
//        boolean useLetters = true;
//        boolean useNumbers = false;
//        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);

        return RandomStringUtils.random(length,true, true);
    }

    public void closeGoogleAd()
    {
        if(driver.getCurrentUrl().contains("#google_vignette"))
        {
            //System.out.println(driver.findElements(By.xpath("/html/ins/div/iframe")).size());
            WebElement iframe = driver.findElement(By.xpath("/html/ins/div/iframe"));

            driver.switchTo().frame(iframe);

            if (driver.findElements(By.id("dismiss-button")).size() > 0) {
                driver.findElement(By.id("dismiss-button")).click();
            } else {
                driver.switchTo().frame("ad_iframe");
                driver.findElement(By.id("dismiss-button")).click();
            }
            driver.switchTo().defaultContent();
        }
    }
}
