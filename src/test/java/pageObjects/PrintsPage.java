package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PrintsPage extends BasePage {

    WebDriver driver;

    //constructor
    public PrintsPage(WebDriver driver) {
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



}


