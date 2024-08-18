package selenium4;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.example.genericutility.BaseClass;

public class JavascriptExecutorUsage extends BaseClass {

	@Test
	public void writeAScriptToClickElementUsingJavaScript() throws InterruptedException {
		try {
			driver.get("https://omayo.blogspot.com/");

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.getElementById('alert1').click();");
			Thread.sleep(3000);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void writeAScriptToEnableDisabledButton() throws InterruptedException {

		try {

			driver.get("https://omayo.blogspot.com/");

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.getElementById('but1').disabled = false;");
			Thread.sleep(2000);
			js.executeScript("document.getElementById('but1').click();");
			Thread.sleep(3200);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void writeAScriptToDisableEnabledButton() throws InterruptedException {

		try {
			driver.get("https://omayo.blogspot.com/");

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.getElementById('but2').disabled = true;");
			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void writeAScriptToSendTextToDisabledTextBox() {

		try {

			driver.get("https://omayo.blogspot.com/");

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.getElementById('tb2').disabled = false;");
			js.executeScript("document.getElementById('tb2').value = 'Rohit';");
			Thread.sleep(3000);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void writeAScriptToScrollWebpageByUsingJSE() throws InterruptedException {

		driver.get("https://www.wikipedia.org/");

		new Actions(driver).sendKeys(driver.switchTo().activeElement())
		.sendKeys("India").sendKeys(Keys.ENTER).perform();
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		long webpageHeight = (long) jse.executeScript("return document.body.scrollHeight");
		System.out.println("webpageHeight = " + webpageHeight); //webpageHeight = 37856

		jse.executeScript("window.scrollBy(0,14000)");
		Thread.sleep(4000);
		jse.executeScript("window.scrollBy(0,-5000)");
		Thread.sleep(4000);
		jse.executeScript("window.scrollTo(0,10000)");
		Thread.sleep(4000);
		jse.executeScript("window.scrollTo(0,-8000)");
		Thread.sleep(4000);
	}

}
