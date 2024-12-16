package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    WebDriver driver;

    //constructor
    public CartPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    @FindBy(xpath = "//span[@class='a-icon a-icon-small-add']")
    WebElement incrementItem;

    @FindBy(xpath = "//span[@class='a-icon a-icon-small-remove']")
    WebElement decrementItem;


    //Action Methods

    public void setIncrementItem(){
        incrementItem.click();
    }

    public void setDecrementItem(){
        decrementItem.click();
    }

}

