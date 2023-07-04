package actitime.GenericLib;


import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

public class DataUtility {
    public String getDataFromPropertiesFile(String key) throws IOException {
        FileInputStream fis =new FileInputStream
                ("C:\\Users\\ASHISH\\Desktop\\institute selenium DDT\\ActitimeProject\\files\\Actitime.properties");
        Properties property = new Properties();
        property.load(fis);
        return property.getProperty(key);
    }
    public String getDataFromExcelFile(String sheetName,int rowNum,int cellNum) throws IOException {
        FileInputStream fis =new FileInputStream
                ("C:\\Users\\ASHISH\\Desktop\\institute selenium DDT\\ActitimeProject\\files\\ActiTimeProjectFile.xlsx");
        Workbook workbook= WorkbookFactory.create(fis);
        Sheet sheet=workbook.getSheet(sheetName);
        DataFormatter dataFormatter = new DataFormatter();
        return dataFormatter.formatCellValue(sheet.getRow(rowNum).getCell(cellNum));
    }

}
