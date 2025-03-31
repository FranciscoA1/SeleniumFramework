package listeners;

import org.testng.ITestResult;
import org.testng.ITestListener;
import utilities.FileManager;
import utilities.Logs;

public class TestListeners implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        Logs.info("onTestStart: %s", result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Logs.info("onTestSuccess: %s", result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Logs.info("onTestFailure: %s", result.getName());
        FileManager.getScreenshot(result.getName());
        FileManager.getPageSource(result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Logs.info("onTestSkipped: %s", result.getName());
    }
}