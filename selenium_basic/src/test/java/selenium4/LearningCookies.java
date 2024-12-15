package selenium4;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LearningCookies {
	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.google.com/");
		driver.manage().deleteAllCookies();
		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println(cookies.size());
		for (Cookie cookie : cookies) {
			System.out.println(cookie);
			System.out.println();
		}		


		
		//driver.manage().addCookie(new Cookie("ROHIT","1234567890"));
		//System.out.println(driver.manage().getCookieNamed("ROHIT"));
		//driver.quit();
	}
}
