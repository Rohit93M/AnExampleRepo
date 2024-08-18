package extra;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadAndWriteExcelDataIn2DArray {
	@Test
	public void checkWhetherTheUserIsAbleToReadTheDataIn2DArray() throws InvalidFormatException, IOException {

		File file = new File("./src/test/resources/2darraysample.xlsx");
		Object[][] arr = new Object[0][0];
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("data");
		int start = sheet.getFirstRowNum();
		int end = sheet.getLastRowNum();
		arr = new Object[end - start + 1][4];
		for (int i = start; i <= end; i++) {
			arr[i][0] = sheet.getRow(i).getCell(0).getStringCellValue();
			arr[i][1] = (long) sheet.getRow(i).getCell(1).getNumericCellValue();
			arr[i][2] = sheet.getRow(i).getCell(2).getBooleanCellValue();
			arr[i][3] = (long) sheet.getRow(i).getCell(3).getNumericCellValue();
			System.out.println(arr[i][0]);
			System.out.println(arr[i][1]);
			System.out.println(arr[i][2]);
			System.out.println(arr[i][3]);

		}
	}

	@Test
	public void checkWhetherTheUserIsAbleToWriteTheDataIn2DArray() throws InvalidFormatException, IOException {

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Data");

//		String[][] data = new String[3][2];
//		data[0][0] = "Name";
//		data[0][1] = "City";
//		data[1][0] = "Rohit";
//		data[1][1] = "Bangalore";
//		data[2][0] = "Maddy";
//		data[2][1] = "Delhi";

		String[][] data = { { "Name", "Age", "Occupation" }, 
				{ "Rohit", "30", "Tester" },
				{ "Maddy", "29", "Developer" }, 
				{ "Rock", "30", "BA" } };

		// iterate over rows of the array
		for (int i = 0; i < data.length; i++) {
			XSSFRow row = sheet.createRow(i);
			// iterate over columns of the current row
			for (int j = 0; j < data[i].length; j++) {
				XSSFCell cell = row.createCell(j);
				// Set value into cell
				cell.setCellValue(data[i][j]);
				System.out.println(data[i][j]);
			}
		}
		FileOutputStream fileout = new FileOutputStream(new File("./src/test/resources/created2darraysample.xlsx"));
		workbook.write(fileout);
		fileout.close();

	}
}