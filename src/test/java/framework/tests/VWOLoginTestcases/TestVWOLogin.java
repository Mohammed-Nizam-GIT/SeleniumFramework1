package framework.tests.VWOLoginTestcases;

import framework.base.CommonToAllTest;
import framework.driver.DriverManager;
import framework.pages.PageObjectModel.VWO.DashboardPagePOM;
import framework.pages.PageObjectModel.VWO.LoginPagePOM;
import framework.utils.PropertiesReader;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class TestVWOLogin extends CommonToAllTest {

    @Description("To verify VWO Login for invalid credentials")
    @Test
    public void testLoginNegativeVWO(){

        LoginPagePOM loginPagePOM = new LoginPagePOM(DriverManager.getDriver());
        String errorMessage = loginPagePOM.loginToVWOLoginInvalidCreds(PropertiesReader.readKey("invalid_username"),PropertiesReader.readKey("invalid_password"));

        assertThat(errorMessage).isNotBlank().isNotEmpty();
        Assert.assertEquals(errorMessage, PropertiesReader.readKey("error_message"));

    }
    @Description("To verify VWO Login for valid credentials and verify the dashboard")
    @Test
    public void testLoginPositiveVWO(){
        LoginPagePOM loginPagePOM = new LoginPagePOM(DriverManager.getDriver());
        loginPagePOM.loginToVWOLoginValidCreds(PropertiesReader.readKey("username"),PropertiesReader.readKey("password"));

        DashboardPagePOM dashboardPagePOM = new DashboardPagePOM(DriverManager.getDriver());
        String dashboardName = dashboardPagePOM.loggedInUserDashboard();
        System.out.println(dashboardName);
        assertThat(dashboardName).isNotEmpty().isNotBlank();
        assertThat(dashboardName).isEqualTo(PropertiesReader.readKey("expected_username"));

    }

}
