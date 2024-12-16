package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.BasePage;

import java.time.Duration;

public class Logout extends BasePage {


    // Constructor
    public Logout(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//a[@name='My Account']")
    WebElement myAccount;

    @FindBy(xpath = "//a[@name='Logout']")
    WebElement logout;



    public void logout(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Actions actions = new Actions(driver);
        actions.moveToElement(myAccount).perform();
        actions.moveToElement(logout).click().perform();

    }


}
