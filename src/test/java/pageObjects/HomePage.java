package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    // Constructor
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this); // Initialize the web elements
    }

    // Locators
    @FindBy(xpath = "//a[@name='Login']")
    WebElement loginLink;

    @FindBy(xpath = "//i[@class='fas fa-search']")
    WebElement searchIcon;

    @FindBy(xpath = "//input[@id='small-searchterms']")
    WebElement searchField;

    @FindBy(xpath = "//input[@id='btn-small-search']")
    WebElement goBtn;

    @FindBy(xpath = "//a[normalize-space()='Products']")
    WebElement products;

    @FindBy(xpath = "//a[normalize-space()='Cards']")
    WebElement cards;

    @FindBy(xpath = "//a[normalize-space()='Prints']")
    WebElement prints;


    @FindBy(xpath = "//a[@name='My Account']")
    WebElement myAccount;








    // Action Methods
    public void navigateToLoginPage() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        loginLink.click();
    }


    public void search(String productName){
        searchIcon.click();
        searchField.sendKeys(productName);
        goBtn.click();

    }

    public void productCards(){
        Actions actions = new Actions(driver);
        actions.moveToElement(products).perform();
        cards.click();

    }

    public void productPrints(){
        Actions actions = new Actions(driver);
        actions.moveToElement(products).perform();
        prints.click();

    }


    public void goToMyAccount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);
        WebElement myAccountElement = wait.until(ExpectedConditions.elementToBeClickable(myAccount));
        actions.moveToElement(myAccountElement).click().perform();

    }





}

