package selenium4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.example.genericutility.BaseClass;
import com.example.genericutility.ListenersImplementation;

@Listeners(ListenersImplementation.class)
public class PerformASeriesOfActions extends BaseClass {
	
	@Test
	public void scriptToPerformASetOfActions() throws InterruptedException {

		try {

			driver.navigate().to("https://www.facebook.com/");

			WebElement ele = driver.findElement(By.xpath("//*[@id='email']"));

			Actions actions = new Actions(driver);
			// Below line sends some text to field by converting it to upper case, then
			// double click the text so that it will select all, then do right click
			actions.moveToElement(ele)
			.click()
			.keyDown(ele, Keys.SHIFT)
			.sendKeys("Rohit")
			.keyUp(ele, Keys.SHIFT)
			.doubleClick(ele)
			.contextClick(ele)
			//.build()
			.perform();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
