package extra;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable2 {
	public static void main(String[] args) {
	
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement table = driver.findElement(By.xpath("//table[@id='customers']"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for(WebElement row:rows)
		{
			List<WebElement> columns = row.findElements(By.tagName("th"));
			 for(WebElement column:columns)
			 {
				 System.out.print(column.getText() + "\t");
			 }
			
			List<WebElement> columnData = row.findElements(By.tagName("td"));
			 for(WebElement data:columnData)
			 {			 
				 System.out.print(data.getText() + "\t");
			 }
		}
		 System.out.println(); 
	}
}
