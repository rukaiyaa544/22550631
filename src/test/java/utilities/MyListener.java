package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {

    private ExtentReports extent;
    private ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
        // Initialize ExtentReports
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extent-report.html");
        sparkReporter.config().setReportName("Test Execution Report");
        sparkReporter.config().setDocumentTitle("Automation Test Report");

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Tester", "Ann");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Browser", "Chrome");

        System.out.println("Test execution has started...");
    }

    @Override
    public void onTestStart(ITestResult result) {
        // Create a new test in ExtentReports
        test = extent.createTest(result.getMethod().getMethodName());
        test.info("Test started...");
        System.out.println("Test started...");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test passed!");
        System.out.println("Test passed...");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail("Test failed!");
        test.fail(result.getThrowable()); // Log the exception
        System.out.println("Test failed...");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.skip("Test skipped!");
        test.skip(result.getThrowable()); // Log the reason for skipping
        System.out.println("Test skipped...");
    }

    @Override
    public void onFinish(ITestContext context) {
        // Generate the ExtentReports
        extent.flush();
        System.out.println("Test execution is finished...");
    }
}
