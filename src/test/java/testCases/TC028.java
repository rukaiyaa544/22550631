package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseTest;
import utilities.Responsiveness;

public class TC028 extends BaseTest {

    @Test(priority = 0, groups = {"TS006"})
    public void Resize() {

        logger.info("***  Starting TC0028 Test Case - Checking the Responsiveness  ***");
        try {

            Responsiveness res = new Responsiveness(driver);
            res.checkPageResponsiveness();

        } catch (Exception e) {
            logger.error("Test has Failed.....");
            logger.debug("Debug logs");
            Assert.fail();
        }
        logger.info("***  Finish TC028 Test Case  ***");
    }


    @Test(priority = 1, groups = {"TS006"})
    public void ResizeToMobile() {
        logger.info("***  Starting TC0028 Test Case - Resizing the screen to a Mobile device  ***");
        try {
            Responsiveness res = new Responsiveness(driver);
            res.resizeToDevice("Mobile");
        } catch (Exception e) {
            logger.error("Test has Failed.....");
            logger.debug("Debug logs");
            Assert.fail();
        }
        logger.info("***  Finish TC028 Test Case  ***");
    }

    @Test(priority = 2, groups = {"TS006"})
    public void ResizeToTablet() {
        logger.info("***  Starting TC0028 Test Case - Resizing the screen to a Tablet device  ***");
        try {
            Responsiveness res = new Responsiveness(driver);
            res.resizeToDevice("Tablet");
        } catch (Exception e) {
            logger.error("Test has Failed.....");
            logger.debug("Debug logs");
            Assert.fail();
        }
        logger.info("***  Finish TC028 Test Case  ***");
    }


    @Test(priority = 3, groups = {"TS006"})
    public void ResizeToLaptop() {
        logger.info("***  Starting TC0028 Test Case - Resizing the screen to a Laptop device  ***");
        try {
            Responsiveness res = new Responsiveness(driver);
            res.resizeToDevice("Laptop");
        } catch (Exception e) {
            logger.error("Test has Failed.....");
            logger.debug("Debug logs");
            Assert.fail();
        }
        logger.info("***  Finish TC028 Test Case  ***");
    }




        @Test(priority = 4, groups = {"TS006"})
        public void TC028_ResizeToDesktop () {
            logger.info("***  Starting TC0028 Test Case - Resizing the screen to a Desktop device  ***");
            try {
                Responsiveness res = new Responsiveness(driver);
                res.resizeToDevice("Desktop");
            } catch (Exception e) {
                logger.error("Test has Failed.....");
                logger.debug("Debug logs");
                Assert.fail();
            }
            logger.info("***  Finish TC028 Test Case  ***");
        }



    }
