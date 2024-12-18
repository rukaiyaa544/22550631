package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import testBase.BaseTest;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class TC001 extends BaseTest {

    @Test (groups = {"TS001"})
    public void TC001_Login1() {
        logger.info("***  Starting TC001 Test Case  ***");
        try {
            HomePage hp = new HomePage(driver);
            hp.navigateToLoginPage();
            LoginPage login = new LoginPage(driver);
            login.setLogin("test562467@gmail.com", "pa$sworD#123fas");

            WebElement myAccount = driver.findElement(By.xpath("//a[text()='My Account']"));
            Assert.assertTrue(myAccount.isDisplayed(), "User did not log in successfully");
        } catch (Exception e) {
            logger.error("Test has Failed.....");
            logger.debug("Debug logs");
            Assert.fail();

        }
        logger.info("***  Finish TC001 Test Case  ***");

    }


}

