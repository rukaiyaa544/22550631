package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CardsPage;
import pageObjects.HomePage;
import pageObjects.ProductPage;
import testBase.BaseTest;

import java.time.Duration;

public class TC015 extends BaseTest {

    @Test (groups = {"TS004"})
    public void ClickOnAProduct(){
        logger.info("***  Starting TC015 Test Case  ***");
        try{
        HomePage hp = new HomePage(driver);
        hp.productCards();

        CardsPage card = new CardsPage(driver);
        card.setAcceptBanner();
        card.clickProduct(5);


    } catch(Exception e){
            logger.error("Test has Failed.....");
            logger.debug("Debug logs");
            Assert.fail();
        }   logger.info("***  Finish TC015 Test Case  ***");
}


    }
