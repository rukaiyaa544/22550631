package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.BasePage;

import java.time.Duration;

public class ChatBot extends BasePage {

    // Constructor
    public ChatBot(WebDriver driver) {
        super(driver);
    }

    // Locators
    @FindBy(xpath = "//button[@class ='cookiebanner__accept cookiebanner-accept catfish-button']")
    private WebElement closeBanner;

    @FindBy(xpath = "//span[text()='Hi. Need any help?']")
    private WebElement closeChatBotPopup;

    @FindBy(xpath = "//iframe[@id='launcher']")
    private WebElement frame1;

    @FindBy(xpath = "//button[@shape='square']")
    private WebElement chatbot;




    // Action Methods
    public void handleCookieBanner(WebDriverWait wait) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(closeBanner)).click();
            System.out.println("Cookie banner closed successfully.");
        } catch (TimeoutException | NoSuchElementException e) {
            System.out.println("Cookie banner not found. Proceeding without interaction.");
        }
    }



    private void switchToIframeIfNecessary(WebDriverWait wait) {
        try {
            //driver.switchTo().frame(frame1);
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame1));
            System.out.println("Switched to chatbot iframe.");
        } catch (TimeoutException | NoSuchElementException e) {
            System.out.println("Chatbot iframe not found. Proceeding in the main document context.");
        }
    }


    private void handleChatbotPopup(WebDriverWait wait) {
        try {
            Actions actions = new Actions(driver);
            WebElement popup = wait.until(ExpectedConditions.visibilityOf(closeChatBotPopup));
            actions.moveToElement(popup).click().perform();
            System.out.println("Chatbot popup closed successfully.");
        } catch (TimeoutException | NoSuchElementException e) {
            System.out.println("Chatbot popup not found or not clickable.");
        }
    }



    public void openChatbot() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Handle cookie banner
        handleCookieBanner(wait);

        // Switch to iframe if necessary
        switchToIframeIfNecessary(wait);

        // Handle chatbot popup
        handleChatbotPopup(wait);
        chatbot.click();


        // Switch back to the main document
        driver.switchTo().defaultContent();
        System.out.println("Returned to the main document context.");
    }
}
