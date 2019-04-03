package src;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.awt.Toolkit;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;

public class Csv_upload_test {

	Robot robot;
	WebDriver driver;
	StringSelection strSel;
	String baseUrl;

	@Test(priority = 1)

	public void Browserlaunch() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rising1\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Register.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		StringSelection strSel = new StringSelection("F:");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSel, null);
	}

	@Test(priority = 2)
	public void file() throws InterruptedException, AWTException, IOException {
		robot = new Robot(); // Robot class throws AWT Exception
		driver.findElement(By.id("imagesrc")).click();
		robot.setAutoDelay(2000);

		// press cntrol + L and relaese
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_L);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		// Send("‪F:\\tiger.jpg");

		// press cntrol + v and relaese

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		// press enter key and relaese
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		// robot.setAutoDelay(2000);

		StringSelection strSel = new StringSelection("tiger.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSel, null);

		// press Alt + N and relaese
		robot.keyPress(KeyEvent.VK_ALT);
		robot.keyPress(KeyEvent.VK_N);
		robot.keyRelease(KeyEvent.VK_ALT);

		// press cntrol + v and relaese

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		robot.keyPress(KeyEvent.VK_ENTER);

	}
}