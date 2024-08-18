package extra;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ReadTheDataFromXMLFile {
	
WebDriver driver;

@Parameters({ "browser", "url", "username", "password"})
@Test
public void loginToFacebook(String browser, String url, String username, String password) {
	
if (browser.equals("chrome")) { 
driver = new ChromeDriver();
}
else if (browser.equals("msedge")) { 
driver = new EdgeDriver();
}
else if (browser.equals("firefox")) { 
driver = new FirefoxDriver();
}
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
driver.get(url);

Assert.assertEquals(driver.getCurrentUrl(),(url)) ;
driver.switchTo().activeElement().sendKeys(username);
driver.findElement(By.id("pass")).sendKeys(password);
driver.findElement(By.name("login")).submit();

driver.manage().window().minimize();
driver.quit();

System.out.println("browser = "+browser);
System.out.println("url = "+url);
System.out.println("username = "+username);
System.out.println("password = "+password);
System.out.println();

    }
}