package framework.pages.PageObjectModel.VWO;

import framework.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPagePOM extends CommonToAllPage {

     WebDriver driver;

     public DashboardPagePOM(WebDriver driver){
         this.driver=driver;
     }
    //page locator
    private By dashboard = By.cssSelector("[data-qa='lufexuloga']");

    //page action
     public String loggedInUserDashboard(){
         presenceOfElement(dashboard);
         return visibilityOfElement(dashboard).getText();
     }



}
