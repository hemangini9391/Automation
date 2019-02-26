package src;
//import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
//import org.openqa.selenium.support.ui.Select;

public class Signup {
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
	
 //----------------------------------------last name with special symbol-------------------------------------------------------//
	
	@Test(priority=4 , dependsOnMethods = "checkvalidation")
	        public void lastnamespecialchar()throws InterruptedException  
	        {
	        	//enter special symbol
	        	 WebElement l_name = driver.findElement(By.id("m_user_login_last_name"));
			     l_name.sendKeys("&&*()#!@");
			    // Thread.sleep(2000);
			     driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div[5]/div[1]/div/button")).submit();
			     String l_name_result = driver.findElement(By.id("m_user_login_last_name-error")).getText();
			     String expected_l_name_result ="special symbols are not allowed.";
				 Assert.assertEquals(expected_l_name_result,l_name_result);
	       }
//------------------------------------last name with integer---------------------------------------------------------//	
	
	
//	@Test(priority=5 , dependsOnMethods = "checkvalidation")
//	
//		    public void lastnameinteger()throws InterruptedException  
//		    {
//				 //enter integer number  
//				 WebElement l_namespecialchar = driver.findElement(By.id("m_user_login_last_name"));
//				 l_namespecialchar.clear();
//				 l_namespecialchar.sendKeys("12345678");
//			    // Thread.sleep(2000);
//				 driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div[5]/div[1]/div/button")).submit();
//			     String l_name_result1 = driver.findElement(By.id("m_user_login_last_name-error")).getText();
//			     String expected_l_name_result1 ="Integers are not allowed";
//				 Assert.assertEquals(expected_l_name_result1,l_name_result1);
//		    }
	
//-------------------------------------last name with real value--------------------------------------------------------//	
	
	
  @Test(priority=6 , dependsOnMethods = "checkvalidation")
           
  
			 public void lastnamereal()throws InterruptedException  
		      {
	  				
	  				WebElement l_namereal = driver.findElement(By.id("m_user_login_last_name"));
	  				l_namereal.clear();
	  				l_namereal.sendKeys("patel");
			       // Thread.sleep(2000);
				 
			  }
			
				 
			  
//----------------------------------------first name with special symbol--------------------------------------//


	@Test(priority=7 , dependsOnMethods = "checkvalidation")
	
	         public void firstnamespecialchar()throws InterruptedException  
	         {
	        	 //enter special symbol
		        
	        	 WebElement f_name = driver.findElement(By.id("m_user_login_first_name"));
			     f_name.sendKeys("&&*()#!@");
			     Thread.sleep(2000);
			     driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div[5]/div[1]/div/button")).submit();
			     String f_name_result = driver.findElement(By.id("m_user_login_first_name-error")).getText();
			     String expected_f_name_result ="special symbols are not allowed";
				 Assert.assertEquals(expected_f_name_result,f_name_result);
	         }
	
//---------------------------------------------firstname with integer----------------------------------------------//	
	@Test(priority=8 , dependsOnMethods = "checkvalidation")
	
	
		     public void firstnameinteger()throws InterruptedException  
		         
		     {	
				 //enter integer number
				
				 WebElement f_namespecialchar = driver.findElement(By.id("m_user_login_first_name"));
				 f_namespecialchar.clear();
				 f_namespecialchar.sendKeys("12345678");
			     Thread.sleep(2000);
				 driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div[5]/div[1]/div/button")).submit();
			     String f_name_result1 = driver.findElement(By.id("m_user_login_first_name-error")).getText();
			     String expected_f_name_result1 ="Integers are not allowed";
				 Assert.assertEquals(expected_f_name_result1,f_name_result1);
		    }
	
//------------------------------------------first name with real value-----------------------------------------------//	
				 
  @Test(priority=9 , dependsOnMethods = "checkvalidation")

               
			public void firstnamereal()throws InterruptedException  
			
		    {
	            //enter firstname real
	     		
				 WebElement l_namereal = driver.findElement(By.id("m_user_login_first_name"));
				 l_namereal.clear();
				 l_namereal.sendKeys("Chandni");
			     Thread.sleep(2000);
			}
			
//--------------------------------------------phone number with character---------------------------------------//

  
  @Test(priority=10 , dependsOnMethods = "checkvalidation")
  
         //enter character and check validation 
  
		 public void ph_numberchar()throws InterruptedException  
	     {
	         
			 WebElement ph_number = driver.findElement(By.id("m_user_login_phone"));
			 ph_number.clear();
			 ph_number.sendKeys("Testphonenumber");
	         Thread.sleep(2000);
		     driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div[5]/div[1]/div/button")).submit();
		     String ph_number_result = driver.findElement(By.id("phone_validation_msg")).getText();
		     String ph_validation_massage = "please enter phone number with 10 digit ";
		     Assert.assertEquals(ph_number_result, ph_validation_massage);
		     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		    
	    }
  
  
  
 //---------------------------------------------phone number with special symbol-----------------------------------//
  
    @Test(priority=11 , dependsOnMethods = "checkvalidation")
		    // enter special character and check validation
		  
			 public void ph_numberspecialchar()throws InterruptedException  
			 {
    	         
				 WebElement ph_numberspecialchar = driver.findElement(By.id("m_user_login_phone"));
				 ph_numberspecialchar.clear();
				 ph_numberspecialchar.sendKeys("&&*()@#$");
			     Thread.sleep(2000);
				 driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div[5]/div[1]/div/button")).submit();
				 String ph_number_result1 = driver.findElement(By.id("phone_validation_msg")).getText();
				 String ph_validation_massage1 = "please enter phone number with 10 digit ";
				 Assert.assertEquals(ph_number_result1, ph_validation_massage1);
		 }
    
   //------------------------------------------phone number with less then 10 digit--------------------------------------// 

 @Test(priority=12 , dependsOnMethods = "checkvalidation")
  
		   //enter less than 10 digit and check validation
  
			 public void ph_numberless()throws InterruptedException  
			 {
		        
				 WebElement ph_numberless = driver.findElement(By.id("m_user_login_phone"));
				 ph_numberless.clear();
				 ph_numberless.sendKeys("12345");
			     Thread.sleep(2000);
 				 driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div[5]/div[1]/div/button")).submit();
				 String ph_number_result2 = driver.findElement(By.id("phone_validation_msg")).getText();
				 String ph_validation_massage2 = "please enter phone number with 10 digit ";
				 Assert.assertEquals(ph_number_result2, ph_validation_massage2);
		     }

 //--------------------------------- phone number with more then 10 digit----------------------------//

 @Test(priority=13 , dependsOnMethods = "checkvalidation")
  
 //enter more than 10 digit

			 public void ph_numbermore()throws InterruptedException  
			 { 
	 
	          
				 WebElement ph_numbermore = driver.findElement(By.id("m_user_login_phone"));
				 ph_numbermore.clear();
				 ph_numbermore.sendKeys("12345678987");
			     Thread.sleep(2000);
				 driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div[5]/div[1]/div/button")).submit();
				 String ph_number_result3 = driver.findElement(By.id("phone_validation_msg")).getText();
				 String ph_validation_massage3 = "please enter phone number with 10 digit ";
				 Assert.assertEquals(ph_number_result3, ph_validation_massage3);
				 
			 
			 }
 
 
 //--------------------------------- phone number with alphabet+ integer --------------------------------------//

// @Test(priority=14, dependsOnMethods = "checkvalidation")
 
 //enter more than 10 digit

			 public void ph_numbermix()throws InterruptedException  
			 { 
	 
	          
				 WebElement ph_numbermore = driver.findElement(By.id("m_user_login_phone"));
				 ph_numbermore.clear();
				 ph_numbermore.sendKeys("abcdr1222");
			     Thread.sleep(2000);
				 driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div[5]/div[1]/div/button")).submit();
				 String ph_number_result4 = driver.findElement(By.id("phone_validation_msg")).getText();
				 String ph_validation_massage4 = "please enter phone number with 10 digit ";
				 Assert.assertEquals(ph_number_result4, ph_validation_massage4);
		  } 
 //-------------------------------------------real phone number------------------------------------------------------//
  
 // enter real phone number
  @Test(priority=15 , dependsOnMethods = "checkvalidation")

			 public void ph_number_real()throws InterruptedException  
			 {
                 WebElement ph_number_real = driver.findElement(By.id("m_user_login_phone"));
				 ph_number_real.clear();
				 ph_number_real.sendKeys("7567630234");
	    	    Thread.sleep(2000); }
  
//-------------------------------------------E-mail -----------------------------------------------------//
  
  
  @Test(priority=16 , dependsOnMethods = "checkvalidation")

			 public void email()throws InterruptedException  
			 {
			  // enter only name
	  
				 WebElement email = driver.findElement(By.id("m_user_login_email"));
				 email.clear();
				 email.sendKeys("test");
			     Thread.sleep(2000);
				 driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div[5]/div[1]/div/button")).submit();
				 String email_expect_msg = driver.findElement(By.id("m_user_login_email-error")).getText();
				 String email_validation_msg = "Please enter a valid email address.";
			     Assert.assertEquals(email_expect_msg,email_validation_msg);
			     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			 }
  
  //--------------------------------enter email with dot------------------------------------------------------//
  
  @Test(priority=17 , dependsOnMethods = "checkvalidation")

		 public void email_dot()throws InterruptedException  
		 {
		  //enter email with dot
	        
			 WebElement email_dot = driver.findElement(By.id("m_user_login_email"));
			 email_dot.clear();
			 email_dot.sendKeys("test@..");
	         Thread.sleep(2000);
			 driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div[5]/div[1]/div/button")).submit();
			 String email_expect_msg1 = driver.findElement(By.id("m_user_login_email-error")).getText();
			 String email_validation_msg1 = "Please enter a valid email address.";
		     Assert.assertEquals(email_expect_msg1,email_validation_msg1);
		 }
//  
  
  //------------------------------------enter email with special character---------------------------------------------------------//
  
  @Test(priority=18 , dependsOnMethods = "checkvalidation")

			 public void email_specialsymbol()throws InterruptedException  
			 {
			  // enter email with special symbol, name and integer
	  
	  
				 WebElement email_specialsymbol = driver.findElement(By.id("m_user_login_email"));
				 email_specialsymbol.clear();
				 email_specialsymbol.sendKeys("test@123&*");
			     Thread.sleep(2000);
				 driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div[5]/div[1]/div/button")).submit();
				 String email_expect_msg2 = driver.findElement(By.id("m_user_login_email-error")).getText();
				 String email_validation_msg2 = "Please enter a valid email address.";
			     Assert.assertEquals(email_expect_msg2,email_validation_msg2);
			 }
  
  //------------------------------------enter email with integer and alphabets-----------------------------------------------------------//
  
  @Test(priority=19 , dependsOnMethods = "checkvalidation")

			 public void email_int()throws InterruptedException  
			 {
			  // enter email with integer
	  
				 WebElement email_int = driver.findElement(By.id("m_user_login_email"));
				 email_int.clear();
				 email_int.sendKeys("test12");
		         Thread.sleep(2000);
				 driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div[5]/div[1]/div/button")).submit();
				 String email_expect_msg3 = driver.findElement(By.id("m_user_login_email-error")).getText();
				 String email_validation_msg3 = "Please enter a valid email address.";
			     Assert.assertEquals(email_expect_msg3,email_validation_msg3);
	  		
			 }

  
 //----------------------------------------random email generate---------------------------------------------------------//
  
  @Test(priority=20 , dependsOnMethods = "checkvalidation")

			 public void email_real()throws InterruptedException  
			 
			 {
			    //enter require email
	             driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				 WebElement email_real = driver.findElement(By.id("m_user_login_email"));
				 email_real.clear();
			 
			   // method for send email randomly
				 Random r =new Random();
				 String email ="Userr"+r.nextInt(1000)+"@yopmail.com";
				 //System.out.println(email);
				 email_real.sendKeys(email);
			     Thread.sleep(2000);

			 }

  //------------------------------------password with less than eight digit------------------------------------------------//

    
  @Test(priority=21 , dependsOnMethods = "checkvalidation")

		  //less than eight digit
  
			 public void password()throws InterruptedException  
			 {
	  
	             driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				 WebElement password = driver.findElement(By.id("m_user_login_password"));
				 password.clear();
				 password.sendKeys("123456");
			     Thread.sleep(2000);
				 driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div[5]/div[1]/div/button")).submit();
				 String password_expect_msg = driver.findElement(By.id("m_user_login_password-error")).getText();
				 String password_validation_msg = "Please enter at least 8 characters.";
			     Assert.assertEquals(password_expect_msg,password_validation_msg);
			 
			 }

//--------------------------password with less than eight alphabet--------------------------------------------------------// 
//  
  @Test(priority=22 , dependsOnMethods = "checkvalidation")
  
	  public void password_alpha()throws InterruptedException  
		 {
			 WebElement password_alpha = driver.findElement(By.id("m_user_login_password"));
			 password_alpha.clear();
			 password_alpha.sendKeys("abcde");
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div[5]/div[1]/div/button")).submit();
			 String password_expect_msg1 = driver.findElement(By.id("m_user_login_password-error")).getText();
			 String password_validation_msg1 = "Please enter at least 8 characters.";
		     Assert.assertEquals(password_expect_msg1,password_validation_msg1);
		 
		 }
  
  
//--------------------------password with 8 alphabet --------------------------------------------------------// 
  
  @Test(priority=23 , dependsOnMethods = "checkvalidation")
  
	  public void password_mix()throws InterruptedException  
		 {
			 WebElement password_alpha = driver.findElement(By.id("m_user_login_password"));
			 password_alpha.clear();
			 password_alpha.sendKeys("chandnii");
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div[5]/div[1]/div/button")).submit();
			 String password_expect_msg2 = driver.findElement(By.id("m_user_login_password-error")).getText();
			 String password_validation_msg2 = "Please enter 8 digit password with character and integer";
		     Assert.assertEquals(password_expect_msg2,password_validation_msg2);
		 
		 }
  
  
//--------------------------password with 8 integer --------------------------------------------------------// 
  
  @Test(priority=24 , dependsOnMethods = "checkvalidation")
  
	  public void password_i()throws InterruptedException  
		 {
			 WebElement password_alpha = driver.findElement(By.id("m_user_login_password"));
			 password_alpha.clear();
			 password_alpha.sendKeys("123456789");
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div[5]/div[1]/div/button")).submit();
			 String password_expect_msg3 = driver.findElement(By.id("m_user_login_password-error")).getText();
			 String password_validation_msg3 = "Please enter 8 digit password with character and integer";
		     Assert.assertEquals(password_expect_msg3,password_validation_msg3);
		 
		 }
  
  //--------------------------------------------real password------------------------------------------------------//
  
  @Test(priority=25 , dependsOnMethods = "checkvalidation")
  
    // real password
   
	      public void password_real()throws InterruptedException  
		  {
	  
			 WebElement password_alpha = driver.findElement(By.id("m_user_login_password"));
			 password_alpha.clear();
			 password_alpha.sendKeys("password38");
			 Thread.sleep(2000);
			 
		 }

 //-----------------------------------------confirm password------------------------------------------------------//
  

  
@Test(priority=26 , dependsOnMethods = "checkvalidation")

//-------------------------- enter less then 8 character----------------------------------------------------------//

	     public void confirm_password()throws InterruptedException  
         {
             
			 WebElement confirm_password = driver.findElement(By.id("m_user_login_password_confirmation"));
			 confirm_password.clear();
			 confirm_password.sendKeys("abcdef");
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div[5]/div[1]/div/button")).submit();
			 String confirm_pass_expect_msg = driver.findElement(By.id("m_user_login_password_confirmation-error")).getText();
			 String confirm_pass_validation_msg = "Please enter at least 8 characters.";
		     Assert.assertEquals( confirm_pass_expect_msg , confirm_pass_validation_msg);
		     
	      }


//---------------------------------------enter less than 8 integer-------------------------------------------------//
//
   @Test(priority=27 , dependsOnMethods = "checkvalidation")
	      public void confirm_password_int()throws InterruptedException  
		   {
            WebElement confirm_password_int = driver.findElement(By.id("m_user_login_password_confirmation"));
		    confirm_password_int.clear();
		    confirm_password_int.sendKeys("123456");
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div[5]/div[1]/div/button")).submit();
		    String confirm_pass_expect_msg1 = driver.findElement(By.id("m_user_login_password_confirmation-error")).getText();
		    String confirm_pass_validation_msg1 = "Please enter at least 8 characters.";
		    Assert.assertEquals( confirm_pass_expect_msg1 , confirm_pass_validation_msg1); }
   
 //---------------------------------------enter less than 8 integer-------------------------------------------------//

   @Test(priority=28 , dependsOnMethods = "checkvalidation")
    public void confirm_password_i()throws InterruptedException  
		   {
            WebElement confirm_password_int = driver.findElement(By.id("m_user_login_password_confirmation"));
		    confirm_password_int.clear();
		    confirm_password_int.sendKeys("12345678");
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div[5]/div[1]/div/button")).submit();
		    String confirm_pass_expect_msg2 = driver.findElement(By.id("m_user_login_password_confirmation-error")).getText();
		    String confirm_pass_validation_msg2 = "Please enter the same value again.";
		    Assert.assertEquals( confirm_pass_expect_msg2 , confirm_pass_validation_msg2);}


 //--------------------------------------------digit and alphabet---------------------------------------------------------//
   
   @Test(priority=29 , dependsOnMethods = "checkvalidation")
 
      public void confirm_password_8()throws InterruptedException  
	   {
	   
	       
	        WebElement confirm_password_8 = driver.findElement(By.id("m_user_login_password_confirmation"));
		    confirm_password_8.clear();
		    confirm_password_8.sendKeys("1234abcd");
		    Thread.sleep(2000);
  		    driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div[5]/div[1]/div/button")).submit();
		    String confirm_pass_expect_msg2 = driver.findElement(By.id("m_user_login_password_confirmation-error")).getText();
		    String confirm_pass_validation_msg2 = "Please enter the same value again.";
	        Assert.assertEquals( confirm_pass_expect_msg2 , confirm_pass_validation_msg2);
       }
   
   
   //------------------------ real confirm password--------------------------------------------------------------//
   
  @Test(priority=30, dependsOnMethods = "checkvalidation")
   
        public void confirm_password_real()throws InterruptedException  
        {
	   
           WebElement confirm_password_8 = driver.findElement(By.id("m_user_login_password_confirmation"));
		   confirm_password_8.clear();
		   confirm_password_8.sendKeys("password38");
		   Thread.sleep(2000);
    
        }
   
//------------------------------------------ checkbox select----------------------------------------------------//
   
   @Test(priority=31 , dependsOnMethods = "checkvalidation")
  
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
   
   @Test(priority=32 , dependsOnMethods = "checkvalidation")
   
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
	    
   }
}