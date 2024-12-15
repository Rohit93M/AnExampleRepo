package extra;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IncognitoMode {
public static void main(String[] args) throws AWTException {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	Robot robot = new Robot();
	robot.keyPress(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_SHIFT);
	robot.keyPress(KeyEvent.VK_N);
	robot.keyRelease(KeyEvent.VK_CONTROL);
	robot.keyRelease(KeyEvent.VK_SHIFT);
	robot.keyRelease(KeyEvent.VK_N);
}
}
