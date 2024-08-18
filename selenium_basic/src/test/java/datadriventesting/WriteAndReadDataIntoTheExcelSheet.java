package datadriventesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteAndReadDataIntoTheExcelSheet {

public static void main(String[] args) throws IOException {

// Created Workbook
XSSFWorkbook createdWorkBook = new XSSFWorkbook();
// Create the sheet in the workbook 
XSSFSheet createdSheet = createdWorkBook.createSheet("createdSheet");
// Create the row in the sheet
XSSFRow createdRow = createdSheet.createRow(0); 
// create a cell in the preferred row
XSSFCell createdCell = createdRow.createCell(0);
// write The data in the created cell 
createdCell.setCellValue (12344);
// Create a file type object with it's relative path 
File filePath = new File("./src/test/resources/createdexcelsheet.xlsx");
// pass the file path in FileOutputStream
FileOutputStream fos = new FileOutputStream(filePath);
// assign the data to the file created
createdWorkBook.write(fos);
// terminate the workbook
createdWorkBook.close();
// Create the fileInputStream Object
FileInputStream fis = new FileInputStream("./src/test/resources/createdexcelsheet.xlsx");
Workbook readWorkbook = WorkbookFactory.create(fis);
Sheet sheet = readWorkbook.getSheet("createdSheet");
Row row = sheet.getRow(0); 
Cell cell = row.getCell(0);
CellType cellType = cell.getCellType();
System.out.println(cellType);
double cellData = cell.getNumericCellValue();
System.out.println((long)cellData);
    }
}