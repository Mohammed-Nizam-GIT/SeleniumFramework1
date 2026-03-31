package framework.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static framework.driver.DriverManager.getDriver;

public class CommonToAllPage {

    // If you want to call something before every Page Object Class call, Put your Code here");
    // Open File, Open Data Base Connection You can write code here

    public void clickElement(By ele) {
        getDriver().findElement(ele).click();
    }

    public void clickElement(WebElement ele) {
        ele.click();
    }

    public void enterInput(By ele, String key) {
        getDriver().findElement(ele).sendKeys(key);
    }

    public void enterInput(WebElement ele, String key) {
        ele.sendKeys(key);
    }

    public String getText(By ele) {
        return getDriver().findElement(ele).getText();
    }

    public WebElement presenceOfElement(By ele) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(ele));
    }

    public WebElement visibilityOfElement(By ele) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(ele));
    }

    public WebElement getElement(By ele) {
        return getDriver().findElement(ele);
    }
}
