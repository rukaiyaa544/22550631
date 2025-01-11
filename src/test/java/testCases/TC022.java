package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseTest;
import utilities.ChatBot;

import java.time.Duration;

public class TC022 extends BaseTest {

    @Test (groups = {"TS005"})
    public void TC022_ChangeAccountDetails6(){
        logger.info("***  Starting TC022 Test Case  ***");
        try{
        HomePage hp = new HomePage(driver);
        hp.navigateToLoginPage();

        LoginPage login = new LoginPage(driver);
        login.setLogin("test562467@gmail.com", "pa$sworD#123fas");

        hp.goToMyAccount();

        AccountPage account = new AccountPage(driver);
        account.addAddress("Nora", "Jones", "Maple Street", " "," ","France", "00200", "0987654321" );
        account.setCancelAddress();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement myAccount = driver.findElement(By.xpath("//input[@title='Add new']"));
        Assert.assertTrue(myAccount.isDisplayed(), "Error in adding a new address");


    } catch(Exception e){
            logger.error("Test has Failed.....");
            logger.debug("Debug logs");
            Assert.fail();
        }   logger.info("***  Finish TC022 Test Case  ***");


    }
}
