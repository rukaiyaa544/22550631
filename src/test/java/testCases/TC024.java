package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseTest;

public class TC024 extends BaseTest {

    @Test (groups = {"TS005"})
    public void TC024_Orders2() {
        logger.info("***  Starting TC024 Test Case  ***");
        try {
            HomePage hp = new HomePage(driver);
            hp.navigateToLoginPage();

            LoginPage login = new LoginPage(driver);
            login.setLogin("test562467@gmail.com", "pa$sworD#123fas");

            hp.goToMyAccount();

            AccountPage account = new AccountPage(driver);
            account.goToOrders();
            account.ordersSearchBy(3);

            WebElement myAccount = driver.findElement(By.xpath("//h2[text()='Orders']"));
            Assert.assertTrue(myAccount.isDisplayed(), "Error in filtering Orders1");


        } catch (Exception e) {
            logger.error("Test has Failed.....");
            logger.debug("Debug logs");
            Assert.fail();
        }
        logger.info("***  Finish TC024 Test Case  ***");


    }
}
