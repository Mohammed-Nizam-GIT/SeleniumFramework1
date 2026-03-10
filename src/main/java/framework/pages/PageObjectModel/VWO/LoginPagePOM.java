package framework.pages.PageObjectModel.VWO;

import framework.base.CommonToAllPage;
import framework.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPagePOM extends CommonToAllPage {
    WebDriver driver;

    public LoginPagePOM(WebDriver driver){
     this.driver=driver;

    }
    //Page locators

    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signButton = By.id("js-login-btn");
    private By error_message = By.id("js-notification-box-msg");

    //Page actions

    public String loginToVWOLoginInvalidCreds(String user, String pwd){
        driver.get(PropertiesReader.readKey("url"));
        enterInput(username,user);
        enterInput(password,pwd);
        clickElement(signButton);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String errorMessage = driver.findElement(error_message).getText();

        return errorMessage;
    }

    public void loginToVWOLoginValidCreds(String user, String pwd) {
        driver.get(PropertiesReader.readKey("url"));

        visibilityOfElement(username);
        visibilityOfElement(password);
        visibilityOfElement(signButton);
        enterInput(username,user);
        enterInput(password,pwd);
        clickElement(signButton);

        try {
            Thread.sleep(3000);
        }
        catch(InterruptedException e){
            throw new RuntimeException(e);
        }


    }
}
