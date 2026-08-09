package framework.utils;
import framework.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {
    public static String captureScreenshot(String testName) {
        TakesScreenshot screenshot = (TakesScreenshot) DriverManager.getDriver();
        File source = screenshot.getScreenshotAs(OutputType.FILE);

        String path = "screenshots/" + testName + "_" + System.currentTimeMillis() + ".png";

        File destination = new File(path);

        try {
            FileHandler.copy(source, destination);
            System.out.println("Screenshot saved: " + path);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }
}
