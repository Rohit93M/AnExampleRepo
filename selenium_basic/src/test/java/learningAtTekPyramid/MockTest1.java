package learningAtTekPyramid;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MockTest1 {

		public static void main(String[] args) throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	driver.get("https://demoapps.qspiders.com/ui/frames?sublist=0");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	WebElement frameEle=driver.findElement(By.xpath("//iframe[@class='w-full h-96']"));
	driver.switchTo().frame(frameEle);
	driver.findElement(By.id("username")).sendKeys("abc");
	driver.findElement(By.id("password")).sendKeys("123");
	driver.findElement(By.id("submitButton")).click();
	Thread.sleep(2000);
	driver.quit();
		}

	

}

