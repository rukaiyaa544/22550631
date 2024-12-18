package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseTest;

import java.time.Duration;

public class TC016 extends BaseTest {

    @Test (groups = {"TS005"})
    public void Login() {
        logger.info("***  Starting TC016 Test Case  ***");
        try {
            HomePage hp = new HomePage(driver);
            hp.navigateToLoginPage();

            LoginPage login = new LoginPage(driver);
            login.setLogin("test562467@gmail.com", "pa$sworD#123fas");

            hp.goToMyAccount();

            AccountPage account = new AccountPage(driver);
            account.customerInfo("Nora", "Jones", "test562467@gmail.com");

            WebElement myAccount = driver.findElement(By.xpath("//h1[text()='Customer info']"));
            Assert.assertTrue(myAccount.isDisplayed(), "Error in editing the Customer info");


        } catch (Exception e) {
            logger.error("Test has Failed.....");
            logger.debug("Debug logs");
            Assert.fail();
        }
        logger.info("***  Finish TC016 Test Case  ***");
    }


    }
