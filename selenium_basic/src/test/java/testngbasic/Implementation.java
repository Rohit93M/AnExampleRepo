package testngbasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Implementation {
	WebDriver driver;

	@BeforeMethod
	public void preCondition() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void postCondition() {
		driver.manage().window().minimize();
		driver.quit();
	}

	@Test(priority = 2)
	public void loginToVtiger() throws InterruptedException {
		driver.get("https://demo.vtiger.com/vtigercrm/");
		WebElement usernameTextfield = driver.findElement(By.id("username"));
		usernameTextfield.clear();
		usernameTextfield.sendKeys("Admin");
		WebElement passwordTextfield = driver.findElement(By.id("password"));
		passwordTextfield.clear();
		passwordTextfield.sendKeys("123456");
		driver.findElement(By.xpath("//button[text()='Sign in']")).submit();
		Thread.sleep(4000);
	}

	@Test(priority = 1)
	public void loginToFacebook() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("admin");
		driver.findElement(By.id("pass")).sendKeys("123456");
		driver.findElement(By.name("login")).submit();
		Thread.sleep(3000);
	}
}
