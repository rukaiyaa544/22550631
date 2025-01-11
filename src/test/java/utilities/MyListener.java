package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyListener implements ITestListener {

    private ExtentReports extent;
    private ExtentTest test;
    private String reportPath;

    @Override
    public void onStart(ITestContext context) {
        try {
            // Define the report directory and name with timestamp
            String reportDirectory = System.getProperty("user.dir") + File.separator + "reports";
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String reportName = "myReport_" + timestamp + ".html";
            reportPath = reportDirectory + File.separator + reportName;

            // Create the reports directory if it doesn't exist
            File dir = new File(reportDirectory);
            if (!dir.exists() && !dir.mkdirs()) {
                throw new IOException("Failed to create reports directory: " + reportDirectory);
            }

            // Initialize ExtentSparkReporter
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
            sparkReporter.config().setDocumentTitle("Selenium Automation Report");
            sparkReporter.config().setReportName("Wisque- Selenium Automation Report");
            sparkReporter.config().setTheme(Theme.DARK);

            // Initialize ExtentReports and attach the reporter
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("Tester", "Rukaiya");
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Browser", "Chrome");

            System.out.println("Test execution has started...");
            System.out.println("Report will be saved at: " + reportPath);
        } catch (Exception e) {
            System.err.println("Error during report setup: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        // Create a new test in the report
        test = extent.createTest(result.getMethod().getMethodName());
        test.info("Test started...");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test passed!");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail("Test failed: " + result.getMethod().getMethodName());
        test.fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.skip("Test skipped: " + result.getMethod().getMethodName());
        test.skip(result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        try {
            if (extent != null) {
                extent.flush();
                System.out.println("Report flushed successfully.");

                // Validate if the report file is created
                File reportFile = new File(reportPath);
                if (reportFile.exists()) {
                    System.out.println("Report generated at: " + reportPath);
                } else {
                    throw new IOException("Report file not found at: " + reportPath);
                }
            } else {
                System.err.println("ExtentReports instance is null. Report was not generated.");
            }
        } catch (Exception e) {
            System.err.println("Error during report generation: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
