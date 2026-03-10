package framework.pages.PageObjectModel.OrangeHR;

import framework.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ORDashboardPOM extends CommonToAllPage {

    WebDriver driver;
   public ORDashboardPOM(WebDriver driver){
     this.driver = driver;
    }
    //page locator
    private By loggedInUsername = By.xpath("//h6[normalize-space()='PIM']");

    //page action

    public String UsernameInDashboard(){
        presenceOfElement(loggedInUsername);
        return visibilityOfElement(loggedInUsername).getText();
    }

}
