package testBase;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.Platform;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseTest {
    public Properties p;
    protected WebDriver driver;
    private String url = "https://www.wisque.com/";
    public Logger logger; //Log4j

    @BeforeClass (groups = {"TS001","TS002","TS003","TS004","TS005","TS006","TS007"})
    @Parameters({"browsers", "execution_env", "os"})
    public void setUp(@Optional("chrome") String br, @Optional("local") String executionEnv, @Optional("windows") String os) throws IOException {

        logger = LogManager.getLogger(this.getClass());

        // Load config.properties file
        p = new Properties();
        FileReader file = new FileReader("src/test/resources/config.properties");
        p.load(file);

        if (executionEnv.equalsIgnoreCase("remote")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();

            // Set OS
            if (os.equalsIgnoreCase("windows")) {
                capabilities.setPlatform(Platform.WIN11);
            } else if (os.equalsIgnoreCase("mac")) {
                capabilities.setPlatform(Platform.MAC);
            } else {
                System.out.println("No matching OS");
                return;
            }

            // Set Browser
            switch (br.toLowerCase()) {
                case "chrome":
                    capabilities.setBrowserName("chrome");
                    break;
                case "edge":
                    capabilities.setBrowserName("edge");
                    break;
                case "firefox":
                    capabilities.setBrowserName("firefox");
                    break;
                default:
                    System.out.println("No matching browser");
                    return;
            }
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        }

        if (executionEnv.equalsIgnoreCase("local")) {
            switch (br.toLowerCase()) {
                case "chrome":
                    ChromeOptions opt = new ChromeOptions();
                    opt.addArguments("--headless");
                    opt.addArguments("--incognito");
                    opt.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
                    driver = new ChromeDriver(opt);
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                default:
                    System.out.println("Invalid browser name...");
                    return;
            }
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(url);
    }

    @AfterMethod
    public void captureScreenshot(ITestResult result) {
        try {
            // Ensure the screenshots directory exists
            File screenshotsDir = new File(System.getProperty("user.dir") + "/screenshots");
            if (!screenshotsDir.exists()) {
                screenshotsDir.mkdirs();
            }

            // Capture screenshot
            TakesScreenshot ts = (TakesScreenshot) driver;
            File sourceFile = ts.getScreenshotAs(OutputType.FILE);

            // Use test case name for the screenshot file
            String testCaseName = result.getName();
            File targetFile = new File(screenshotsDir + "/" + testCaseName + ".jpg");

            // Move the source file to the target location
            sourceFile.renameTo(targetFile);

            System.out.println("Screenshot captured for test case: " + testCaseName);
        } catch (Exception e) {
            System.err.println("Failed to capture screenshot: " + e.getMessage());
        }
    }

    @AfterClass (groups = {"TS001","TS002","TS003","TS004","TS005","TS006","TS007"})
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
