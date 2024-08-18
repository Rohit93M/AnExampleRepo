package extra;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DemoWebShopScenario {

	@Test
	public void sample() {
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		prefs.put("autofill.profile_enabled", false);
		options.setExperimentalOption("prefs", prefs);

		WebDriver driver = new ChromeDriver(options);

		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("gender-female")).click();
		driver.findElement(By.id("FirstName")).sendKeys("Lakshmi");
		driver.findElement(By.id("LastName")).sendKeys("s");
		driver.findElement(By.id("Email")).sendKeys("satrasala.lakshmi@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("Lakshmi@123");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("Lakshmi@123");
		driver.findElement(By.id("register-button")).click();

		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys("satrasala.lakshmi@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("Lakshmi@123");
		// driver.findElement(By.xpath("//input[@value='Continue']")).click();

		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		WebElement electonics = driver.findElement(By.xpath("//li/a[contains(text(),'Electronics')]"));
		Actions a = new Actions(driver);
		a.moveToElement(electonics).perform();
		driver.findElement(By.partialLinkText("Cell phones")).click();
		WebElement sortBy = driver.findElement(By.id("products-orderby"));
		WebElement display = driver.findElement(By.id("products-pagesize"));
		WebElement view = driver.findElement(By.id("products-viewmode"));
		Select s1 = new Select(sortBy);
		s1.selectByIndex(3);

		String price = driver.findElement(By.xpath("//a[text()='Smartphone']/../../div[3]/div/span")).getText();
		System.out.println("price: " + price);
		driver.findElement(By.linkText("Smartphone")).click();
		driver.findElement(By.xpath("//input[@value='Add to cart']")).click();
		String text = driver.findElement(By.xpath("//p[text()='The product has been added to your ']")).getText();
		System.out.println(text);
		driver.findElement(By.linkText("shopping cart")).click();
		driver.findElement(By.id("termsofservice")).click();
		driver.findElement(By.id("checkout")).click();
		WebElement add = driver.findElement(By.name("billing_address_id"));
		Select s4 = new Select(add);
		s4.selectByVisibleText("New Address");
		WebElement country = driver.findElement(By.id("BillingNewAddress_CountryId"));
		Select s5 = new Select(country);
		s5.selectByIndex(3);
		driver.findElement(By.id("BillingNewAddress_City")).sendKeys("chicago");
		driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("abcde");
		driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("1234567");
		driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("1234567790");

		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		driver.findElement(By.xpath("(//input[@value='Continue'])[2]")).click();
		driver.findElement(By.xpath("(//input[@value='Continue'])[3]")).click();
		driver.findElement(By.xpath("(//input[@value='Continue'])[4]")).click();
		driver.findElement(By.xpath("(//input[@value='Continue'])[5]")).click();
		driver.findElement(By.xpath("(//input[@value='Confirm'])")).click();
		String order_no = driver.findElement(By.xpath("//li[contains(text(),'Order number')]")).getText();
		System.out.println(order_no);
		driver.quit();
	}
}
