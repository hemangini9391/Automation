package src;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import java.awt.Toolkit;
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

	@Test
	public void Browserlaunch() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rising1\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Register.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("test");
		
		
		
		
	}

	@Test
	public void file() throws InterruptedException, AWTException, IOException {
		robot = new Robot(); // Robot class throws AWT Exception
		driver.findElement(By.id("imagesrc")).click();
		robot.setAutoDelay(2000);

		// press cntrol + L and relaese
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_L);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		Send("‪F:\\tiger.jpg");

		// press cntrol + v and relaese

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		// press enter key and relaese
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.setAutoDelay(2000);

		// press Alt + N and relaese
		robot.keyPress(KeyEvent.VK_ALT);
		robot.keyPress(KeyEvent.VK_N);
		robot.keyRelease(KeyEvent.VK_ALT);

		Send("2.jpg");
		// Runtime.getRuntime().exec("2.jpg");
		// baseUrl = new String("‪2.jpg");

		// press cntrol + v and relaese
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		robot.keyPress(KeyEvent.VK_ENTER);

		// Store the location of the file in clipboard
		// Clipboard
		// robot.setAutoDelay(2000);
	
		// uploadElement.sendKeys();
		//
		// robot.keyRelease(KeyEvent.VK_ENTER);
		// robot.keyPress(KeyEvent.VK_ALT);

		// robot.keyPress(KeyEvent.VK_O);
		// robot.keyRelease(KeyEvent.VK_ALT);

	}

	private void Send(String string) {
		// TODO Auto-generated method stub
		
	}

}