package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseTest;
import utilities.Logout;

public class TC020 extends BaseTest {

    @Test
    public void Login(){
        logger.info("***  Starting TC020 Test Case  ***");
        try{
        HomePage hp = new HomePage(driver);
        hp.navigateToLoginPage();

        LoginPage login = new LoginPage(driver);
        login.setLogin("test562467@gmail.com", "pa$sworD#123fas");

        hp.goToMyAccount();

        AccountPage account = new AccountPage(driver);
        account.customerInfo("Nora", "Jones","test562467@gmail.com");

        Logout logout  = new Logout(driver);
        logout.logout();

        login.setLogin("test562467@gmail.com", "pa$sworD#123fas");

        WebElement myAccount = driver.findElement(By.xpath("//a[text()='My Account']"));
        Assert.assertTrue(myAccount.isDisplayed(), "User did not log in successfully");


    } catch(Exception e){
            logger.error("Test has Failed.....");
            logger.debug("Debug logs");
            Assert.fail();
        }   logger.info("***  Finish TC020 Test Case  ***");



    }
}
