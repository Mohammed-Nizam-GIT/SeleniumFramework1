package framework.tests.VWOLoginTestcases.PageObjectModel_Testcases;

import framework.base.CommonToAllTest;
import framework.driver.DriverManager;
import framework.pages.PageObjectModel.VWO.DashboardPagePOM;
import framework.pages.PageObjectModel.VWO.LoginPagePOM;
import framework.utils.PropertiesReader;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
//import from these two to use log4j
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.assertj.core.api.Assertions.*;

public class Test_VWOLogin extends CommonToAllTest {

    //follow the below line to use log4j
    //step 1
    private static final Logger logger = LogManager.getLogger(Test_VWOLogin.class);

    @Description("To verify VWO Login for invalid credentials")
    @Test
    public void testLoginNegativeVWO(){

    //step 2
    logger.info("Invalid credentials start test 1");
        LoginPagePOM loginPagePOM = new LoginPagePOM(DriverManager.getDriver());
        String errorMessage = loginPagePOM.loginToVWOLoginInvalidCreds(PropertiesReader.readKey("invalid_username"),PropertiesReader.readKey("invalid_password"));

        assertThat(errorMessage).isNotBlank().isNotEmpty();
        Assert.assertEquals(errorMessage, PropertiesReader.readKey("error_message"));
    logger.info("Invalid credentials end test 1");
    }
    @Description("To verify VWO Login for valid credentials and verify the dashboard")
    @Test
    public void testLoginPositiveVWO(){
        logger.info("Valid credentials start test 2");
        LoginPagePOM loginPagePOM = new LoginPagePOM(DriverManager.getDriver());
        loginPagePOM.loginToVWOLoginValidCreds(PropertiesReader.readKey("username"),PropertiesReader.readKey("password"));

        DashboardPagePOM dashboardPagePOM = new DashboardPagePOM(DriverManager.getDriver());
        String dashboardName = dashboardPagePOM.loggedInUserDashboard();
        System.out.println(dashboardName);
        assertThat(dashboardName).isNotEmpty().isNotBlank();
        assertThat(dashboardName).isEqualTo(PropertiesReader.readKey("expected_username"));
        logger.info("Valid credentials end test 2");
    }

}
