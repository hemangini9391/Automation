package src;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.awt.Toolkit;
import java.awt.AWTException;	
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.datatransfer.StringSelection;

public class NewTest {
	
	Robot robot;
	WebDriver driver ;
    StringSelection strSel;
	
	@Test(priority=1)

    public void Browserlaunch()throws InterruptedException 
	{
	    System.setProperty("webdriver.chrome.driver","C:\\Users\\rising1\\Desktop\\chromedriver.exe");
	    driver = new ChromeDriver(); 
	    driver.get("http://demo.automationtesting.in/Register.html");
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);   
    }
	
	@Test(priority=1)
    public void file()throws InterruptedException, AWTException 
	{
	 robot = new Robot();  // Robot class throws AWT Exception
     driver.findElement(By.id("imagesrc")).click();
	 robot.setAutoDelay(1000);
	 
	//Store the location of the file in clipboard 
    //Clipboard
	 
	 strSel = new StringSelection ("‪F:");
	 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSel, null);
	 
	 robot.setAutoDelay(1000);
	 
	 // press cntrol + v and relaese
	 
	 robot.keyPress(KeyEvent.VK_CONTROL);
	 robot.keyPress(KeyEvent.VK_V);
	 robot.keyRelease(KeyEvent.VK_CONTROL);
	 
	
	 // press enter key and relaese 
	 
	 
	 Thread.sleep(1000);
//	 robot.keyPress(KeyEent.VK_ENTER);
//	 robot.keyRelease(KeyEvent.VK_ENTER);
	 robot.keyPress(KeyEvent.VK_ALT);
	 robot.keyPress(KeyEvent.VK_O);
	 robot.keyRelease(KeyEvent.VK_ALT); 
	 
	 strSel = new StringSelection ("‪Screenshot_1.png");
	 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSel, null);
	 
	 robot.setAutoDelay(1000);
	 
	 // press cntrol + v and relaese
	 robot.keyPress(KeyEvent.VK_CONTROL);
	 robot.keyPress(KeyEvent.VK_V);
	 robot.keyRelease(KeyEvent.VK_CONTROL);
	
	 // press enter key and relaese 
	 
	 Thread.sleep(3000);
	 robot.keyPress(KeyEvent.VK_ENTER);
	 robot.keyRelease(KeyEvent.VK_ENTER);
	 
	 
    }
}
