package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import testBase.BaseTest;

public class TC005 extends BaseTest {

    @Test (groups = {"TS002"})
    public void TC005_Search1(){
        logger.info("***  Starting TC005 Test Case  ***");
        try {
            HomePage hp = new HomePage(driver);
            hp.search("Christmas Cards for the Holidays");

            WebElement myAccount = driver.findElement(By.xpath("//h1[text()='Search']"));
            Assert.assertTrue(myAccount.isDisplayed(), "Error in searching the item ");
        } catch(Exception e){
            logger.error("Test has Failed.....");
            logger.debug("Debug logs");
            Assert.fail();

        }
        logger.info("***  Finish TC005 Test Case  ***");

    }


}
