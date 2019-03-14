package src;

import java.util.Random;

//import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


public class User_registration extends Browser_launch_signup {

	// -------------------------------------------Admin----------------------------------------------------------//

	@Test(priority = 12)

	public void admin() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[4]/div/div/div[2]/div[3]/div/div[1]/a")).click();
		driver.findElement(By.id("admin-step")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"admin-step\"]/ul/li[1]/a")).click();
		Thread.sleep(1000);
		// click on user registration
		driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/div/div[4]/div/div[1]/span/a")).click();

	
	}
	
	@Test(priority =13)
	public void user() throws InterruptedException
	{
		//String[] lastname = {"patel"};
		String [] Firstname = {"Milind", "Bhavik","karan"};
		String[] Employeeid = {"m1", "b1", "k1"};
		String[] User = {"milinnd","bhavik" , "karran" };
		
		for(int i=0; i<Firstname.length; i++)
		{
			// click on add user
			driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/button")).click();
		    Thread.sleep(3000);
		    
		    //last name
			driver.findElement(By.name("last_name")).sendKeys("patel");
			Thread.sleep(2000);
		    
			//first name
			driver.findElement(By.name("first_name")).sendKeys(Firstname[i]);
			Thread.sleep(2000);
		
			//employeeid
			driver.findElement(By.id("m_user_login_employeeid")).sendKeys(Employeeid[i]);
			Thread.sleep(2000);
			
		    //email
			Random r = new Random();
			String user_email = User[i] + r.nextInt(1000) + "@yopmail.com";
			// System.out.println(email);
			driver.findElement(By.id("m_user_login_email")).sendKeys(user_email);
			Thread.sleep(2000);
		
			// select category superadmin/admin/normal user
			Select dropdown = new Select(driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[7]/div/select")));
			dropdown.selectByVisibleText("Super Admin");
			Thread.sleep(2000);
			
			
			//select checkbox
			
			if (!driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[9]/div[2]/div/label/span[1]/span")).isSelected())
			{
				
				driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[9]/div[2]/div/label/span[1]/span")).click();
			}
			else
			{
				driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[9]/div[2]/div/label/span[1]/span")).click();
			}
			
			
			// click on submit
			driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[15]/button[1]")).submit();
			String user_alert = driver.findElement(By.className("alertOut")).getText();
			String user_alert_real = "×\n" + "User created successfully";
			Assert.assertEquals(user_alert, user_alert_real);
			Thread.sleep(6000);
			
		
		}
		
		
		
		
		
		

	}
	
	
}
