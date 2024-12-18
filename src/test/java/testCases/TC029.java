package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.BaseTest;
import utilities.Scroll;

public class TC029 extends BaseTest {

    @Test(priority = 1, groups = {"TS006"})
    public void ScrollingBottom() {
        logger.info("***  Starting TC029 Test Case  ***");
        try {
            Scroll scroll = new Scroll(driver);
            scroll.scrollToBottom();
        } catch (Exception e) {
            logger.error("Test has Failed.....");
            logger.debug("Debug logs");
            Assert.fail();
        }
        logger.info("***  Finish TC029 Test Case  ***");
    }


    @Test(priority = 2, groups = {"TS006"})
    public void ScrollingUp() {
        logger.info("***  Starting TC029 Test Case  ***");
        try {
            Scroll scroll = new Scroll(driver);
            scroll.scrollToTop();

        } catch (Exception e) {
            logger.error("Test has Failed.....");
            logger.debug("Debug logs");
            Assert.fail();
        }
        logger.info("***  Finish TC029 Test Case  ***");
    }


    @Test(priority = 3, groups = {"TS006"})
    public void TC029_ScrollingAtPosition() {
        logger.info("***  Starting TC029 Test Case  ***");
        try {
            Scroll scroll = new Scroll(driver);
            scroll.scrollToPosition(340, 34);

        } catch (Exception e) {
            logger.error("Test has Failed.....");
            logger.debug("Debug logs");
            Assert.fail();
        }
        logger.info("***  Finish TC029 Test Case  ***");
    }


}
