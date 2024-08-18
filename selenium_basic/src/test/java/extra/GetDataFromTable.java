package extra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.example.genericutility.BaseClass;

public class GetDataFromTable extends BaseClass {

	@Test
	public void countNumberOfRowsAndColumnsInATable() throws InterruptedException {
		driver.get("C:\\Users\\ROHIT M\\OneDrive\\Desktop\\Assignment1.html");

		int rowsCount = driver.findElements(By.xpath("//table[@border='1']/tbody/tr")).size();
		System.out.println("No. of rows= " + rowsCount);
		int columnCount = driver.findElements(By.xpath("//table[@border='1']/thead/tr/th")).size();
		System.out.println("No. of columns= " + columnCount);
	}

	@Test
	public void checkWhetherTheUserIsAbleToFetchSpecificDataFromTheTable() throws InterruptedException {
		driver.get("C:\\Users\\ROHIT M\\OneDrive\\Desktop\\Assignment1.html");
		int r = 5;
		int c = 2;
		WebElement data = driver.findElement(By.xpath("//table[@border='1']/tbody/tr["+r+"]/td["+c+"]"));
		System.out.println("The value is " + data.getText());
	}
	
	@Test
	public void checkWhetherTheUserIsAbleToFetchLastRowData() throws InterruptedException {
		driver.get("C:\\Users\\ROHIT M\\OneDrive\\Desktop\\Assignment1.html");

		WebElement data = driver.findElement(By.xpath("//table[@border='1']/tbody/tr[last()]/td[last()]"));
		System.out.println("The value is " + data.getText());
	}

	@Test
	public void checkWhetherTheUserIsAbleToFetchAllDataFromTheTable() throws InterruptedException {
		driver.get("C:\\Users\\ROHIT M\\OneDrive\\Desktop\\Assignment2.html");

		int rowsCount = driver.findElements(By.xpath("//table[@border='1']/tbody/tr")).size();
		int columnCount = driver.findElements(By.xpath("//table[@border='1']/thead/tr/th")).size();

		for (int r = 1; r <= rowsCount; r++) {
			for (int c = 1; c <= columnCount; c++) {
				WebElement data = driver
						.findElement(By.xpath("//table[@border='1']/tbody/tr["+r+"]/td["+c+"]"));
				System.out.print(data.getText() + " ");
			}
			System.out.println();
		}
	}

	@Test
	public void checkWhetherTheUserIsAbleToFetchSpecificDataFromTheTableBasedOnCondition() throws InterruptedException {
		driver.get("C:\\Users\\ROHIT M\\OneDrive\\Desktop\\Assignment2.html");

		int rowsCount = driver.findElements(By.xpath("//table[@border='1']/tbody/tr")).size();

		for (int r = 1; r <= rowsCount; r++) {
			String cid = driver.findElement(By.xpath("//table[@border='1']/tbody/tr["+r+"]/td[1]")).getText();
			if (cid.equals("5")) {
				String name = driver.findElement(By.xpath("//table[@border='1']/tbody/tr["+r+"]/td[2]")).getText();
				String product = driver.findElement(By.xpath("//table[@border='1']/tbody/tr["+r+"]/td[4]")).getText();
				System.out.println(cid+" "+name+" "+product);
			}
		}
	}
}
