package datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadTheDataFromPropertyFile {
	
    public static WebDriver driver;
    
 public static void main(String[] args) throws IOException {
	FileInputStream fis = new FileInputStream("./src/test/resources/commondata02.properties");
	Properties pobj = new Properties();
	pobj.load(fis);
	String browserName = pobj.getProperty("browser");
    System.out.println("browserName = " +browserName); 
    if(browserName.equals("chrome")) {
    	driver = new ChromeDriver();
    }else if(browserName.equals("firefox")) {
        driver  = new FirefoxDriver();
    }else if(browserName.equals("edge")) {
    	driver = new EdgeDriver();
    }   
    driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get(pobj.getProperty("url"));
	WebElement usernameTextField = driver.findElement(By.id("username"));
	usernameTextField.clear();
	usernameTextField.sendKeys(pobj.getProperty("username"));
	WebElement passwordTextField = driver.findElement(By.id("password"));
	passwordTextField.clear();
	passwordTextField.sendKeys(pobj.getProperty("password"));
	driver.findElement(By.xpath("//button[text()='Sign in']")).submit();
	driver.manage().window().minimize();
	driver.quit();	
    }
}
