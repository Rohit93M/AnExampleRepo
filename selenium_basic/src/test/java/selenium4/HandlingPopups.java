package selenium4;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.example.genericutility.BaseClass;
import com.example.genericutility.ListenersImplementation;

@Listeners(ListenersImplementation.class)
public class HandlingPopups extends BaseClass {

	@Test
	public void checkWhetherTheUserIsAbleToHandleAlertPopup() throws InterruptedException {
		driver.get("https://demoapps.qspiders.com/ui/alert?sublist=0");
		driver.findElement(By.id("buttonAlert2")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000); 
	}

	@Test
	public void checkWhetherTheUserIsAbleToHandleConfirmationPoup() throws InterruptedException {
		driver.get("https://demoapps.qspiders.com/ui/alert/confirm?sublist=1");
		Thread.sleep(2000);
		driver.findElement(By.id("buttonAlert5")).click();
		Thread.sleep(2000);
		String confirmationMsg = driver.switchTo().alert().getText();
		System.out.println("confirmationMsg " + confirmationMsg);
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();
		Thread.sleep(5000);
	}

	@Test
	public void checkWhetherTheUserIsAbleToHandlePromptPopup() throws InterruptedException {
		driver.get("https://demoapps.qspiders.com/ui/alert/prompt?sublist=2");
		Thread.sleep(3000);
		driver.findElement(By.id("buttonAlert1")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().sendKeys("YES");
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		String promptmsg = driver.switchTo().alert().getText();
		System.out.println("promptmsg" + promptmsg);
		Thread.sleep(2000);
	}

	@Test
	public void checkWhetherTheUserIsAbleToHandleHiddenDivisionPopup() throws InterruptedException {
		driver.get("https://demoapps.qspiders.com/ui/hidden?sublist=0");
		Thread.sleep(5000);
		Actions actions = new Actions(driver);
		actions.click().perform();
		Thread.sleep(5000);
	}

	@Test
	public void checkWhetherTheUserIsAbleToHandleNotificationPopup() throws InterruptedException {
		ChromeOptions opts = new ChromeOptions();
		opts.addArguments("--disable-notifications");
		driver = new ChromeDriver(opts);
		driver.get("https://demoapps.qspiders.com/ui/browserNot?sublist=0");
		Thread.sleep(3000);
	}

	@Test
	public void checkWhetherTheUserIsAbleToHandleFileUploadPopup01() throws InterruptedException {
		driver.get("https://demo.guru99.com/test/upload/");
		WebElement chooseFile = driver.findElement(By.id("uploadfile_0"));
		chooseFile.sendKeys("C:\\Users\\ROHIT M\\OneDrive\\Desktop\\sel\\Rohit_resume.pdf");
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("submitbutton")).click();
		Thread.sleep(2000);
	}
	
	  @Test
	  public void checkWhetherTheUserIsAbleToHandleFileUploadPopup02() {
		  
	    driver.get("https://the-internet.herokuapp.com/upload");
	    File uploadFile = new File("src/test/resources/selenium-snapshot.png");

	    WebElement fileInput = driver.findElement(By.cssSelector("input[type=file]"));
	    fileInput.sendKeys(uploadFile.getAbsolutePath());
	    driver.findElement(By.id("file-submit")).click();

	    WebElement fileName = driver.findElement(By.id("uploaded-files"));
	    Assert.assertEquals("selenium-snapshot.png", fileName.getText());
	  }

//	@Test
//	public void checkWhetherTheUserIsAbleToHandleFileDownloadPopup() throws InterruptedException, AWTException {
//		driver.get("https://www.selenium.dev/downloads/");
//		Thread.sleep(2000);
//		
//		Actions actions = new Actions(driver);
//		actions.click(driver.findElement(By.linkText("4.20.0"))).sendKeys(Keys.ENTER).perform();
//		Thread.sleep(2000);
//		driver.navigate().to("chrome://downloads/");
//		WebElement shadowHost01 = driver.findElement(By.tagName("downloads-manager"));
//		SearchContext shadowRoot01 = shadowHost01.getShadowRoot();
//		WebElement shadowHost02 = shadowRoot01.findElement(By.id("frb0"));
//		SearchContext shadowRoot02 = shadowHost02.getShadowRoot();
//		Thread.sleep(2000);
//		WebElement keepButtonTargetEle = shadowRoot02.findElement(By.cssSelector("cr-button[focus-type='save']"));
//		keepButtonTargetEle.click();
//		
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_TAB);
//		robot.keyRelease(KeyEvent.VK_TAB);
//		Thread.sleep(2000);
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
//
//	}

	@Test																										
	public void checkWhetherTheUserIsAbleToHandleChildBrowserPopup() {

		driver.get("https://demoapps.qspiders.com/ui/browser?sublist=0");
		String pwid = driver.getWindowHandle();
		driver.findElement(By.linkText("Open in new window")).click();
		Set<String> allWids = driver.getWindowHandles();

		for (String wid : allWids) {
			System.out.println(allWids);
			// System.out.println("hi");
			String curUrl = driver.switchTo().window(wid).getCurrentUrl();
			System.out.println(wid + " " + curUrl);
			String expUrl = "https://demoapps.qspiders.com/ui/browser/SignUpPage";

			if (curUrl.equals(expUrl)) {
				driver.findElement(By.id("email")).sendKeys("rohit");
				driver.findElement(By.id("password")).sendKeys("rohit");
				driver.findElement(By.id("confirm-password")).sendKeys("rohit");
				driver.findElement(By.xpath("//button[@type='submit']")).submit();
			}
		}
		
		String parentWinURL = driver.switchTo().window(pwid).getCurrentUrl();
		System.out.println("parentWinURL= "+parentWinURL);
		driver.close();
	}

	@Test
	public void checkWhetherTheUserIsAbleToHandleAuthenticationPopup() throws InterruptedException {
		String username = "admin";
		String password = "admin";
		Thread.sleep(2000);
		driver.get("http://"+username+":"+password+"@the-internet.herokuapp.com/basic_auth");
		Thread.sleep(2000);	
	}
}
