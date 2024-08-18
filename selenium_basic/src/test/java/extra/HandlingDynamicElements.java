package extra;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HandlingDynamicElements {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.name("q")).sendKeys("Iphone 14 pro");
		driver.findElement(By.xpath("//button[contains(@aria-label,'Search')]")).click();
		
		WebElement ratingEle = driver.findElement(By.xpath(
				"//div[text()='Apple iPhone 14 Pro (Space Black, 512 GB)']/../descendant::div[@class='XQDdHH']"));
		WebElement priceEle = driver.findElement(By.xpath(
				"//div[text()='Apple iPhone 14 Pro (Space Black, 512 GB)']/ancestor::div[@class='yKfJKb row']/descendant::div[@class='Nx9bqj _4b5DiR']"));
		
		System.out.println("Price of iPhone 14 Pro = " + priceEle.getText() + " and Rating = " + ratingEle.getText());
		driver.quit();
	}
}
