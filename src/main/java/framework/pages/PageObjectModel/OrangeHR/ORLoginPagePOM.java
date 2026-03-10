package framework.pages.PageObjectModel.OrangeHR;

import framework.base.CommonToAllPage;
import framework.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ORLoginPagePOM extends CommonToAllPage {

    WebDriver driver;

    public ORLoginPagePOM(WebDriver driver){
        this.driver=driver;
    }

    //page locators
    private By username = By.name("username");
    private By password = By.name("password");
    private By submit = By.xpath("//button[text()=' Login ']");
    private By errorMessage = By.xpath("//p[normalize-space()='Invalid credentials']");

    //page actions
    public void ORLoginPositive(String user, String pwd){
        driver.get(PropertiesReader.readKey("orange_hr_url"));
        visibilityOfElement(username);
        visibilityOfElement(password);
        visibilityOfElement(submit);
        enterInput(username,user);
        enterInput(password,pwd);
        clickElement(submit);

        try {
            Thread.sleep(3000);
        }
        catch(InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    public String ORLoginNegative(String user, String pwd){
        driver.get(PropertiesReader.readKey("orange_hr_url"));
        visibilityOfElement(username);
        visibilityOfElement(password);
        visibilityOfElement(submit);

        enterInput(username,user);
        enterInput(password,pwd);
        clickElement(submit);
        visibilityOfElement(errorMessage);

        String error = getText(errorMessage);
        try {
            Thread.sleep(3000);
        }
        catch(InterruptedException e){
            throw new RuntimeException(e);
        }

        return error;



    }

}
