package src;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class Browser_launch_signup {

	public WebDriver driver;
	public Robot robot;
	public String url = "http://ec2-34-216-206-233.us-west-2.compute.amazonaws.com/m_user_login/sign_in#/app/dashboard/home";

	@Test(priority = 1)
	public void browser_launch() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rising1\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.linkText("English")).click();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[4]/div/div/div/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"twblock\"]/a/label")).click();
		
	}

	// ----------------------------------------Enter
	// companyname-------------------------------------------------------//

	@Test(priority = 2)

	public void companyname() throws InterruptedException {
		
		WebElement c_name = driver.findElement(By.id("m_user_login_company_name"));
		c_name.sendKeys("Appsense Rising");
		Thread.sleep(2000);
	}

	// --------------------------------last
	// name---------------------------------------------------------//
	@Test(priority = 3)
	public void lastnamereal() throws InterruptedException {
		WebElement l_namereal = driver.findElement(By.id("m_user_login_last_name"));
		l_namereal.clear();
		l_namereal.sendKeys("patel");
		Thread.sleep(1000);
	}
	// ------------------------------------------first name
	// -----------------------------------------------//

	@Test(priority = 4)
	public void firstnamereal() throws InterruptedException { // enter firstname real
		WebElement l_namereal = driver.findElement(By.id("m_user_login_first_name"));
		l_namereal.clear();
		l_namereal.sendKeys("Chandni");
		// Thread.sleep(2000);
	}
	// ----------------------------------------- phone
	// number------------------------------------------------------//

	// enter real phone number
	@Test(priority = 5)
	public void ph_number_real() throws InterruptedException {
		WebElement ph_number_real = driver.findElement(By.id("m_user_login_phone"));
		ph_number_real.clear();
		ph_number_real.sendKeys("7567630234");
		Thread.sleep(2000);
	}
	// ----------------------------------------random email
	// generate---------------------------------------------------------//

	@Test(priority = 6)

	public void email_real() throws InterruptedException

	{
		// enter require email
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement email_real = driver.findElement(By.id("m_user_login_email"));
		email_real.clear();

		// method for send email randomly
		Random r = new Random();
		String email = "Userr" + r.nextInt(1000) + "@yopmail.com";
		// System.out.println(email);
		email_real.sendKeys(email);
		Thread.sleep(2000);
	}
	// --------------------------------------------real
	// password------------------------------------------------------//

	@Test(priority = 7)

	// real password

	public void password_real() throws InterruptedException {
		WebElement password_alpha = driver.findElement(By.id("m_user_login_password"));
		password_alpha.clear();
		password_alpha.sendKeys("password38");
		Thread.sleep(2000);
	}

	// ------------------------ real confirm
	// password--------------------------------------------------------------//

	@Test(priority = 8)

	public void confirm_password_real() throws InterruptedException {

		WebElement confirm_password_8 = driver.findElement(By.id("m_user_login_password_confirmation"));
		confirm_password_8.clear();
		confirm_password_8.sendKeys("password38");
		Thread.sleep(2000);

	}
	// ------------------------------------------ check box //
	// select----------------------------------------------------//

	@Test(priority = 9)

	public void checkbox() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement checkbox = driver.findElement(By.name("m_user_login[is_agree]"));
		checkbox.click();

		if (!driver.findElement(By.name("m_user_login[is_agree]")).isSelected()) {
			driver.findElement(By.name("m_user_login[is_agree]")).click();
		}
		driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div[5]/div[1]/div/button")).submit();

	}
	// --------------------------yopmail
	// conformation--------------------------------------------------------//

	@Test(priority = 10)

	public void yopmail() throws InterruptedException, AWTException {

		// login email-id get

		String test = driver.findElement(By.xpath("//*[@id=\"home\"]/div/div/div/div/p/strong")).getText();
		System.out.println(test);

		// get yopmail
		driver.get("http://www.yopmail.com/en/");
		Thread.sleep(2000);

		// enter email-id in yopmail

		driver.findElement(By.id("login")).sendKeys(test);
		WebElement Check_Inbox = driver.findElement(By.xpath(
				"/html/body/center/div/div/div[3]/table[3]/tbody/tr/td[1]/table/tbody/tr[3]/td/div[1]/form/table/tbody/tr[1]/td[3]/input"));
		Check_Inbox.click();

		// change i-frame for click on link
		driver.switchTo().frame("ifmail");
		driver.findElement(By.linkText("アカウントの確認")).click();
		Thread.sleep(6000);

		// again open chrome
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rising1\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.linkText("English")).click();
		driver.manage().window().maximize();

		// login
		driver.findElement(By.id("m_user_login_email")).sendKeys(test);
		Thread.sleep(2000);
		driver.findElement(By.id("m_user_login_password")).sendKeys("password38");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div/div[2]/div[4]/button[2]")).click();
		Thread.sleep(5000);

	}

}
