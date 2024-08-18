package learningAtTekPyramid;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GetProductInfoTest {

	@Test
	public void getProductInfoTest() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.co.in");
		driver.manage().window().maximize();
		
		//search product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone 14", Keys.ENTER);
		
		//capture product info
		String xpath = "//span[text()='Apple iPhone 15 (128 GB) - Green']/../../../..//span[@class='a-price-whole']";
		String price = driver.findElement(By.xpath(xpath)).getText();
		System.out.println(price);
	}
}