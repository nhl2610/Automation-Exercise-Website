package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    private static final String browserType = "chrome";
    private static final String appURL = "https://automationexercise.com/";

    @BeforeSuite
    public void startDriver() throws Exception {
        switch (browserType) {
            case "chrome":
                driver = initChromeDriver();
                break;
            case "firefox":
                driver = initFirefoxDriver();
                break;
            case "edge":
                driver = initEdgeDriver();
                break;
            case "ie":
                driver = initInternetExploreDriver();
                break;
            default:
                System.out.println("Browser: " + browserType + " is invalid, Launching Chrome as browser of choice...");
                driver = initChromeDriver();
        }

        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
        //driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.MILLISECONDS);

        driver.navigate().to(appURL);
    }

    @AfterSuite
    public void tearsDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
    private WebDriver initChromeDriver() {
        System.out.println("Launching Chrome browser...");
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-notifications");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
    }
    private WebDriver initFirefoxDriver() {
        System.out.println("Launching Fire Fox browser...");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        return driver;
    }
    private WebDriver initInternetExploreDriver() {
        System.out.println("Launching Internet Explore browser...");
        WebDriverManager.iedriver().setup();
        driver = new InternetExplorerDriver();
        return driver;
    }
    private WebDriver initEdgeDriver() {
        System.out.println("Launching Edge browser...");
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        return driver;
    }

}
