package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseTest;

public class TC018 extends BaseTest {

    @Test (groups = {"TS005"})
    public void TC018_ChangeAccountDetails3(){
        logger.info("***  Starting TC018 Test Case  ***");
        try{
        HomePage hp = new HomePage(driver);
        hp.navigateToLoginPage();

        LoginPage login = new LoginPage(driver);
        login.setLogin("test562467@gmail.com", "pa$sworD#123fas");

        hp.goToMyAccount();

        AccountPage account = new AccountPage(driver);
        account.customerInfo("Nora", " ","test562467@gmail.com");

        WebElement myAccount = driver.findElement(By.xpath("//h1[text()='Customer info']"));
        Assert.assertTrue(myAccount.isDisplayed(), "Error in editing the Customer info");


    } catch(Exception e){
            logger.error("Test has Failed.....");
            logger.debug("Debug logs");
            Assert.fail();
        }   logger.info("***  Finish TC006 Test Case  ***");



    }
}
