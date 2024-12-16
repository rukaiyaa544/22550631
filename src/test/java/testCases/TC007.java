package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import testBase.BaseTest;

public class TC007 extends BaseTest {

    @Test (dataProvider = "products")
    public void Login( String productName){

        try{
        HomePage hp = new HomePage(driver);
        hp.search(productName);

        WebElement myAccount = driver.findElement(By.xpath("//h1[text()='Search']"));
        Assert.assertTrue(myAccount.isDisplayed(), "Error in searching the item ");


    } catch(Exception e){
            logger.error("Test has Failed.....");
            logger.debug("Debug logs");
            Assert.fail();

        } logger.info("***  Finish TC007 Test Case  ***");

    }

    @DataProvider(name="products")
    Object[][] searchData(){

        Object data[][]={
                {"asdlkfjsdlfj"},
                {"!@#$%"},
                {"@"},
                {"abc!@#"},
                {"123!@#$"},
                {"a1!@#"},
                {"!@..#$%^&*..."},

        };

        return data;

    }


}
