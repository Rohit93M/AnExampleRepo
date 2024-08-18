package datadriventesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.genericutility.BaseClass;

public class ReadTheDataFromPropertyFile2 extends BaseClass  {

@Test
public void checkWhetherTheUserIsAbleToReadFromPropertyFileForLogin() throws IOException {

Properties properties = new Properties();
File filePath = new File("./src/test/resources/facebookdata.properties");
FileInputStream fis = new FileInputStream(filePath);
properties.load(fis);

driver.get(properties.getProperty("url"));

Assert.assertEquals(driver.getCurrentUrl(),properties.getProperty("url"));
driver.switchTo().activeElement().sendKeys(properties.getProperty("username"));
driver.findElement(By.id("pass")).sendKeys(properties.getProperty("password"));
driver.findElement(By.name("login")).submit();

System.out.println("browserName= "+properties.getProperty("browser"));
System.out.println("url= "+properties.getProperty("url"));
System.out.println("username= "+properties.getProperty("username"));
System.out.println("password= "+properties.getProperty("password"));

  }
}
