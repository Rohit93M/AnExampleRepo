package selenium4;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Set;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver.Window;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.example.genericutility.BaseClass;
import com.example.genericutility.ListenersImplementation;

@Listeners(ListenersImplementation.class)
public class LearningMethodsOfWebdriver extends BaseClass {

	@Test
	public void writeAScriptTolaunchChromeBrowser() throws InterruptedException {
//		System.out.println(System.getProperty("user.dir"));

//		Thread.sleep(2000);
//		driver.get("https://facebook.com");
//		Thread.sleep(2000);
//		System.out.println(driver.getPageSource());
//		Thread.sleep(2000);

	}
	
	  @Test
	  public void writeAScriptToGetTitleOfTheCurrentWebpage() {
	 
	      driver.get("https://www.selenium.dev/");
	      // get title
	      String title = driver.getTitle();
	      Assert.assertEquals(title, "Selenium");

	  }
	  
	  @Test
	  public void writeAScriptToGetUrlOfTheCurrentWebpage() {

	      driver.get("https://www.selenium.dev/");
	      // get current url
	      String url = driver.getCurrentUrl();
	      Assert.assertEquals(url, "https://www.selenium.dev/");
	     
	  }
	  
	 @Test
	 public void writeAScriptToNavigateUsingURLObject( ) throws MalformedURLException, URISyntaxException {
		 
			URL url = new URI("https://www.facebook.com").toURL();
	        driver.navigate().to(url);
	 }
	
    @Test
    public void writeScriptToNavigateWithinAWebpage() throws InterruptedException {
      
        //Convenient
        driver.get("https://selenium.dev");
        Thread.sleep(2000);
            
        //Longer way
        driver.navigate().to("https://selenium.dev");
        String title = driver.getTitle();
        Assert.assertEquals(title, "Selenium");
        Thread.sleep(2000);
        
        //Back
        driver.navigate().back();
        title = driver.getTitle();
        Assert.assertEquals(title, "Selenium");
        Thread.sleep(2000);
        
        //Forward
        driver.navigate().forward();
        title = driver.getTitle();
        Assert.assertEquals(title, "Selenium");
        Thread.sleep(2000);
        
        //Refresh
        driver.navigate().refresh();
        title = driver.getTitle();
        Assert.assertEquals(title, "Selenium");
}
	@Test
	public void writeAScriptToDoBackForwardAndRefreshActionsInDassaultWebpage() throws InterruptedException {
		driver.get("https://www.dassault-aviation.com/en/");
		driver.navigate().to("https://www.dassault-aviation.com/en/civil/");
		Thread.sleep(2000);
		driver.navigate().to("https://www.dassault-aviation.com/en/group/");
		Thread.sleep(2000);
		driver.navigate().to("https://www.dassault-aviation.com/en/defense/");
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);		
		driver.navigate().forward();
		Thread.sleep(2000);
		driver.navigate().to("https://www.dassault-aviation.com/en/passion/");
		Thread.sleep(2000);
		driver.navigate().to("https://www.dassault-aviation.com/en/space/");
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
	}

	@Test
	public void writeAScriptToNavigateInDassaultAviationWebpage()
			throws InterruptedException, MalformedURLException, URISyntaxException {
		driver.get("https://www.dassault-aviation.com/en/");
		// Store the main URL
		
	    URL mainUrl = new URI("https://www.dassault-aviation.com/en/").toURL();
		Thread.sleep(2000);
		URL passionPage = new URL(mainUrl, "passion/");
		driver.navigate().to(passionPage);
		Thread.sleep(2000);
		URL defensePage = new URL(mainUrl, "defense/");
		driver.navigate().to(defensePage);
		Thread.sleep(2000);
		URL spacePage = new URL(mainUrl, "space/");
		driver.navigate().to(spacePage);
		Thread.sleep(2000);

		driver.navigate().back();
		Thread.sleep(2000);
	}

	@Test
	public void checkWhetherTheUserIsAbleToDoMultipleOperationsOnWindows() throws InterruptedException {
		
		driver.get("https://www.facebook.com/");
		Thread.sleep(2000);
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.facebook.com/signup");
		
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		
		// Capture all window ids
		Set<String> allWids = driver.getWindowHandles();
		System.out.println(allWids);
		
		for (String wid : allWids) {
			String widTitle = driver.switchTo().window(wid).getTitle();
			System.out.println(widTitle);

			SoftAssert softassert = new SoftAssert();
			// softassert object creation
			softassert.assertEquals("Facebook-log in or sign up", "Sign up for Facebook | Facebook");

			String signUpPageURL = driver.getCurrentUrl();
			System.out.println("signUpPageURL = " + signUpPageURL);
			// size
			int signUpHeight = driver.manage().window().getSize().getHeight();
			System.out.println("signUpHeight = " + signUpHeight);
			int signUpWidth = driver.manage().window().getSize().getWidth();
			System.out.println("signUpWidth = " + signUpWidth);
			// position
			int signUpXAxis = driver.manage().window().getPosition().getX();
			System.out.println("signUpXAxis = " + signUpXAxis);
			int signUpYAxis = driver.manage().window().getPosition().getY();
			System.out.println("SignUpYAxis = " + signUpYAxis);
			// Set
			Dimension definedSize = new Dimension(300, 500);
			driver.manage().window().setSize(definedSize);
			Thread.sleep(2000);
			Point definedPosition = new Point(150, 100);
			driver.manage().window().setPosition(definedPosition);
			Thread.sleep(4000);
		}
	}

	@Test
	public void writeAScriptToDoMaximizeMinimizeAndFullscreenOpsOnWindow() throws InterruptedException {
	
		Window window = driver.manage().window();

		System.out.println("during start");
		System.out.println(window.getSize());
		System.out.println(window.getPosition());
		Thread.sleep(3000);

		window.maximize();
		System.out.println("after maximizing");
		System.out.println(window.getSize());
		System.out.println(window.getPosition());
		Thread.sleep(3000);

		window.fullscreen();
		System.out.println("after fullscreen");
		System.out.println(window.getSize());
		System.out.println(window.getPosition());
		Thread.sleep(3000);

		window.minimize();
		System.out.println("after minimizing");
		System.out.println(window.getSize());
		System.out.println(window.getPosition());
		Thread.sleep(3000);

//		Dimension definedSize = new Dimension(300, 500);
//		driver.manage().window().setSize(definedSize);
	}
}
