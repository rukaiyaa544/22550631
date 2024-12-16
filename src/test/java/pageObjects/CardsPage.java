package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.Random;

import java.util.List;

public class CardsPage extends BasePage {

    WebDriver driver;

    //constructor
    public CardsPage(WebDriver driver) {
        super(driver);
    }



    //Locators
    @FindBy(xpath = "//a[@class='button is-small is-secondary '][normalize-space()='Antonio Gouveia']")
    WebElement AntonioGouveia;

    @FindBy(xpath = "//a[@class='button is-small is-secondary '][normalize-space()='Bodneyboo']")
    WebElement Bodneyboo;

    @FindBy(xpath = "//a[@class='button is-small is-secondary '][normalize-space()='Fraser Havenhand']")
    WebElement FraserHavenhand;

    @FindBy(xpath = "//a[@class='button is-small is-secondary '][normalize-space()='Ileana Oakley']")
    WebElement IleanaOakley;

    @FindBy(xpath = "//a[@class='button is-small is-secondary '][normalize-space()='Jane Bristowe']")
    WebElement JaneBristowe;

    @FindBy(xpath = "//a[@class='button is-small is-secondary '][normalize-space()='Jesse Grylls']")
    WebElement JesseGrylls;

    @FindBy(xpath = "//a[@class='button is-small is-secondary '][normalize-space()='Martin Lore']")
    WebElement MartinLore;

    @FindBy(xpath = "//a[@class='button is-small is-secondary '][normalize-space()='Mike Thomas']")
    WebElement MikeThomas;


    @FindBy(xpath = "//button[@class='cookiebanner__accept cookiebanner-accept catfish-button']")
    WebElement acceptBanner;









    //Action Methods
    public void setAntonioGouveia(){
        AntonioGouveia.click();
    }

    public void setBodneyboo(){
        Bodneyboo.click();
    }

    public void setFraserHavenhand(){
        FraserHavenhand.click();
    }

    public void setIleanaOakley(){
        IleanaOakley.click();
    }

    public void setJaneBristowe(){
        JaneBristowe.click();
    }

    public void setJesseGrylls(){
        JesseGrylls.click();
    }

    public void setMartinLore(){
        MartinLore.click();
    }

    public void setMikeThomas(){
        MikeThomas.click();
    }


    public void setAcceptBanner(){
        acceptBanner.click();
    }




    public void clickThirdProduct() {
        if (driver == null) {
            System.err.println("Driver is not initialized.");
            return;
        }

        // Locate all search result product containers
        List<WebElement> searchResults = driver.findElements(By.xpath("//div[@class='container']//div[@class='product-grid']//div[@id='Edod6xXlVn']"));

        if (searchResults.size() < 3) {
            System.out.println("Less than three products found in the search results.");
            return;
        }

        try {
            // Find the third product's clickable anchor and click it
            WebElement thirdProduct = searchResults.get(2);
            thirdProduct.click();
            System.out.println("Clicked on the third product successfully.");
        } catch (Exception e) {
            System.err.println("Failed to click on the third product: " + e.getMessage());
        }
    }


    public void clickProduct(Integer itemNumber) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //List<WebElement> searchResults = driver.findElements(By.xpath("//div[@class='container']//div[@class='product-grid']//div[@id='wv1IMV6Q25']"));
        List<WebElement> searchResults = driver.findElements(By.xpath("//div[@class='container']//div[@class='product-grid']//div[contains(@class,'listWrapper')]"));

        if (itemNumber < 0 || itemNumber >= searchResults.size()) {
            System.err.println("Invalid item number: " + itemNumber);
            return;
        }

        WebElement product = searchResults.get(itemNumber);
        product.click();
        System.out.println("Clicked on product number: " + itemNumber);
    }








}


