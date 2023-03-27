package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.BasePage;

public class LoginPage extends BasePage {
    private WebDriver driver;

    By signUpTile = By.cssSelector("div[class='signup-form'] h2");
    By loginTile = By.cssSelector("div[class='login-form'] h2");
    By signupButton = By.xpath("//button[normalize-space()='Signup']");
    By nameSignupInput = By.xpath("//input[@placeholder='Name']");
    By emailSignupInput = By.xpath("//input[@data-qa='signup-email']");
    By loginEmailInput = By.xpath("//input[@data-qa='login-email']");
    By loginPasswordInput = By.xpath("//input[@placeholder='Password']");
    By loginButton = By.xpath("//button[normalize-space()='Login']");
    By errorLoginMessage = By.cssSelector(".login-form p");
    By errorSignUpMessage = By.cssSelector(".signup-form p");

    public LoginPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
    }
    public SignupPage signUp(String name, String email)
    {
        Assert.assertEquals(getTextByLocator(signUpTile).toLowerCase(),"new user signup!","Tilte Sign Up");
        setText(nameSignupInput,name);
        setText(emailSignupInput,email);
        clickElement(signupButton);

        return new SignupPage(driver);
    }
    public void login(String email, String password)
    {
        Assert.assertEquals(getTextByLocator(loginTile).toLowerCase(),"login to your account","Tilte Sign Up");
        setText(loginEmailInput,email);
        setText(loginPasswordInput,password);
        clickElement(loginButton);
    }
    public String getErrorLoginMessage()
    {
        return getTextByLocator(errorLoginMessage);
    }
    public String getErrorSignUpMessage()
    {
        return getTextByLocator(errorSignUpMessage);
    }
}
