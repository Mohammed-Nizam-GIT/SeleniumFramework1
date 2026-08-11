package framework.tests.OrangeHRTestcases;

import framework.base.CommonToAllTest;
import framework.driver.DriverManager;
import framework.pages.PageObjectModel.OrangeHR.ORDashboardPOM;
import framework.pages.PageObjectModel.OrangeHR.ORLoginPagePOM;
import framework.utils.PropertiesReader;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;
import framework.dataProviders.ExcelDataProvider;

public class OrangeHRLogin extends CommonToAllTest {

    @Description("To verify Orange HR login wit positive credentials and verify the dashboard")
    @Test(dataProvider = "loginData", dataProviderClass = ExcelDataProvider.class) //for datadriven
    public void testORloginPositive(String username, String password){

        ORLoginPagePOM orLoginPagePOM = new ORLoginPagePOM(DriverManager.getDriver());
        //orLoginPagePOM.ORLoginPositive(PropertiesReader.readKey("ohn_username"),PropertiesReader.readKey("ohn_password");
        orLoginPagePOM.ORLoginPositive(username,password); //for datadriven

        ORDashboardPOM orDashboardPOM = new ORDashboardPOM(DriverManager.getDriver());
        String dashboardName = orDashboardPOM.UsernameInDashboard();
        System.out.println(dashboardName);
        assertThat(dashboardName).isNotEmpty().isNotBlank();
        Assert.assertEquals(dashboardName,PropertiesReader.readKey("ohr_expected_username"));

    }
    @Description("To verify Orange HR login wit negative credentials and verify the error message")
    @Test
    public void testORloginNegative(){
        ORLoginPagePOM orLoginPagePOM =  new ORLoginPagePOM(DriverManager.getDriver());
        String errorMessage = orLoginPagePOM.ORLoginNegative(PropertiesReader.readKey("invalid_username"),PropertiesReader.readKey("invalid_password"));
        System.out.println(errorMessage);
        assertThat(errorMessage).isNotBlank().isNotEmpty();
        assertThat(errorMessage).isEqualTo(PropertiesReader.readKey("ohr_invalid_error_message"));
        //Or
        Assert.assertEquals(errorMessage,PropertiesReader.readKey("ohr_invalid_error_message"));


    }

}
