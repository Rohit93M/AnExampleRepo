package selenium4;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.example.genericutility.BaseClass;

public class ActiveElement extends BaseClass {

	@Test
	public void checkWhetherTheUserIsAbleToEnterTheDataToActiveElement() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.facebook.com/");
		Actions actions = new Actions(driver);
		actions.sendKeys(driver.switchTo().activeElement()).sendKeys("rohit93m@gmail.com").sendKeys(Keys.TAB)
				.sendKeys("Rohit@1993").perform();
	}

	@Test
	public void checkWhetherTheUserIsAbleToCaptureTextFromAutoSuggestions() {
		driver.get("https://www.google.com/");
		driver.switchTo().activeElement().sendKeys("Selenium");
		List<WebElement> autoSug = driver.findElements(By.xpath("//div[@role='presentation']/ul/li"));
		for (WebElement sug : autoSug) {
			String sugText = sug.getText();
			System.out.println("sugText= " + sugText);
			if (sugText.contains("interview questions")) {
				sug.click();
				break;
			}
		}
	}

	@Test
	public void checkWhetherTheUserIsAbleToCaptureTextFromDefaultSuggestions() {
		driver.get("https://www.google.com/");
		List<WebElement> defaultSug = driver.findElements(By.xpath("//div[@role='presentation']/ul/li"));
		for (WebElement sug : defaultSug) {
			String sugText = sug.getText();
			System.out.println("sugText= " + sugText);
			if (sugText.contains("atos news")) {
				sug.click();
				break;
			}
		}
	}
}
