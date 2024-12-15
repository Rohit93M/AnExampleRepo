package extra;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//Code is not working right now
public class currencyConvert {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.xe.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions actions = new Actions(driver);
		WebElement element = driver
				.findElement(By.xpath("//div[@class='sc-4f0f6f94-0 diOrXh']/descendant::span[@class='amount-input']"));
		actions.moveToElement(element).click().sendKeys("100").perform();
//			element.click();
//			element.sendKeys("100");
		WebElement ele = driver
				.findElement(By.xpath("//ul[@id='midmarketFromCurrency-listbox']//span[text()='Indian Rupee']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(ele));
		ele.click();

	}

}
