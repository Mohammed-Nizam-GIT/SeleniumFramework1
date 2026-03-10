package framework.tests.sampleTestcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class TestRun {
    @Test
    public void testMethod(){
        System.out.println("Hello");
        WebDriver driver=new EdgeDriver();
        driver.get("https://www.google.com");
        driver.quit();
    }
}
