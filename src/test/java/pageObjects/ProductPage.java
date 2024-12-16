package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    WebDriver driver;

    //constructor
    public ProductPage(WebDriver driver) {
        super(driver);
    }


    //Locators
    @FindBy(xpath = "//input[@value='Add to basket']")
    WebElement addToBasket;

    @FindBy(xpath = "//div[@class='product__quantity']//input[contains(@id,'itemquantity')]")
    WebElement increment;

    @FindBy(xpath = "//input[@id='deleteCartItem']")
    WebElement deleteCart;





    //Action Methods
    public void setAddToBasket() {
        addToBasket.click();
    }

    public void setIncrement(Integer q) {
        increment.clear();
        increment.sendKeys(q.toString());
    }

    public void setDeletCart (){
        deleteCart.click();
    }
}