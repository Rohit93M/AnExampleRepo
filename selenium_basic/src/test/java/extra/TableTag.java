package extra;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableTag {
	public static void main(String[] args) {
     WebDriver driver = new ChromeDriver();
     driver.get("https://money.rediff.com/gainers");
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     driver//.findElement(By.xpath("//table[@class='dataTable']"))
     .findElement(By.xpath("//a[contains(text(),'Pix Transmission')]")).click();
     driver.quit();
	}
}
