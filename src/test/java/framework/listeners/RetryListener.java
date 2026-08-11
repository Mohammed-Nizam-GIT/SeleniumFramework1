package framework.listeners;

import framework.utils.ScreenshotUtil;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class RetryListener implements IAnnotationTransformer, ITestListener {

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

        // ⭐ ADDED
        // If test has @NoRetry, don't apply RetryAnalyzer
        if (testMethod != null &&
                testMethod.isAnnotationPresent(NoRetry.class)) {

            return;
        }
        // Existing retry logic
        annotation.setRetryAnalyzer(RetryAnalyzer.class);
    }
    @Override
    //ADDED: called whenever a test fails
        public void onTestFailure(ITestResult result) {

        // ⭐ ADDED: Check whether this test has @NoRetry
        Method method = result.getMethod()
                .getConstructorOrMethod()
                .getMethod();

        if (method.isAnnotationPresent(NoRetry.class)) {

            System.out.println(
                    "NoRetry test failed - capturing screenshot"
            );

            // ⭐ ADDED
            ScreenshotUtil.captureScreenshot(result.getName());

            // Don't continue into retry logic
            return;
        }

        //Retry Logic

    //  ADDED: get the RetryAnalyzer for this test
    RetryAnalyzer retryAnalyzer = (RetryAnalyzer) result.getMethod().getRetryAnalyzer(result);

    //  ADDED: take screenshot only after final retry
        if (retryAnalyzer.isFinalAttempt()) {
        System.out.println("Final failure - capturing screenshot");

        //  ADDED: capture screenshot and attach it to Allure
        ScreenshotUtil.captureScreenshot(result.getName());
    }
  }
}
