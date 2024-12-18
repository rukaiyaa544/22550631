package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class AccountPage extends BasePage {


    // constructor
    public AccountPage(WebDriver driver) {
        super(driver);
    }



    //Locators
    @FindBy(xpath = "//input[@id='FirstName']")
    WebElement firstName;

    @FindBy(xpath = "//input[@id='LastName']")
    WebElement lastName;

    @FindBy(xpath = "//input[@id='Email']")
    WebElement emailAddress;

    @FindBy(xpath = "//button[@id='checkDepartmentChanged']")
    WebElement savePersonalDetailsBtn;


    @FindBy(xpath = "//a[normalize-space()='Addresses']")
    WebElement addresses;

    @FindBy(xpath = "//input[@title='Add new']")
    WebElement addAddress;

    @FindBy(xpath = "//input[@id='Address_FirstName']")
    WebElement addressFirstName;

    @FindBy(xpath = "//input[@id='Address_LastName']")
    WebElement addressLastName;

    @FindBy(xpath = "//input[@id='Address_Address1']")
    WebElement addressLine1;

    @FindBy(xpath = "//input[@id='Address_Address2']")
    WebElement addressLine2;

    @FindBy(xpath = "//input[@id='Address_City']")
    WebElement town;

    @FindBy(xpath = "//select[@id='Address_CountryId']")
    WebElement countryList;

    @FindBy(xpath = "//input[@id='Address_ZipPostalCode']")
    WebElement addressPostcode;

    @FindBy(xpath = "//input[@id='Address_PhoneNumber']")
    WebElement addressPhoneNumber;

    @FindBy(xpath = "//input[@value='Save']")
    WebElement saveAddress;

    @FindBy(xpath = "//input[@value='Cancel']")
    WebElement cancelAddress;



    @FindBy(xpath = "//a[normalize-space()='Orders']")
    WebElement orders;

    @FindBy(xpath = "//input[@id='submit_order_search']")
    WebElement searchOrders;

    @FindBy(xpath = "//select[@id='sort_select']")
    WebElement sortByDropdown;

    @FindBy(xpath = "//select[@id='OrderSearchFilter']")
    WebElement searchByDropdown;

    @FindBy(xpath = "//input[@id='order_search_input']")
    WebElement searchField;


    @FindBy(xpath = "//a[@id='order_All']")
    WebElement showAllOrdersBtn;

    @FindBy(xpath = "//a[@id='order_Cancelled']")
    WebElement cancelledOrdersBtn;

    @FindBy(xpath = "//a[@id='order_Complete']")
    WebElement completedOrdersBtn;

    @FindBy(xpath = "//a[@id='order_Processing']")
    WebElement processingOrdersBtn;

    @FindBy(xpath = "//a[@id='order_Unpaid']")
    WebElement unpaidOrdersBtn;

    @FindBy(xpath = "//a[@id='order_Pending']")
    WebElement pendingOrdersBtn;



    @FindBy(xpath = "//a[normalize-space()='Change password']")
    WebElement changePassword;

    @FindBy(xpath = "//input[@id='OldPassword']")
    WebElement oldPasswordField;

    @FindBy(xpath = "//input[@id='NewPassword']")
    WebElement newPasswordField;

    @FindBy(xpath = "//input[@id='ConfirmNewPassword']")
    WebElement confirmPasswordField;

    @FindBy(xpath = "//input[@value='Change password']")
    WebElement changePasswordBtn;

    @FindBy(xpath = "//button[@aria-label='Close message from company']")
    WebElement closePopup;






    //Action Methods

    public void customerInfo(String fname, String lname, String email) {

        firstName.clear();
        firstName.sendKeys(fname);
        lastName.clear();
        lastName.sendKeys(lname);
        emailAddress.clear();
        emailAddress.sendKeys(email);
        savePersonalDetailsBtn.click();
    }

    public void addAddress(String fname, String lname, String line1, String line2, String townName, String country, String postcode, String phonenumber) {
        addresses.click();
        addAddress.click();
        addressFirstName.sendKeys(fname);
        addressLastName.sendKeys(lname);
        addressLine1.sendKeys(line1);
        addressLine2.sendKeys(line2);
        town.sendKeys(townName);

        Select selectedCountry = new Select(countryList);
        selectedCountry.selectByVisibleText(country);

        addressPostcode.sendKeys(postcode);
        addressPhoneNumber.sendKeys(phonenumber);

    }

    public void setSaveAddress(){
        saveAddress.click();
    }

    public void setCancelAddress(){
        cancelAddress.click();
        driver.switchTo().alert().accept();
    }



    public void goToOrders(){
        orders.click();
    }

    public void searchOrders(){
        searchOrders.click();
    }


    public void ordersSortBy(Integer num){
        Select sortBy = new Select(sortByDropdown);
        sortBy.selectByValue(num.toString());   //1 to 6
    }


    public void ordersSearchBy(Integer num){
        Select searchBy = new Select(searchByDropdown);
        searchBy.selectByValue(num.toString());
    }

    public void ordersSearchInput(String text){
        searchField.sendKeys("text");
    }


    //Filter Buttons
    public void setShowAllOrders(){
        showAllOrdersBtn.click();
    }

    public void setCancelledOrders(){
        cancelledOrdersBtn.click();
    }

    public void setCompletedOrders(){
        completedOrdersBtn.click();
    }

    public void setProcessingOrders(){
        processingOrdersBtn.click();
    }

    public void setUnpaidOrders(){
        unpaidOrdersBtn.click();
    }

    public void setPendingOrders(){
        pendingOrdersBtn.click();
    }


    public void changePassword(String oldPassword, String newPasword, String confirmPassword){
        changePassword.click();
        oldPasswordField.sendKeys(oldPassword);
        newPasswordField.sendKeys(newPasword);
        confirmPasswordField.sendKeys(confirmPassword);
        changePasswordBtn.click();

    }




}

