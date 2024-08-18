package learningAtTekPyramid;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckRadioButtons {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		List<WebElement> radioBtns = driver.findElements(By.xpath("//input[@type='radio']"));
		for (WebElement btn : radioBtns) {
			btn.click();
			System.out.println(btn.isSelected());
		}
		driver.close();
	}

}
