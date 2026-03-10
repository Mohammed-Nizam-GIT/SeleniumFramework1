package framework.base;

import framework.driver.DriverManager;
import org.testng.annotations.*;

public class CommonToAllTest {
    @BeforeMethod
    public void setup(){
        DriverManager.init();
    }
    @AfterMethod
    public void tearDown(){
    DriverManager.down();
    }
}
