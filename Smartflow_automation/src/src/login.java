package src;

//import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
import org.testng.annotations.Test;

public class login {

	WebDriver driver;

	// -------------------------------------------browser
	// launch-------------------------------------------------------//
	@Test(priority = 1)

	public void Browserlaunch() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rising1\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://ec2-34-216-206-233.us-west-2.compute.amazonaws.com/dash_board/index#/app/dashboard/home");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.linkText("English")).click();
		driver.manage().window().maximize();
	}

	// ------------------------------------------click on sign
	// in--------------------------------------------------------//
	@Test(priority = 2)
	public void signin_click() throws InterruptedException

	{
		// click on signin without putting data
		driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div/div[2]/div[4]/button[2]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String test = driver.findElement(By.className("alert")).getText();
		System.out.println(test);

	}

	// --------------------------------------------enter only
	// email------------------------------------------------------//
	 @Test(priority=3)
	 public void enter_email()throws InterruptedException
	
	 {
	 // enter only email and check validation of popup msg
	 WebElement test1 =
	 driver.findElement(By.xpath("//*[@id=\"m_user_login_email\"]"));
	 test1.sendKeys("chandni13232@yopmail.com");
	 driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div/div[2]/div[4]/button[2]")).click();
	 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	 String test2= driver.findElement(By.className("alert")).getText();
	 System.out.println(test2);
	 driver.findElement(By.xpath("//*[@id=\"m_user_login_email\"]")).clear();
	
	}
	
	// ----------------------------------------enter only
	// password-------------------------------------------------------//
	 @Test(priority=4)
	 public void enter_password()throws InterruptedException
	 {
	 // enter only password and check validation of pop up msg
	
	 WebElement test3 =
	 driver.findElement(By.xpath("//*[@id=\"m_user_login_password\"]"));
	 test3.sendKeys("teste122");
	 driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div/div[2]/div[4]/button[2]")).click();
	 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	 String test4= driver.findElement(By.className("alert")).getText();
	 System.out.println(test4);
	 driver.findElement(By.xpath("//*[@id=\"m_user_login_password\"]")).clear();
	 }

	// ------------------------------------- enter invalid email and valid
	// password------------------------------------------//
	 @Test(priority=5)
	
	 public void wrong_email()throws InterruptedException
	 {
	
	 WebElement test5 =
	 driver.findElement(By.xpath("//*[@id=\"m_user_login_email\"]"));
	 test5.sendKeys("chandni381@yopmail.coom");
	
	 WebElement test7 =
	 driver.findElement(By.xpath("//*[@id=\"m_user_login_password\"]"));
	 test7.sendKeys("password");
	
	 driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div/div[2]/div[4]/button[2]")).click();
	
	 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	 String test6= driver.findElement(By.className("alert")).getText();
	 System.out.println(test6);
	
	 driver.findElement(By.xpath("//*[@id=\"m_user_login_email\"]")).clear();
	 driver.findElement(By.xpath("//*[@id=\"m_user_login_password\"]")).clear();
	
	 }

	// ---------------------------------enter wrong password and valid
	// email----------------------------------------------//

	 @Test(priority=6)
	 public void wronge_password()throws InterruptedException
	 {
	
	 WebElement test5 =
	 driver.findElement(By.xpath("//*[@id=\"m_user_login_email\"]"));
	 test5.sendKeys("chandni38@yopmail.com");
	
	 driver.findElement(By.xpath("//*[@id=\"m_user_login_password\"]")).clear();
	
	 WebElement test7 =
	 driver.findElement(By.xpath("//*[@id=\"m_user_login_password\"]"));
	 test7.sendKeys("passwod");
	
	 driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div/div[2]/div[4]/button[2]")).click();
	
	 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	 String test6= driver.findElement(By.className("alert")).getText();
	 System.out.println(test6);
	
	 driver.findElement(By.xpath("//*[@id=\"m_user_login_email\"]")).clear();
	 driver.findElement(By.xpath("//*[@id=\"m_user_login_password\"]")).clear();
	
	 }
	 //--------------------------------------enter real
	// value---------------------------------------------------------------//

	@Test(priority = 7)
	public void real_value() throws InterruptedException {

		WebElement test5 = driver.findElement(By.xpath("//*[@id=\"m_user_login_email\"]"));
		test5.sendKeys("chandni38@yopmail.com");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"m_user_login_password\"]")).clear();

		WebElement test7 = driver.findElement(By.xpath("//*[@id=\"m_user_login_password\"]"));
		test7.sendKeys("password");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div/div[2]/div[4]/button[2]")).click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String test6 = driver.findElement(By.className("alert")).getText();
		System.out.println(test6);
		Thread.sleep(2000);

	}
}

	// -------------------------------------admin----------------------------------------------------//

	