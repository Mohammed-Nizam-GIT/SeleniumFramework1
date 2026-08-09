package framework.listeners;

import framework.utils.ScreenshotUtil;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int retryCount = 0;
    private static final int maxCount = 3;

    @Override
     public boolean retry(ITestResult iTestResult){
        System.out.println("===== RETRY ANALYZER CALLED =====");
        System.out.println("Retry count: " + retryCount);

        if(retryCount < maxCount) {
            retryCount++;
            System.out.println("Retrying test...");
            return true;
        }
        // Final failure after all retries
        System.out.println("===== FINAL FAILURE - TAKING SCREENSHOT =====");
        ScreenshotUtil.captureScreenshot(iTestResult.getName());

        return false;
    }


}
