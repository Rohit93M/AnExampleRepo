package learningAtTekPyramid;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWithAutoSuggestions {
	public static void main(String[] args){
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.name("q")).sendKeys("Puma");
//		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),' flip flops')]")).click();
		driver.close();
//		driver.quit();
	}
}
