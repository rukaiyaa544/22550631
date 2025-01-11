package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseTest;
import utilities.ChatBot;
import utilities.Logout;

import java.time.Duration;

public class TC020 extends BaseTest {

    @Test (groups = {"TS005"})
    public void TC020_LoginBack(){
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

        login.setLogin2("test562467@gmail.com", "pa$sworD#123fas");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        hp.goToMyAccount();

        WebElement myAccount = driver.findElement(By.xpath("//h2[@class='section-title subtitle is-4 is-spaced']"));
        Assert.assertTrue(myAccount.isDisplayed(), "User did not log in successfully");


    } catch(Exception e){
            logger.error("Test has Failed.....");
            logger.debug("Debug logs");
            Assert.fail();
        }   logger.info("***  Finish TC020 Test Case  ***");



    }
}
