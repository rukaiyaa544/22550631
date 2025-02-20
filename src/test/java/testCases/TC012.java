package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CardsPage;
import pageObjects.HomePage;
import pageObjects.ProductPage;
import testBase.BaseTest;

public class TC012 extends BaseTest {

    @Test (groups = {"TS004"})
    public void TC012_SelectArtist3() {
        logger.info("***  Starting TC012 Test Case  ***");
        try {
            HomePage hp = new HomePage(driver);
            hp.productCards();

            CardsPage card = new CardsPage(driver);
            card.setAcceptBanner();
            card.clickThirdProduct();

            ProductPage product = new ProductPage(driver);
            product.setAddToBasket();

            WebElement myAccount = driver.findElement(By.xpath("//h1[text()='Basket']"));
            Assert.assertTrue(myAccount.isDisplayed(), "Error in adding the item to the Basket ");


        } catch (Exception e) {
            logger.error("Test has Failed.....");
            logger.debug("Debug logs");
            Assert.fail();
        }
        logger.info("***  Finish TC012 Test Case  ***");
    }


    }
