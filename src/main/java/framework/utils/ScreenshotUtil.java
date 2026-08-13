package framework.utils;
import framework.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

import io.qameta.allure.Allure;
import java.io.FileInputStream;

public class ScreenshotUtil {
    public static String captureScreenshot(String testName) {

        TakesScreenshot screenshot =
                (TakesScreenshot) DriverManager.getDriver();

        File source = screenshot.getScreenshotAs(OutputType.FILE);

        // ADD: Create screenshots folder if it doesn't exist
        File screenshotDir = new File("screenshots");

        if (!screenshotDir.exists()) {
            screenshotDir.mkdirs();
        }

        String path = "screenshots/" + testName + "_" + System.currentTimeMillis() + ".png";
        File destination = new File(path);

        try {
            FileHandler.copy(source, destination);

            System.out.println("Screenshot saved: " + path);

            // Attach the same screenshot to Allure
            try (FileInputStream fis = new FileInputStream(destination)) {
                Allure.addAttachment(
                        "Failure Screenshot",
                        "image/png",
                        fis,
                        ".png"
                );
            }

            System.out.println("Screenshot attached to Allure");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }
}
