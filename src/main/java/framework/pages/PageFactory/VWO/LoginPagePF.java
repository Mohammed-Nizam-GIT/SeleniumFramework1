package framework.pages.PageFactory.VWO;

import framework.base.CommonToAllPage;
import framework.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPagePF extends CommonToAllPage {

    public LoginPagePF(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    //Page locators
    @FindBy(id = "login-username")
    private WebElement username;

    @FindBy(id = "login-password")
    private WebElement password;

    @FindBy(id = "js-login-btn")
    private WebElement signIn;

    @FindBy(id ="js-notification-box-msg")
    private WebElement errorMessage;

    //Page actions

    public String loginToVWOLoginInvalidCreds(String user, String pwd){

        enterInput(username,user);
        enterInput(password,pwd);
        clickElement(signIn);
        try {
            Thread.sleep(3000);
        }
        catch(InterruptedException e){
            throw new RuntimeException(e);
        }

        return errorMessage.getText();
    }


}
