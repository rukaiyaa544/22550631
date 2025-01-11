package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.BaseTest;
import utilities.ChatBot;


public class TC030 extends BaseTest {

    @Test(priority = 1, groups = {"TS007"})
    public void TC030_Chat() {
        logger.info("***  Starting TC030 Test Case  ***");
        try {
            ChatBot chat = new ChatBot(driver);
            chat.openChatbot();

        } catch (Exception e) {
            logger.error("Test has Failed.....");
            logger.debug("Debug logs");
            Assert.fail();
        }
        logger.info("***  Finish TC030 Test Case  ***");
    }


}
