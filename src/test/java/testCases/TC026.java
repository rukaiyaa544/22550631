package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseTest;

public class TC026 extends BaseTest {

    @Test
    public void Login() {
        logger.info("***  Starting TC026 Test Case  ***");
        try {
            HomePage hp = new HomePage(driver);
            hp.navigateToLoginPage();

            LoginPage login = new LoginPage(driver);
            login.setLogin("test562467@gmail.com", "pa$sworD#123fas");

            hp.goToMyAccount();

            AccountPage account = new AccountPage(driver);
            account.changePassword("pa$sworD#123fas", "password123", "password123");

            WebElement myAccount = driver.findElement(By.xpath("//h1[text()='Change password']"));
            Assert.assertTrue(myAccount.isDisplayed(), "Error in changing the password");


        } catch (Exception e) {
            logger.error("Test has Failed.....");
            logger.debug("Debug logs");
            Assert.fail();
        }
        logger.info("***  Finish TC026 Test Case  ***");

    }

}
