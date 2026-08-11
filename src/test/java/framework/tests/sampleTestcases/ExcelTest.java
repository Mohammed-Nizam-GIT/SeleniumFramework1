package framework.tests.sampleTestcases;

import framework.utils.ExcelUtil;
import org.testng.annotations.Test;
import java.io.IOException;

public class ExcelTest {

    @Test
    public void readExcelTest() throws IOException{
        String path = "src/test/resources/testdata/LoginData.xlsx";
        ExcelUtil excel = new ExcelUtil(path,"LoginData");

        System.out.println("Rows:" + excel.getRowCount());
        System.out.println("Coulmns:" + excel.getColumnCount());
        System.out.println("Username:"+ excel.getCellData(1,0));
        System.out.println("Password:"+ excel.getCellData(1,1));
        System.out.println("Expected:"+ excel.getCellData(1,2));

        excel.close();
    }
}


