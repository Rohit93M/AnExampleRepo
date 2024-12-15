package extra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Try {
	public static void main(String[] args)  {
		WebDriver driver = new ChromeDriver();
		driver.get("https://fitpeo.com/revenue-calculator");
		WebElement ele = driver.findElement(By.xpath("//span[contains(@class,'MuiSlider-thumb')]"));
		System.out.println(ele.getLocation().getX());
		
		Actions actions = new Actions(driver);
		actions.dragAndDropBy(ele, 93, 0).perform();
		System.out.println(ele.getLocation().getX());
		;
	}
}
