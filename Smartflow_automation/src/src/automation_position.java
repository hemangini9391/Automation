package src;
//import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
//import org.openqa.selenium.support.ui.Select;


public class automation_position {
	
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
  
 //-----------------------------------------------Enter into position----------------------------------------------//
   
 @Test(priority=13 , dependsOnMethods = "checkvalidation")
   
	   public void position()throws InterruptedException  
	   {
		 
		 //click on position
		 driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/div/div[3]/div/div[1]/span/a")).click();
		 Thread.sleep(2000);
		 
		 
		 //enter value in search box
		 
		driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div[1]/div/input")).sendKeys("testing");
		Thread.sleep(1000);
		
		// output search result
		String search_msg =	driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div[2]/div/table/tbody/tr/td")).getText();
		String search_message = "No Position list Found";
		Assert.assertEquals(search_msg, search_message);
		
		// remove search result
	     
		driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div[1]/div/input")).clear();
	  }
 
 
 //--------------------------------check validation -----------------------------------//
 
 // check validation without adding any position value
 @Test(priority=14 , dependsOnMethods = "checkvalidation")
 
	 public void submit()throws InterruptedException  
	 {
		 //click on add symbol
		 
		 driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div[2]/div/button")).click();
		 Thread.sleep(1000);
		 
		 // click on submit and check validation
		 driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[4]/button")).click();
		 
		 
		// validation for position name
		String val1= driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[1]/div/span[1]/span")).getText();
		String rval1 = "Position name is required";
		Assert.assertEquals(val1, rval1);
		
		// validation for postion code
		
		String val2=	driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[2]/div/span[1]/span")).getText();
		String rval2 = "Position Code is required";
		Assert.assertEquals(val2, rval2);
		Thread.sleep(1000);
		
	}
 
//-------------check validation when add only position name------------------------------------------------//
@Test(priority=15 , dependsOnMethods = "checkvalidation")

		public void enter_only_position()throws InterruptedException  
		{
			driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[1]/div/input")).sendKeys("a");
			 
			// click on submit and check validation
			driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[4]/button")).click();
			Thread.sleep(1000);
			 
			
			// validation for position code
			
			String val3=	driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[2]/div/span[1]/span")).getText();
			String rval3 = "Position Code is required";
			Assert.assertEquals(val3, rval3);
			
			driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[1]/div/input")).clear();
			
		}
////-------------check validation when add only position name------------------------------------------------//

	@Test(priority=16 , dependsOnMethods = "checkvalidation")
	
		public void enter_only_positioncode()throws InterruptedException  
		{
			driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[2]/div/input")).sendKeys("02");
			 
			// click on submit and check validation
			driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[4]/button")).click();
			Thread.sleep(1000);
			 
			// validation for position name
			String val4=	driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[1]/div/span[1]/span")).getText();
			String rval4 = "Position name is required";
			Assert.assertEquals(val4, rval4);
			
			driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[2]/div/input")).clear();
		}
	
//----------------------------check validation when add same value------------------------------------------------//

	@Test(priority=17 , dependsOnMethods = "checkvalidation")
	
		public void add_samevalue_position()throws InterruptedException  
		{
		    // code value
			driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[2]/div/input")).sendKeys("01");
			// name value
			driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[1]/div/input")).sendKeys("unassigned");
			 
			// click on submit and check validation
			driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[4]/button")).click();
			Thread.sleep(1000);
			 
			// validation for position name
			String val5= driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[1]/div/span[2]")).getText();
			String rval5 = "Name already exists.";
			Assert.assertEquals(val5, rval5);
			
			//validation for position code
			
			String val6= driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[2]/div/span[2]")).getText();
			String rval6 = "Position Code already exists.";
			Assert.assertEquals(val6, rval6);	
			
			
			//clear added value and add new one
			 
			driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[2]/div/input")).clear();
			driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[1]/div/input")).clear();
			
			
			// code value
			driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[2]/div/input")).sendKeys("1");
			// name value
			driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[1]/div/input")).sendKeys("a");
			
			 // select parent department 
			  
			Select parent_dept = new Select(driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[3]/div/select")));
			parent_dept.selectByVisibleText("unassigned");
			 
			// click on submit
			driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[4]/button")).click();
			Thread.sleep(1000);
			
			//verify alert message
			String alert_position_message =	driver.findElement(By.className("alertOut")).getText();
			String real_alert_position_message = "×\r\n" + 
					"Position created successfully";
			System.out.println(real_alert_position_message);
	
			Assert.assertEquals(alert_position_message,real_alert_position_message );
		}	
	
	
//-----------------------------------delete position---------------------------------------------------//
	
@Test(priority=18 , dependsOnMethods = "checkvalidation")
	
	public void delete_position()throws InterruptedException  
	{
	   driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div[1]/a")).click();
	   driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div[2]/div/table/tbody/tr[2]/td[4]/span/i")).click();
		
		
		// alert accept
	   driver.switchTo().alert().accept();
	   Thread.sleep(1000);
	   
	   // verify alert message
	   
	   String alert_position_message1 =	driver.findElement(By.className("alertOut")).getText();
	   String real_alert_position_message1 = "×\r\n" + "Position created successfully";
	   System.out.println(real_alert_position_message1);
	   Assert.assertEquals(alert_position_message1,real_alert_position_message1 );
	      
	}

//----------------------------------------------add real position-------------------------------------------//
@Test(priority=19 , dependsOnMethods = "checkvalidation")

public void real_position()throws InterruptedException  
{
	                                  //a position
	 driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div[1]/a")).click();
	
	 //click on add symbol
	 driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div[2]/div/button")).click();
	 Thread.sleep(1000);
	 
	 //code value
	 driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[2]/div/input")).sendKeys("1");
	 // name value
	 driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[1]/div/input")).sendKeys("a");
	
	 //click on submit
	 driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[4]/button")).click();
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div[1]/a")).click();
	  
	                               //b position
	 //click on add symbol
	 driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div[2]/div/button")).click();
	 Thread.sleep(1000);
	 
	 //code value
	 driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[2]/div/input")).sendKeys("2");
	 // name value
	 driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[1]/div/input")).sendKeys("b");
	
	 //click on submit
	 driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[4]/button")).click();
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div[1]/a")).click();
	 
	                              //c position
	 
	 //click on add symbol
	 driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div[2]/div/button")).click();
	 Thread.sleep(1000);
	 
	 //code value
	 driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[2]/div/input")).sendKeys("3");
	 // name value
	 driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[1]/div/input")).sendKeys("c");
	
	 //click on submit
	 driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[4]/button")).click();
	 Thread.sleep(1000);
	 
	 
	                                //d position
	 driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div[1]/a")).click();
	 //click on add symbol
	 driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div[2]/div/button")).click();
	 Thread.sleep(1000);
	 
	 //code value
	 driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[2]/div/input")).sendKeys("4");
	 // name value
	 driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[1]/div/input")).sendKeys("d");
	
	 //click on submit
	 driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[4]/button")).click();
	 Thread.sleep(2000);
	 
	                               //e position
	 
	 driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div[1]/a")).click();
	 //click on add symbol
	 driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div[2]/div/button")).click();
	 Thread.sleep(1000);
	 
	 //code value
	 driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[2]/div/input")).sendKeys("5");
	 // name value
	 driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[1]/div/input")).sendKeys("e");
	
	 //click on submit
	 driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[4]/button")).click();
	 Thread.sleep(2000);
	 
	 driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div[1]/a")).click();
	 
	 
	 //-------------------------------check validation while editing-------------------------------------------------//
	 driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div[2]/div/table/tbody/tr[6]/td[2]/a")).click();
	 Thread.sleep(2000);
	 
	 //name
	 driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[1]/div/input")).clear();
	 driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[1]/div/input")).sendKeys("d");
	 Thread.sleep(1000);
	 
	//code
	 driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[2]/div/input")).clear();
	 driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[2]/div/input")).sendKeys("4");
	 Thread.sleep(1000);
	 
	 //click on submit
	 driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[4]/button")).click();
	 Thread.sleep(2000);
	 
	// validation for position name
	String val7= driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[1]/div/span[2]")).getText();
	String rval7 = "Name already exists.";
	Assert.assertEquals(val7, rval7);
				
	//validation for position code
				
	String val8= driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[2]/div/span[2]")).getText();
	String rval8 = "Position Code already exists.";
	Assert.assertEquals(val8, rval8);	
	Thread.sleep(1000);
	
	
	 // clear both value
	
	 driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[1]/div/input")).clear();
	 driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[2]/div/input")).clear();
	 
	 //code value
	 driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[2]/div/input")).sendKeys("5");
	 // name value
	 driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[1]/div/input")).sendKeys("e");
	
	 //click on submit
	 driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[4]/button")).click();
	 Thread.sleep(2000);
	
}
}








