package learningAtTekPyramid;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateOrgTest {
	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		FileInputStream fis = new FileInputStream("C:\\Users\\ROHIT M\\OneDrive\\Desktop\\commondata.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String browserName = pobj.getProperty("browser");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		  String url = pobj.getProperty("url"); 
		  String userName = pobj.getProperty("username"); 
		  String password = pobj.getProperty("password");
		

	}
}
