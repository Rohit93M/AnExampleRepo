package selenium4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.example.genericutility.BaseClass;
import com.example.genericutility.ListenersImplementation;

@Listeners(ListenersImplementation.class)
public class LearningMethodsOfActionsClass extends BaseClass {

	@Test
	public void writeAScriptToPerformClickActionOnAWebpage() throws InterruptedException {

		driver.get("https://www.google.co.in");
		Window window = driver.manage().window();
		System.out.println("Position before click= " + window.getPosition());

		// By default the driver control is at (-8,-8) before click

		Actions actions = new Actions(driver);
		
		actions.click();
		System.out.println("Position after click= " + window.getPosition());
		
		actions.contextClick();
		System.out.println("Position after right click= " + window.getPosition());

		// It should remain at (-8,-8) after click and right click
		System.out.println("script successfully executed");
	}

	@Test
	public void writeAScriptToPerformClickActionOnAnEle01() throws InterruptedException {

		driver.get("https://www.facebook.com/");
		WebElement loginButton = driver.findElement(By.name("login"));
		Actions actions = new Actions(driver);
		// actions.contextClick().perform();
		actions.click(loginButton).perform();
		Thread.sleep(2000);

		// Script to capture error text and color of error text
		WebElement errorMessage = driver.findElement(By.xpath("//div[@class='_9ay7']"));
		String errorMsgText = errorMessage.getText();
		Thread.sleep(2000);
		System.out.println("errorMsgText= " + errorMsgText);
		String colorOferrorMsg = errorMessage.getCssValue("color");
		System.out.println("colorOferrorMsg= " + colorOferrorMsg);
		String hexadecimalValue = Color.fromString(colorOferrorMsg).asHex();
		System.out.println("hexadecimalValue= " + hexadecimalValue);
		System.out.println("script successfully executed!");
	}

	@Test
	public void writeAScriptToPerformClickActionOnAnEle02() throws InterruptedException {

		try {

			driver.get("https://jqueryui.com/droppable/");
			WebElement demoEle = driver.findElement(By.xpath("//a[text()='Demos']"));

			new Actions(driver).moveToElement(demoEle).click(demoEle);

			System.out.println(driver.getTitle());
			Assert.assertEquals("Draggable | jQuery UI", "jQuery UI Demos | jQuery UI");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void writeAScriptToPerformRightClickOnTheTargetEle() {
		driver.get("https://www.facebook.com/");
		WebElement emailTextField = driver.findElement(By.id("email"));
		Actions actions = new Actions(driver);
		actions.contextClick(emailTextField).perform();
		System.out.println("script successfully executed!");
	}

	@Test
	public void writeAScriptToPerformDoubleClickOnTheTargetEle() throws InterruptedException {
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		Actions actions = new Actions(driver);
		WebElement doubleClickEle = driver.findElement(By.xpath("//button [text()='Double-Click Me To See Alert']"));
		actions.doubleClick(doubleClickEle).perform();
		;
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();
		Thread.sleep(2000);
		// actions.click(doubleClickEle).perform();
		// actions.contextClick(doubleClickEle).perform();
		System.out.println("script successfully executed!");
	}

	@Test
	public void writeAScriptToEnterDataWithSendKeys() {
		driver.get("https://www.facebook.com/");
		Actions actions = new Actions(driver);
		WebElement emailTextField = driver.switchTo().activeElement();
		actions.sendKeys(emailTextField, "rohit93m@gmail.com").perform();
		WebElement passwordTextField = driver.findElement(By.id("pass"));
		actions.sendKeys(passwordTextField, "Rohit@1993").perform();
		System.out.println("script successfully executed!");
	}

	@Test
	public void writeAScriptToScrollToTheTargetEle() throws InterruptedException {
		driver.get("https://www.demo.co-vin.in/");
		WebElement searchOpt = driver.findElement(By.xpath("//button[text()='Search']"));
		Actions actions = new Actions(driver);
		Thread.sleep(3000);
		actions.scrollToElement(searchOpt).perform();
		Thread.sleep(3000);
		System.out.println("script successfully executed!");
	}

	@Test
	public void writeAScriptToScrollByOffsetOnWebPage() throws InterruptedException {
		driver.get("https://www.demo.co-vin.in/");
		Actions actions = new Actions(driver);
		actions.scrollByAmount(0, 3000).perform();
		Thread.sleep(2000);
		actions.scrollByAmount(0, -1000).perform();
		System.out.println("script successfully executed!");
	}

	@Test
	public void writeAScriptToPerformClickHoldAndReleaseOperationOnAWebEle() {
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(0);
		WebElement draggableEle = driver.findElement(By.id("draggable"));
		WebElement droppableEle = driver.findElement(By.id("droppable"));
		Actions actions = new Actions(driver);
		actions.clickAndHold(draggableEle).pause(2000).release(droppableEle).pause(2000).perform();
		System.out.println("script successfully executed!");
	}

	@Test
	public void writeAScriptToDragAndDropToTheTragetEle() {
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(0);
		WebElement srcEle = driver.findElement(By.id("draggable"));
		WebElement targetEle = driver.findElement(By.id("droppable"));
		Actions actions = new Actions(driver);
		// actions.clickAndHold(srcEle).release(targetEle).perform();
		actions.dragAndDrop(srcEle, targetEle).perform();
		System.out.println("script successfully executed!");
	}

	@Test
	public void writeAScriptToPerformDragAndDropByOffsetOnAWebEle() {
		driver.get("https://jqueryui.com/draggable/");
		driver.switchTo().frame(0);
		WebElement draggableEle = driver.findElement(By.id("draggable"));
		Actions actions = new Actions(driver);
		actions.dragAndDropBy(draggableEle, 100, 60).pause(1000).perform();
		System.out.println("script successfully executed!");
	}

	@Test
	public void writeAScriptToPerformKeyUpAndKeyDownActionOnAWebEle() {
		driver.get("https://demo.vtiger.com/vtigercrm/");
		WebElement passwordTextField = driver.findElement(By.id("password"));
		Actions actions = new Actions(driver);
		actions.keyDown(passwordTextField, Keys.CONTROL).sendKeys(passwordTextField, "a")
				.keyUp(passwordTextField, Keys.CONTROL).sendKeys(passwordTextField, Keys.DELETE)
				.sendKeys(passwordTextField, "admin").perform();
		System.out.println("script successfully executed!");
	}

	@Test
	public void writeAScriptToMoveToATargetEle() {
		driver.get("https://www.myntra.com/");
		WebElement menOpt = driver.findElement(By.xpath("//div [@class='desktop-navLink']/a[text()='Men']"));
		WebElement womenOpt = driver.findElement(By.xpath("//div [@class='desktop-navLink']/a[text()='Women']"));
		WebElement kidOpt = driver.findElement(By.xpath("//div [@class='desktop-navLink']/a[text()='Kids']"));
		WebElement homeAndLivingOpt = driver
				.findElement(By.xpath("//div[@class='desktop-navLink']/a[text()='Home & Living']"));
		WebElement beautyOpt = driver.findElement(By.xpath("//div [@class='desktop-navLink']/a[text()='Beauty']"));
		WebElement studioOpt = driver.findElement(By.xpath("//div [@class='desktop-navLink']/a[text()='Studio']"));
		Actions actions = new Actions(driver);

		// actions.moveToElement(menOpt).pause(1000).moveToElement(womenOpt)
		// .pause(1000).moveToElement(kidOpt).pause
		// (1000).moveToElement(homeAndLivingOpt)
		// .pause(1000).moveToElement(beautyOpt).pause
		// (1000).moveToElement(studioOpt).build().perform();

		// actions.moveToElement (menOpt, 0, 0).pause (2000).moveToElement (menOpt, 75,
		// 0).pause(2000).moveToElement (womenOpt, 76,
		// 0).pause(2000).moveToElement(kidOpt, 99,
		// 0).pause (2000).moveToElement(homeAndLivingOpt, 108,
		// 0).pause(2000).moveToElement(beautyOpt, 84, 0).build().perform();

		actions.moveToElement(menOpt, 0, 0).pause(2000).moveToElement(menOpt, 75, 0).pause(2000)
				.moveToElement(menOpt, 150, 0).pause(2000).moveToElement(menOpt, 248, 0).pause(2000)
				.moveToElement(menOpt, 356, 0).pause(2000).moveToElement(menOpt, 440, 0).build().perform();
		System.out.println("script successfully executed!");
	}

	@Test
	public void writeAScriptToToMoveToAllTheElementsInRangeRoverCarsWebpage() {
		driver.get(
				"https://www.landrover.in/range-rover/range-rover/index.html?utm_source=Google&utm_medium=CPC&utm_campaign=IN_Jul23_LR_PRD_RR_SEM&utm_content=New_RR_P1_Exact_Always_On&gad_source=1&gclid=Cj0KCQiAwbitBhDIARIsABfFYIK-DineZDv1vJ48kLR5ORcOA0QlLZ2gjJ6k3Ov57Dm7AsWb0XYcaeUaAtPyEALw_wcB&gclsrc=aw.ds");
		driver.findElement(By.xpath("//span[text()='VEHICLES']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleIs("Range Rover 2023 | Luxury Performance SUV | Range Rover"));

		WebElement evoque = driver.findElement(By.xpath("(//span[@class='dxnav-vehicle-nav__image'])[1]"));
		WebElement velar = driver.findElement(By.xpath("(//span[@class='dxnav-vehicle-nav__image'])[2]"));
		WebElement rrSport = driver.findElement(By.xpath("(//span[@class='dxnav-vehicle-nav__image'])[3]"));
		WebElement rangeRover = driver.findElement(By.xpath("(//span[@class='dxnav-vehicle-nav__image'])[4]"));
		WebElement d130 = driver.findElement(By.xpath("(//span[@class='dxnav-vehicle-nav__image'])[5]"));
		WebElement d110 = driver.findElement(By.xpath("(//span[@class='dxnav-vehicle-nav__image'])[6]"));
		WebElement d90 = driver.findElement(By.xpath("(//span[@class='dxnav-vehicle-nav__image'])[7]"));
		WebElement discoverySport = driver.findElement(By.xpath("(//span[@class='dxnav-vehicle-nav__image'])[8]"));
		WebElement discovery = driver.findElement(By.xpath("(//span[@class='dxnav-vehicle-nav__image'])[9]"));

		Actions actions = new Actions(driver);
		actions.moveToElement(evoque).pause(1000).moveToElement(velar).pause(1000).moveToElement(rrSport).pause(1000)
				.moveToElement(rangeRover).pause(1000).moveToElement(d130).pause(1000).moveToElement(d110).pause(1000)
				.moveToElement(d90).pause(1000).moveToElement(discoverySport).pause(1000).moveToElement(discovery)
				.build().perform();
	}

	@Test
	public void writeAScriptToHAandleTheSliderEle() throws InterruptedException {

		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		Actions actions = new Actions(driver);

		WebElement minSlider = driver.findElement(By.xpath("//span[1]"));
		System.out.println("Location of the minimum slider = " + minSlider.getLocation());
		System.out.println("Height and width of the minimum slider = " + minSlider.getSize());

		actions.dragAndDropBy(minSlider, 100, 0).perform();
		System.out.println("Location of the minimum slider after sliding = " + minSlider.getLocation());
		System.out.println("Height and width of the minimum slider after sliding = " + minSlider.getSize());
		System.out.println();

		WebElement maxSlider = driver.findElement(By.xpath("//span[2]"));
		System.out.println("Location of the maximum slider = " + maxSlider.getLocation());
		System.out.println("Height and width of the maximum slider = " + maxSlider.getSize());

		actions.dragAndDropBy(maxSlider, -200, 0).perform();
		System.out.println("Location of the minimum slider after sliding = " + maxSlider.getLocation());
		System.out.println("Height and width of the maximum slider after sliding = " + maxSlider.getSize());

		Thread.sleep(3000);

	}

}
