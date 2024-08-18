package learningAtTekPyramid;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadingMultipleRowsAndColumnsInExcel {
	
	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream(new File("C:\\Users\\ROHIT M\\OneDrive\\Desktop\\data\\testScriptData02.xlsx"));
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("sheet1");
		System.out.println(sheet.getLastRowNum());
		System.out.println(sheet.getRow(1).getLastCellNum());
		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);

			for (int j = 0; j <= row.getLastCellNum()-1; j++) {
				Cell cell = row.getCell(j);
				
				String cellValue = cell.getStringCellValue();
				System.out.print(cellValue+"\t");
			}
			System.out.println();
		}
		workbook.close();
	}

}
