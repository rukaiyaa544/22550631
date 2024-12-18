package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import testBase.BaseTest;

public class TC006 extends BaseTest {

    @Test (groups = {"TS002"})
    public void Search2(){
        logger.info("***  Starting TC006 Test Case  ***");
        try {
            HomePage hp = new HomePage(driver);
            hp.search("christmas");

            WebElement myAccount = driver.findElement(By.xpath("//h1[text()='Search']"));
            Assert.assertTrue(myAccount.isDisplayed(), "Error in searching the item ");
        } catch(Exception e){
            logger.error("Test has Failed.....");
            logger.debug("Debug logs");
            Assert.fail();
        }   logger.info("***  Finish TC006 Test Case  ***");

    }


}
