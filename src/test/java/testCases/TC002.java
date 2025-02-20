package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseTest;

public class TC002 extends BaseTest {

    @Test (groups = {"TS001"})
    public void TC002_Login2(){
        logger.info("***  Starting TC002 Test Case  ***");
        try {
            HomePage hp = new HomePage(driver);
            hp.navigateToLoginPage();
            LoginPage login = new LoginPage(driver);
            login.setLogin("test562467@gmail.com", "password123");

            WebElement myAccount = driver.findElement(By.xpath("//a[text()='My Account']"));
            Assert.assertFalse(myAccount.isDisplayed(), "User did not log in successfully");
        } catch(Exception e){
            logger.error("Test has Failed.....");
            logger.debug("Debug logs");
            Assert.fail();

        }
        logger.info("***  Finish TC002 Test Case  ***");

    }




}
