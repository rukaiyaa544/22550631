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

    @Test (groups = {"TS005"})
    public void TC026_ChangePassword1() {
        logger.info("***  Starting TC026 Test Case  ***");
        try {
            HomePage hp = new HomePage(driver);
            hp.navigateToLoginPage();

            LoginPage login = new LoginPage(driver);
            login.setLogin("test562467@gmail.com", "pa$sworD#123fas");

            hp.goToMyAccount();

            AccountPage account = new AccountPage(driver);
            account.changePassword("pa$sworD#123fas", "pa$sworD#123fas", "pa$sworD#123fas");

            WebElement myAccount = driver.findElement(By.xpath("//li[contains(text(),'The new password must be different from the old pa')]"));
            Assert.assertTrue(myAccount.isDisplayed(), "Error in changing the password");


        } catch (Exception e) {
            logger.error("Test has Failed.....");
            logger.debug("Debug logs");
            Assert.fail();
        }
        logger.info("***  Finish TC026 Test Case  ***");

    }

}
