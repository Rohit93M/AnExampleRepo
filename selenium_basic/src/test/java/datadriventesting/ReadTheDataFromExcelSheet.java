
package datadriventesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadTheDataFromExcelSheet {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	
File filePath = new File("./src/test/resources/testcasespecificdata01.xlsx");
FileInputStream fis = new FileInputStream(filePath);
Workbook readWorkbook = WorkbookFactory.create(fis);
//int sheetNum = readWorkbook.getNumberOfSheets();
//System.out.println("Number of sheets = "+sheetNum);
Sheet sheet = readWorkbook.getSheet("data");
//Sheet sheet = readWorkbook.getSheetAt(0);

//Row row = sheet.getRow(1);
//Cell cell = row.getCell(0);
//String cellValue = cell.getStringCellValue();
//System.out.println("cellValue= "+cellValue);

//Row row = sheet.getRow(1);
//Cell cell = row.getCell(1);
//String cellValue = cell.getStringCellValue();
//System.out.println("cellValue= "+cellValue);
  
//Row row = sheet.getRow(2);
//Cell cell = row.getCell(1);
//long cellValue = (long) cell.getNumericCellValue();
//System.out.println("cellValue= "+cellValue);

//WebDriver driver = new ChromeDriver();
//driver.manage().window().maximize();
//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//driver.get("https://www.facebook.com/");
//driver.findElement(By.id("email")).sendKeys(sheet.getRow(1).getCell(0).getStringCellValue());
//driver.findElement(By.id("pass")).sendKeys(""+(long)sheet.getRow(2).getCell(1).getNumericCellValue());

System.out.println("cell value = "+sheet.getRow(1).getCell(0).getStringCellValue()
		+" cell type = "+sheet.getRow(1).getCell(0).getCellType());
System.out.println("cell value = "+sheet.getRow(1).getCell(1).getStringCellValue()
		+" cell type = "+sheet.getRow(1).getCell(1).getCellType());
System.out.println("cell value = "+(long)sheet.getRow(2).getCell(1).getNumericCellValue()
		+" cell type = "+sheet.getRow(2).getCell(1).getCellType());

//System.out.println(WorkbookFactory.create(new FileInputStream("./src/test/resources/testcasespecificdata01.xlsx")).getSheetAt(0).getRow(1).getCell(0).getStringCellValue());
  }
}