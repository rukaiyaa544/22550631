package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LoginPage extends BasePage {

    WebDriver driver;

    //constructor
    public LoginPage(WebDriver driver){
        super(driver);
    }

    //Locators
    @FindBy(xpath = "//input[@id='LoginEmail']")
    WebElement emailField;

    @FindBy(xpath = "//input[@id='LoginPassword']")
    WebElement passwordField;

    @FindBy(xpath = "//button[@class='loginbutton catfish-button']")
    WebElement loginBtn;

    @FindBy(xpath = "//button[@class='cookiebanner__accept cookiebanner-accept catfish-button']")
    WebElement acceptBanner;




    //Action Methods
    public void setLogin(String email, String password){
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        acceptBanner.click();
        loginBtn.click();
    }





}
