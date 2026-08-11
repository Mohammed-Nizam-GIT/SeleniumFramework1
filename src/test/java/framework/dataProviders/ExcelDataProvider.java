package framework.dataProviders;
import framework.utils.ExcelUtil;
import org.testng.annotations.DataProvider;
import java.io.IOException;

public class ExcelDataProvider {
    @DataProvider(name = "loginData")
    public Object[][] getLoginData() throws IOException {

        String path = "src/test/resources/testdata/LoginData.xlsx";
        ExcelUtil excel = new ExcelUtil(path, "LoginData");

        int rowCount = excel.getRowCount();
        int columnCount = excel.getColumnCount();

        Object[][] data = new Object[rowCount - 1][columnCount];

        for (int i = 1; i < rowCount; i++) {

            for (int j = 0; j < columnCount; j++) {

                data[i - 1][j] = excel.getCellData(i, j);
            }
        }

        excel.close();

        return data;
    }
}
