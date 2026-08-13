package framework.tests.sampleTestcases;

import framework.base.CommonToAllTest;
import framework.listeners.NoRetry;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ScreenshotTest extends CommonToAllTest {

    @NoRetry
    @Test
        public void screenshotTest() {
            Assert.assertTrue(true);
        }
    }
