package selenium4;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HandlingDropdowns {
	
@Test
public void sampleTest() {
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.facebook.com/signup");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
}
}
