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

public class TC021 extends BaseTest {

    @Test (groups = {"TS005"})
    public void TC021_ChangeAccountDetails5() {
        logger.info("***  Starting TC021 Test Case  ***");
        try {
            HomePage hp = new HomePage(driver);
            hp.navigateToLoginPage();

            LoginPage login = new LoginPage(driver);
            login.setLogin("test562467@gmail.com", "pa$sworD#123fas");

            hp.goToMyAccount();

            AccountPage account = new AccountPage(driver);
            account.addAddress("Nora", "Jones", "Maple Street", " ", " ", "France", "00200", "0987654321");
            account.setSaveAddress();

            WebElement myAccount = driver.findElement(By.xpath("//input[@title='Add new']"));
            Assert.assertTrue(myAccount.isDisplayed(), "Error in adding a new address");


        } catch (Exception e) {
            logger.error("Test has Failed.....");
            logger.debug("Debug logs");
            Assert.fail();
        }
        logger.info("***  Finish TC021 Test Case  ***");


    }
}
