package learningAtTekPyramid;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindBrokenLinks {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		List<WebElement> links = driver.findElements(By.xpath("//a"));

		for (int i = 0; i < links.size(); i++) {
			String url = links.get(i).getAttribute("href");
			if (url == null) {
				System.out.println(url);
			}

		}
	}

}
