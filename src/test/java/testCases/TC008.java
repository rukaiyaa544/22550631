package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import testBase.BaseTest;

public class TC008 extends BaseTest {

    @Test (groups = {"TS002"})
    public void Search4(){
        logger.info("***  Starting TC008 Test Case  ***");
        try {
            HomePage hp = new HomePage(driver);
            hp.search("wireless mouse@2023");

            WebElement myAccount = driver.findElement(By.xpath("//h1[text()='Search']"));
            Assert.assertFalse(myAccount.isDisplayed(), "Error in searching the item ");
        } catch(Exception e){
            logger.error("Test has Failed.....");
            logger.debug("Debug logs");
            Assert.fail();

        }
        logger.info("***  Finish TC008 Test Case  ***");

    }


}
