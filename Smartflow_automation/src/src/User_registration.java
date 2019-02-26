package src;
//import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;

public class User_registration {
	
	WebDriver driver ;
//--------------------------------------browser_launch---------------------------------------------------------//
	
@Test(priority=1)

	public void browserlaunch() 
	   {
		    System.setProperty("webdriver.chrome.driver","C:\\Users\\rising1\\Desktop\\chromedriver.exe");
		    driver = new ChromeDriver();
		    driver.get("http://ec2-54-71-174-152.us-west-2.compute.amazonaws.com/dash_board/index#/app/dashboard/home");
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    driver.findElement(By.linkText("English")).click();
			driver.findElement(By.linkText("新規登録")).click();
			driver.manage().window().maximize();
			driver.findElement(By.xpath("//*[@id=\"twblock\"]/a/label")).click();
		}
//--------------------------------------click on submit with blank value  ----------------------------------------//

@Test(priority=2)
	
	    public void checkvalidation ()throws InterruptedException  
	   {
		 WebElement login = driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div[5]/div[1]/div/button"));
		 login.submit();
		  
		 //company_name
		  String expected = driver.findElement(By.id("m_user_login_last_name-error")).getText();
		  String validation_massage = "Field can not be blank.";
	      Assert.assertEquals(expected,validation_massage);
		
	  	//last_name
		   String expected1 = driver.findElement(By.id("m_user_login_last_name-error")).getText();
		   Assert.assertEquals(expected1,validation_massage);
	     
	    //firstname
		   
	       String expected2 = driver.findElement(By.id("m_user_login_first_name-error")).getText();
	       Assert.assertEquals(expected2,validation_massage);
	       
	   //email
	        
           String expected3 = driver.findElement(By.id("m_user_login_email-error")).getText();
	       Assert.assertEquals(expected3,validation_massage);
	       
	   //phonenumber
	       
	       //String expected4 = driver.findElement(By.id("phone_validation_msg")).getText();
	      // Assert.assertEquals(expected4,validation_massage);
	       
	    //password
	       
	       String expected5 = driver.findElement(By.id("m_user_login_password-error")).getText();
	       Assert.assertEquals(expected5,validation_massage);
	       
        //confirm_password
	       
	       String expected6 = driver.findElement(By.id("m_user_login_password_confirmation-error")).getText();
	       Assert.assertEquals(expected6,validation_massage);
	       
	    //checkbox
	       
	      String expected7 = driver.findElement(By.id("m_user_login[is_agree]-error")).getText();
	       Assert.assertEquals(expected7,validation_massage);
		  
	    }
	

//----------------------------------------Enter companyname-------------------------------------------------------//
  
@Test(priority=3)
	         
              public void companyname() throws InterruptedException  
	          {
			    WebElement c_name = driver.findElement(By.id("m_user_login_company_name"));
		        c_name.sendKeys("Appsense Rising");
		        Thread.sleep(2000);
		      }
//-------------------------------------last name with real value--------------------------------------------------------//	
	
	
  @Test(priority=4 , dependsOnMethods = "checkvalidation")
           
  
			 public void lastnamereal()throws InterruptedException  
		      {
	  				
	  				WebElement l_namereal = driver.findElement(By.id("m_user_login_last_name"));
	  				l_namereal.clear();
	  				l_namereal.sendKeys("patel");
			       // Thread.sleep(2000);
				 
			  }
//------------------------------------------first name with real value-----------------------------------------------//	
				 
  @Test(priority=5 , dependsOnMethods = "checkvalidation")

               
			public void firstnamereal()throws InterruptedException  
			
		    {
	            //enter firstname real
	     		
				 WebElement l_namereal = driver.findElement(By.id("m_user_login_first_name"));
				 l_namereal.clear();
				 l_namereal.sendKeys("Chandni");
			   //  Thread.sleep(2000);
		    }
 //-------------------------------------------real phone number------------------------------------------------------//
  
 // enter real phone number
  @Test(priority=6 , dependsOnMethods = "checkvalidation")

			 public void ph_number_real()throws InterruptedException  
			 {
                 WebElement ph_number_real = driver.findElement(By.id("m_user_login_phone"));
				 ph_number_real.clear();
				 ph_number_real.sendKeys("7567630234");
	    	  //   Thread.sleep(2000);

			 }
 //----------------------------------------random email generate---------------------------------------------------------//
  
  @Test(priority=7 , dependsOnMethods = "checkvalidation")

			 public void email_real()throws InterruptedException  
			 
			 {
			    //enter require email
	             driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				 WebElement email_real = driver.findElement(By.id("m_user_login_email"));
				 email_real.clear();
			 
			   // method for send email randomly
				 Random r =new Random();
				 String email ="chandni"+r.nextInt(5000)+"@yopmail.com";
				 //System.out.println(email);
				 email_real.sendKeys(email);
			     Thread.sleep(2000);

			 }
  
 //--------------------------------------------real password------------------------------------------------------//
  
  @Test(priority=8 , dependsOnMethods = "checkvalidation")
  
    // real password
   
	      public void password_real()throws InterruptedException  
		  {
	  
			 WebElement password_alpha = driver.findElement(By.id("m_user_login_password"));
			 password_alpha.clear();
			 password_alpha.sendKeys("password38");
			 Thread.sleep(2000);
			 
		 }
  
 //-------------------------- real confirm password--------------------------------------------------------------//
   
  @Test(priority=9, dependsOnMethods = "checkvalidation")
   
        public void confirm_password_real()throws InterruptedException  
        {
	   
           WebElement confirm_password_8 = driver.findElement(By.id("m_user_login_password_confirmation"));
		   confirm_password_8.clear();
		   confirm_password_8.sendKeys("password38");
		   Thread.sleep(2000);
    
        }
   
//------------------------------------------ checkbox select----------------------------------------------------//
   
   @Test(priority=10 , dependsOnMethods = "checkvalidation")
  
		   public void checkbox()throws InterruptedException 
		   {
              
	           driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
               WebElement checkbox = driver.findElement(By.name("m_user_login[is_agree]"));
			   checkbox.click();
			   
			   if ( !driver.findElement(By.name("m_user_login[is_agree]")).isSelected() )
			   {
			        driver.findElement(By.name("m_user_login[is_agree]")).click();
			   }
				 driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div[5]/div[1]/div/button")).submit();
				 
			}
 //--------------------------yopmail conformation--------------------------------------------------------//
   
   @Test(priority=11 , dependsOnMethods = "checkvalidation")
   
   public void yopmail()throws InterruptedException  
   {
	   
	   // login email-id get
	    
	       String test = driver.findElement(By.xpath("//*[@id=\"home\"]/div/div/div/div/p/strong")).getText();
		   System.out.println(test);
		
		
		// get yopmail
		driver.get("http://www.yopmail.com/en/");
		Thread.sleep(2000);
		
		
		// enter email-id in yopmail 
		
		driver.findElement(By.id("login")).sendKeys(test);	
		WebElement Check_Inbox = driver.findElement(By.xpath("/html/body/center/div/div/div[3]/table[3]/tbody/tr/td[1]/table/tbody/tr[3]/td/div[1]/form/table/tbody/tr[1]/td[3]/input"));
		Check_Inbox.click();
		
		 
	   // change i-frame for click on link 
	    driver.switchTo().frame("ifmail"); 
	    driver.findElement(By.linkText("アカウントの確認")).click();		
	    Thread.sleep(2000);
	
	    
	   // smartflow login with real value

	    driver.close();
	    
	    
	   // again open chrome 
	    
	    System.setProperty("webdriver.chrome.driver","C:\\Users\\rising1\\Desktop\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.get("http://ec2-54-71-174-152.us-west-2.compute.amazonaws.com/dash_board/index#/app/dashboard/home");
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.findElement(By.linkText("English")).click();  
		driver.manage().window().maximize();
		
		// login 
		
		driver.findElement(By.id("m_user_login_email")).sendKeys(test);
		Thread.sleep(2000);
	    driver.findElement(By.id("m_user_login_password")).sendKeys("password38");
	    Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div/div[2]/div[4]/button[2]")).click();
	    Thread.sleep(2000);
   }
   
   
 //-------------------------------------------Admin----------------------------------------------------------//
   
  @Test(priority=12 , dependsOnMethods = "checkvalidation")
   
   public void admin()throws InterruptedException  
   {
	   driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[4]/div/div/div[2]/div[3]/div/div[1]/a")).click();
	   driver.findElement(By.xpath("//*[@id=\"admin-step\"]/a")).click();
	   driver.findElement(By.xpath("//*[@id=\"admin-step\"]/ul/li[1]/a")).click();
   }
 //-----------------------------------------------Enter into user----------------------------------------------//
   
 @Test(priority=13 , dependsOnMethods = "checkvalidation")
   
	   public void position()throws InterruptedException  
	   {
	     // click on user registration
		 driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/div/div[4]/div/div[1]/span/a")).click();
	     Thread.sleep(3000);
		 //click on add user
		 driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/button")).click();
		 Thread.sleep(2000); 
	   }

 //---------------------click on submit and check validation-------------------------------------------------------//
 
@Test(priority=14 , dependsOnMethods = "checkvalidation")
 
	   public void User_submit()throws InterruptedException  
	   {
	
    
	      // change i-frame for click on link 
//		    driver.switchTo().frame("iframe"); 
//		    driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[15]/button[1]")).click();		
//		    Thread.sleep(2000);
	
		   driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[15]/button[1]")).submit();
	       Thread.sleep(3000);
	     
	       //last name validation
	       String lastname_val_msg = driver.findElement(By.xpath("//*[@id=\"last_name-error\"]")).getText();
	       String lastname_val_msg_real = "This field is required.";
	       Assert.assertEquals(lastname_val_msg,lastname_val_msg_real);
	     

	       //first name validation
	       String firstname_val_msg = driver.findElement(By.xpath("//*[@id=\"inputDefault-error\"]")).getText();
	       String firstname_val_msg_real = "This field is required.";
	       Assert.assertEquals(firstname_val_msg,firstname_val_msg_real);
	     

	       //employee validation
	       String employee_val_msg = driver.findElement(By.xpath("//*[@id=\"m_user_login_employeeid-error\"]")).getText();
	       String employee_val_msg_real = "This field is required.";
	       Assert.assertEquals(employee_val_msg,employee_val_msg_real);
	     
	     
	       // email validation 
	       String email_val_msg = driver.findElement(By.xpath("//*[@id=\"m_user_login_email-error\"]")).getText();
	       String email_val_msg_real = "This field is required.";
	       Assert.assertEquals(email_val_msg,email_val_msg_real);
	       Thread.sleep(1000);
	   }


@Test(priority=14 , dependsOnMethods = "checkvalidation")
		
		public void checkbox_validation()throws InterruptedException  
		{
	     
		//workflow and travel expense checkbox validation
	
		driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[9]/div[1]/div/label/span[1]/span")).click();	
		Thread.sleep(2000);
		String checkbox_val = driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[9]/span")).getText();
		String checkbox_val_real = "Select Any of checkbox";
		Assert.assertEquals(checkbox_val,checkbox_val_real);
	    Thread.sleep(1000);
		}


@Test(priority=15, dependsOnMethods ="checkvalidation")
		public void Enter_user_2() throws InterruptedException
		{
		
		 //Enter last name
		 driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[1]/div/input")).sendKeys("Patel");
		 Thread.sleep(1000);
		 
		 //Enter first name
		 
		driver.findElement(By.xpath("//*[@id=\"inputDefault\"]")).sendKeys("Milind");
		Thread.sleep(1000);
		
		// Enter Employee id
		
		driver.findElement(By.xpath("//*[@id=\"m_user_login_employeeid\"]")).sendKeys("m1");
		
		//Enter invalid email
		driver.findElement(By.xpath("//*[@id=\"m_user_login_email\"]")).sendKeys("chandni38@yopmail.com");
		Thread.sleep(2000);
		
		String emaill_val_msg = driver.findElement(By.xpath("//*[@id=\"m_user_login_email-error\"]")).getText();
		String emaill_val_msg_real =  "Email already registerd.";
		Assert.assertEquals(emaill_val_msg,emaill_val_msg_real);
		
		// Enter valid email (This is random email method)
		driver.findElement(By.xpath("//*[@id=\"m_user_login_email\"]")).clear();
	    // method for send email randomly
		
		 Random r =new Random();
		 String email1 ="Milinnd"+r.nextInt(5000)+"@yopmail.com";
		 //System.out.println(email);
		 driver.findElement(By.xpath("//*[@id=\"m_user_login_email\"]")).sendKeys(email1);
         Thread.sleep(2000);
         
         // select category superadmin/admin/normal user
         
         Select dropdown  = new Select(driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[7]/div/select")));
 		 dropdown.selectByVisibleText("Super Admin");
 		 Thread.sleep(2000);
 		 
 		 
 		 // select checkbox
 		 driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[9]/div[1]/div/label/span[1]/span")).click();
 		 driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[9]/div[2]/div/label/span[1]/span")).click();
         
}

}
	