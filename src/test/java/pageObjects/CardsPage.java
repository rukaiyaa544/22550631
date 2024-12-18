package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Scroll;

import java.time.Duration;

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





        public void clickProduct(int productIndex) {
            try {
                // Wait for the product grid to load
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                List<WebElement> searchResults = wait.until(
                        ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='listWrapper columns is-mobile is-multiline clearfix']//div[contains(@class,'listItem')]"))
                );

                // Validate the product index
                if (productIndex < 1 || productIndex > searchResults.size()) {
                    System.err.println("Invalid product index: " + productIndex + ". Total products found: " + searchResults.size());
                    return;
                }

                // Get the product at the specified index (adjust for 0-based indexing)
                WebElement targetProduct = searchResults.get(productIndex - 1);

                // Wait for the product to be clickable
                wait.until(ExpectedConditions.elementToBeClickable(targetProduct));

                // Scroll to the product if necessary
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", targetProduct);

                // Use Actions class to ensure reliable clicking
                Actions actions = new Actions(driver);
                actions.moveToElement(targetProduct).pause(Duration.ofMillis(500)).click(targetProduct).perform();

                System.out.println("Successfully clicked on product at index " + productIndex + ".");
            } catch (TimeoutException e) {
                System.err.println("Search results did not load within the specified time: " + e.getMessage());
            } catch (ElementClickInterceptedException e) {
                System.err.println("Failed to click the product due to an overlay or obstruction: " + e.getMessage());
            } catch (NoSuchElementException e) {
                System.err.println("The specified product was not found: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("An unexpected error occurred while clicking the product: " + e.getMessage());
            }
        }



}






