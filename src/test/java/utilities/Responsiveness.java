package utilities;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.BasePage;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Responsiveness extends BasePage {

    // Constructor
    public Responsiveness(WebDriver driver) {
        super(driver);
    }




    // Predefined dimensions for different devices
    private static final Map<String, Dimension> DEVICE_DIMENSIONS = new HashMap<>() {{
        put("Mobile", new Dimension(390, 844));
        put("Tablet", new Dimension(768, 1024));
        put("Laptop", new Dimension(1366, 768));
        put("Desktop", new Dimension(1920, 1080));
    }};

    @FindBy(tagName = "body")
    WebElement pageBody;




    public void resizeToDevice(String deviceName) {
        Dimension dimension = DEVICE_DIMENSIONS.get(deviceName);
        if (dimension != null) {
            driver.manage().window().setSize(dimension);
            System.out.println("Resized to: " + deviceName + " (" + dimension.width + "x" + dimension.height + ")");
        } else {
            throw new IllegalArgumentException("Unknown device name: " + deviceName);
        }
    }


    public void checkPageResponsiveness() {
        for (Map.Entry<String, Dimension> entry : DEVICE_DIMENSIONS.entrySet()) {
            String deviceName = entry.getKey();
            resizeToDevice(deviceName);

            // Log or perform additional checks here
            System.out.println("Checking responsiveness for: " + deviceName);

            // Example validation: wait for page to adjust layout
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(d -> pageBody.isDisplayed());
        }
    }
}
