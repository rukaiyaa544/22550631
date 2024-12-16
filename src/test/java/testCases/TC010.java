package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.CardsPage;
import testBase.BaseTest;

public class TC010 extends BaseTest {

    @Test
    public void Login(){
        logger.info("***  Starting TC010 Test Case  ***");
        try {
            HomePage hp = new HomePage(driver);
            hp.productCards();

            CardsPage product = new CardsPage(driver);
            product.setAntonioGouveia();
            product.setBodneyboo();
            product.setFraserHavenhand();
            product.setIleanaOakley();
            product.setJaneBristowe();
            product.setJesseGrylls();
            product.setMartinLore();
            product.setMikeThomas();

            WebElement myAccount = driver.findElement(By.xpath("//span[text()='Cards by Artist']"));

            Assert.assertTrue(myAccount.isDisplayed(), "Error in searching the Card ");
        } catch(Exception e){
            logger.error("Test has Failed.....");
            logger.debug("Debug logs");
            Assert.fail();
        }   logger.info("***  Finish TC010 Test Case  ***");



    }
}
