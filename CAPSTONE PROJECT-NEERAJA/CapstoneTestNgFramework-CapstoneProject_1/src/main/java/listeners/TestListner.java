package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import reportManager.ExtentManager;

import java.util.concurrent.ConcurrentHashMap;

public class TestListner implements ITestListener {
    private ConcurrentHashMap<String, ExtentTest> allTests = new ConcurrentHashMap<String, ExtentTest>();
    String reportFolderPath = System.getProperty("user.dir") + "//AutomationReports//";
    String reportName = "AutomationReport.html";

    //After ending all tests, below method runs.
    public void onFinish(ITestContext iTestContext) {
        ExtentManager.getInstance().flush();
    }

    public void onTestStart(ITestResult iTestResult) {
        ExtentTest extentTest = ExtentManager.createInstance(reportFolderPath, reportName).createTest(iTestResult.getMethod().getRealClass().getSimpleName());
        allTests.put(iTestResult.getClass().getSimpleName(), extentTest);
        ExtentManager.setTest(extentTest);
        ExtentManager.getInstance().flush();
    }

    public void onTestSuccess(ITestResult iTestResult) {
        ExtentManager.getTest().get().assignCategory(iTestResult.getClass().getSimpleName());
        ExtentManager.getTest().get().createNode(MarkupHelper.createLabel("Test passed", ExtentColor.GREEN).getMarkup());
        ExtentManager.getInstance().flush();
    }

    public void onTestFailure(ITestResult iTestResult) {
        try {
            ExtentManager.getTest().get().createNode(MarkupHelper.createLabel("Test Failed", ExtentColor.RED).getMarkup())
                    .fail(iTestResult.getThrowable());
            ExtentManager.getInstance().flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

    public void onStart(ITestContext iTestContext) {

    }
}