package src;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class xpath {
	
	public static WebDriver driver;
	public static String url = "http://ec2-34-216-206-233.us-west-2.compute.amazonaws.com/m_user_login/sign_in#/app/dashboard/home";

  @Test(priority = 1)
  public void Browser() throws InterruptedException {
	  
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rising1\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.linkText("English")).click();
		driver.manage().window().maximize();
		Thread.sleep(1000);
  }
  
  @Test(priority = 2)
   public void click()
   {
	  driver.findElement(By.xpath("//button[@type ='submit']")).click();
	  
   }
  
  @Test(priority = 3)
	public void real_value() throws InterruptedException {

		WebElement test5 = driver.findElement(By.xpath("//*[@id=\"m_user_login_email\"]"));
		test5.sendKeys("userr177@yopmail.com");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"m_user_login_password\"]")).clear();

		WebElement test7 = driver.findElement(By.xpath("//*[@id=\"m_user_login_password\"]"));
		test7.sendKeys("password38");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div/div[2]/div[4]/button[2]")).click();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Thread.sleep(4000);
	}
  
  @Test(priority = 4)
	public void admin()
    {
         driver.findElement(By.xpath("//li[@class='dropdown']")).click();
	}
  
}
