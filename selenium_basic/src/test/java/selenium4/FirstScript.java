package selenium4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FirstScript {
    public static void main(String[] args) throws InterruptedException {
    	
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        System.out.println("Page Title - "+driver.getTitle());

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement textBox = driver.findElement(By.name("my-text"));
        WebElement submitButton = driver.findElement(By.cssSelector("button"));

        textBox.sendKeys("Selenium");
        submitButton.click();
        Thread.sleep(2000);

        WebElement message = driver.findElement(By.id("message"));
        System.out.println("Text - "+message.getText());
       
        Thread.sleep(2000);
        driver.quit();
    }
}
