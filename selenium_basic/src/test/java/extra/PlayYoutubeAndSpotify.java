package extra;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.example.genericutility.BaseClass;

public class PlayYoutubeAndSpotify extends BaseClass {
	
	@Test	
	public void checkWhetherTheUserIsAbleToPlayYoutubeVideoAndTakeScreenshot() throws InterruptedException, IOException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(22));
		String timeStamp =LocalDateTime.now().toString().replace(':', '-');
		driver.get("https://www.youtube.com/");
		Actions actions=new Actions(driver);
		
		WebElement ytSearchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='search']")));
        actions.sendKeys(ytSearchBar, "Alan Walker Faded").sendKeys(Keys.ENTER).perform();
		
		WebElement videoTitle=driver.findElement(By.xpath("//yt-formatted-string[text()='Alan Walker - Faded']"));
		actions.click(videoTitle).perform();			
		WebElement noThanksOpt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='No thanks']")));
        actions.click(noThanksOpt).perform();
		WebElement videoPlayer = driver.findElement(By.xpath("//video[@class='video-stream html5-main-video']"));
		File tempFile = videoPlayer.getScreenshotAs(OutputType.FILE);
		File permFile = new File("./screenshots/"+timeStamp+"videosreenshot.png");
		FileUtils.copyFile(tempFile, permFile);

	  }
	
	@Test
	public void checkWhetherTheUserIsAbleToPlaySongOnSpotifyAndTakeScreenshot() throws IOException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		String timeStamp = LocalDateTime.now().toString().replace(':', '-');
		
		driver.get("https://www.spotify.com/");
		
		Actions actions = new Actions(driver);
		
		driver.findElement(By.xpath("//span[text()='Log in']")).click();
		driver.findElement(By.id("login-username")).sendKeys("rohit93m@gmail.com");
		driver.findElement(By.id("login-password")).sendKeys("Rohit@1993");
        driver.findElement(By.xpath("//span[text()='Log In']")).click(); 
        
        WebElement closeOpt1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='onetrust-close-btn-container']")));
        closeOpt1.click();
        WebElement closeOpt2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-encore-id='popover']//button[@data-encore-id='buttonTertiary']")));
        closeOpt2.click();
        WebElement searchIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Search']")));
        searchIcon.click();
        
        actions.sendKeys(searchIcon, "Numb by Linkin Park").sendKeys(Keys.ENTER).perform();
        WebElement songTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='top-result-card']")));
        WebElement playButton = songTitle.findElement(By.xpath(".//button[@aria-label='Play']"));
        actions.moveToElement(playButton).click(playButton).perform();
        
		File tempFile = songTitle.getScreenshotAs(OutputType.FILE);
		File permFile = new File("./screenshots/" + timeStamp + "songsreenshot.png");
		FileUtils.copyFile(tempFile, permFile);

	}
}
