package learningAtTekPyramid;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingMultiSelectDropdowns {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/signup");
		driver.manage().window().maximize();
//
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		WebElement yearDropdown = driver.findElement(By.id("year"));
		Select yearSelect = new Select(yearDropdown);
		List<WebElement> years = yearSelect.getOptions();

		for (int i = 0; i < years.size(); i++) {
			yearSelect.selectByIndex(i);
			System.out.print(yearSelect.getFirstSelectedOption().getText() + " ");

			WebElement monthDropdown = driver.findElement(By.id("month"));
			Select monthSelect = new Select(monthDropdown);
			List<WebElement> months = monthSelect.getOptions();

			for (int j = 0; j < months.size(); j++) {
				monthSelect.selectByIndex(j);
				System.out.print(monthSelect.getFirstSelectedOption().getText() + " ");

				WebElement dayDropdown = driver.findElement(By.id("day"));
				Select daySelect = new Select(dayDropdown);
				List<WebElement> days = daySelect.getOptions();

				for (int k = 0; k < days.size(); k++) {
					daySelect.selectByIndex(k);
					System.out.print(daySelect.getFirstSelectedOption().getText() + " ");
				}
			}
		}
	}
}
