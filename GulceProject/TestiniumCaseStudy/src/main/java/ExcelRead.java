import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.WebDriver;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class ExcelRead extends BasePage{

    public ExcelRead(WebDriver driver) throws FileNotFoundException {
           super(driver);
        FileInputStream file = new FileInputStream("src/main/resources/Beymen.xlsx");
        //Workbook workbook = new XSSFWorkbook(file);


    }
}
