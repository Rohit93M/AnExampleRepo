package learningAtTekPyramid;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class WorkingWithShadowRoot {
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoapps.qspiders.com/ui/shadow?sublist=0");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		SearchContext shadowHost1 = driver.findElement(By.xpath("//form/div[1]")).getShadowRoot();
	    shadowHost1.findElement(By.cssSelector("input[type='text']")).sendKeys("Rohit");
	    SearchContext shadowHost2 = driver.findElement(By.xpath("//form/div[2]")).getShadowRoot();
	    shadowHost2.findElement(By.cssSelector("input[type='text']")).sendKeys("123");
	}
}