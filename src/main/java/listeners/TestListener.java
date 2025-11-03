package listeners;
import base.BaseTest;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import utils.Utility;
import org.openqa.selenium.WebDriver;
import base.BaseTest;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        Reporter.log("Starting test: " + result.getName(), true);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Reporter.log("Test Passed: " + result.getName(), true);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Reporter.log("Test Failed: " + result.getName(), true);
        Object currentClass = result.getInstance();
        WebDriver driver = ((BaseTest) currentClass).getDriver();
        Utility.takeScreenshot(driver, result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Reporter.log("Test Skipped: " + result.getName(), true);
    }

    @Override
    public void onStart(ITestContext context) {
        Reporter.log("Starting Test Suite: " + context.getName(), true);
    }

    @Override
    public void onFinish(ITestContext context) {
        Reporter.log("Finished Test Suite: " + context.getName(), true);
    }
}
