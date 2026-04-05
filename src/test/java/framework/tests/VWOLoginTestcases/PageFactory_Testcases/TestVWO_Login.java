package framework.tests.VWOLoginTestcases.PageFactory_Testcases;

import framework.base.CommonToAllTest;
import framework.driver.DriverManager;
import framework.listeners.RetryAnalyzer;
import framework.pages.PageFactory.VWO.LoginPagePF;
import framework.utils.PropertiesReader;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test(retryAnalyzer = RetryAnalyzer.class)
public class TestVWO_Login extends CommonToAllTest {

    @Description("To verify VWO Login(using page factory) for invalid credentials")
    @Test
    public void testLoginNegativeVWO(){
        WebDriver driver = DriverManager.getDriver();
        driver.get(PropertiesReader.readKey("url"));

        LoginPagePF loginPagePF = new LoginPagePF(driver);
        String error_message = loginPagePF.loginToVWOLoginInvalidCreds(PropertiesReader.readKey("invalid_username"), PropertiesReader.readKey("invalid_password"));
        //covering the retryListeners
        Assert.assertEquals(error_message, PropertiesReader.readKey("invalid_error_message"));
        //Assert.assertEquals(error_message, PropertiesReader.readKey("error_message"));

    }
}
