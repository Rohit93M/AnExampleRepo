package selenium4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.example.genericutility.BaseClass;

public class HandlingFrames extends BaseClass {

	@Test
	public void writeAScriptToSwitchToFrameInDream11Webpage() throws InterruptedException {
		driver.get("https://www.dream11.com/");
		Thread.sleep(3000);
		driver.switchTo().frame(0);
		driver.findElement(By.id("regEmail")).sendKeys("7760360284");
		Thread.sleep(3000);
		driver.findElement(By.id("regUser")).click();
		Thread.sleep(3000);
	}

	@Test
	public void writeAScriptToSwitchToFrameAndEnterData() {
		driver.get("https://demoapps.qspiders.com/ui/frames?scenario=1");
		WebElement iFrameEle = driver.findElement(By.xpath("//iframe[@class='w-full h-96']"));
		driver.switchTo().frame(iFrameEle);
		WebElement emailTextField = driver.findElement(By.id("username"));
		emailTextField.sendKeys("rohit93m@gmail.com");
		WebElement passwordTextField = driver.findElement(By.id("password"));
		passwordTextField.sendKeys("Rohit@1993");
		WebElement submitButton = driver.findElement(By.id("submitButton"));
		submitButton.submit();
	}

	@Test
	public void checkWhetherTheGivenFrameIsANestedFrame() throws InterruptedException {
		WebElement IframewithinanIframe = driver.findElement(By.linkText("Iframe with in an Iframe"));
		IframewithinanIframe.click();
		WebElement parentFrame = driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
		driver.switchTo().frame(parentFrame);
		WebElement childFrame = driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']"));
		driver.switchTo().frame(childFrame);
		WebElement textField = driver.findElement(By.xpath("//input[@type='text']"));
		textField.sendKeys("Selenium");
		Thread.sleep(3000);
	}

	@Test
	public void writeAScriptToHandleNestedFramesInW3CWebpage() {
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");
		WebDriver parentFrame = driver.switchTo().frame("iframeResult");
		WebElement childFrame = driver.findElement(By.xpath("//iframe[@src='demo_iframe.htm']"));
		driver.switchTo().frame(childFrame);
		String childFrameText = driver.findElement(By.tagName("h1")).getText();
		System.out.println("childFrameText " + childFrameText);
		driver.switchTo().parentFrame();
		String parentFrameText = driver.findElement(By.tagName("h2")).getText();
		System.out.println("parentFrameText " + parentFrameText);
	}

	@Test
	public void writeAScriptToSwitchToMultipleFrames() {
		driver.get("https://demoapps.qspiders.com/ui/frames/multiple?sublist=2");
		WebElement signupFrame = driver.findElement(By.xpath("(//iframe)[1]"));
		driver.switchTo().frame(signupFrame);
		driver.findElement(By.id("email")).sendKeys("Admin@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Admin@1234");
		driver.findElement(By.id("confirm-password")).sendKeys("Admin@1234");
		driver.switchTo().defaultContent();
		WebElement loginFrame = driver.findElement(By.xpath("(//iframe)[2]"));
		driver.switchTo().frame(loginFrame);
		driver.findElement(By.id("username")).sendKeys("SuperAdmin@gmail.com");
		driver.findElement(By.id("password")).sendKeys("SuperAdmin@1234");
	}
}
