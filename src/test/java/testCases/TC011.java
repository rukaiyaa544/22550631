package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CardsPage;
import pageObjects.HomePage;
import pageObjects.PrintsPage;
import testBase.BaseTest;

public class TC011 extends BaseTest {

    @Test (groups = {"TS003"})
    public void SelectArtist2() {
        logger.info("***  Starting TC011 Test Case  ***");
        try {
            HomePage hp = new HomePage(driver);
            hp.productPrints();

            PrintsPage product = new PrintsPage(driver);
            product.setAntonioGouveia();
            product.setBodneyboo();
            product.setFraserHavenhand();
            product.setIleanaOakley();
            product.setJaneBristowe();
            product.setJesseGrylls();
            product.setMartinLore();
            product.setMikeThomas();

            WebElement myAccount = driver.findElement(By.xpath("//span[text()='Prints by Artist']"));
            Assert.assertTrue(myAccount.isDisplayed(), "Error in searching the Print ");

        } catch (Exception e) {
            logger.error("Test has Failed.....");
            logger.debug("Debug logs");
            Assert.fail();
        }
        logger.info("***  Finish TC011 Test Case  ***");
    }


    }
