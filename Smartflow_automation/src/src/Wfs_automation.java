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
import org.openqa.selenium.support.ui.Select;


public class Wfs_automation {
	
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
	
//	@Test(priority=4 , dependsOnMethods = "checkvalidation")
//	
//	       public void lastnamespecialchar()throws InterruptedException  
//	       {
//	        	 //enter special symbol
//	        	 
//		        
//	        	 WebElement l_name = driver.findElement(By.id("m_user_login_last_name"));
//			     l_name.sendKeys("&&*()#!@");
//			    // Thread.sleep(2000);
//			     driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div[5]/div[1]/div/button")).submit();
//			     String l_name_result = driver.findElement(By.id("m_user_login_last_name-error")).getText();
//			     String expected_l_name_result ="special symbols are not allowed.";
//				 Assert.assertEquals(expected_l_name_result,l_name_result);
//			
//				
//	         
//	       }
	
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


//	@Test(priority=7 , dependsOnMethods = "checkvalidation")
//	
//	         public void firstnamespecialchar()throws InterruptedException  
//	         {
//	        	 //enter special symbol
//		        
//	        	 WebElement f_name = driver.findElement(By.id("m_user_login_first_name"));
//			     f_name.sendKeys("&&*()#!@");
//			   //  Thread.sleep(2000);
//			     driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div[5]/div[1]/div/button")).submit();
//			     String f_name_result = driver.findElement(By.id("m_user_login_first_name-error")).getText();
//			     String expected_f_name_result ="special symbols are not allowed";
//				 Assert.assertEquals(expected_f_name_result,f_name_result);
//				 
//	         }
	
//---------------------------------------------firstname with integer----------------------------------------------//	
//	@Test(priority=8 , dependsOnMethods = "checkvalidation")
//	
//	
//		     public void firstnameinteger()throws InterruptedException  
//		         
//		     {	
//				 //enter integer number
//				
//				 WebElement f_namespecialchar = driver.findElement(By.id("m_user_login_first_name"));
//				 f_namespecialchar.clear();
//				 f_namespecialchar.sendKeys("12345678");
//			    // Thread.sleep(2000);
//				 driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div[5]/div[1]/div/button")).submit();
//			     String f_name_result1 = driver.findElement(By.id("m_user_login_first_name-error")).getText();
//			     String expected_f_name_result1 ="Integers are not allowed";
//				 Assert.assertEquals(expected_f_name_result1,f_name_result1);
//		    }
	
//------------------------------------------first name with real value-----------------------------------------------//	
				 
  @Test(priority=9 , dependsOnMethods = "checkvalidation")

               
			public void firstnamereal()throws InterruptedException  
			
		    {
	            //enter firstname real
	     		
				 WebElement l_namereal = driver.findElement(By.id("m_user_login_first_name"));
				 l_namereal.clear();
				 l_namereal.sendKeys("Chandni");
			   //  Thread.sleep(2000);
			}
			
//--------------------------------------------phone number with character---------------------------------------//

  
//  @Test(priority=10 , dependsOnMethods = "checkvalidation")
//  
//         //enter character and check validation 
//  
//		 public void ph_numberchar()throws InterruptedException  
//	     {
//	         
//			 WebElement ph_number = driver.findElement(By.id("m_user_login_phone"));
//			 ph_number.clear();
//			 ph_number.sendKeys("Testphonenumber");
//		  //   Thread.sleep(2000);
//		     driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div[5]/div[1]/div/button")).submit();
//		     String ph_number_result = driver.findElement(By.id("phone_validation_msg")).getText();
//		     String ph_validation_massage = "please enter phone number with 10 digit ";
//		     Assert.assertEquals(ph_number_result, ph_validation_massage);
//		     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		    
//	    }
  
  
  
 //---------------------------------------------phone number with special symbol-----------------------------------//
  
//    @Test(priority=11 , dependsOnMethods = "checkvalidation")
//		    // enter special character and check validation
//		  
//			 public void ph_numberspecialchar()throws InterruptedException  
//			 {
//    	         
//				 WebElement ph_numberspecialchar = driver.findElement(By.id("m_user_login_phone"));
//				 ph_numberspecialchar.clear();
//				 ph_numberspecialchar.sendKeys("&&*()@#$");
//			 //  Thread.sleep(2000);
//				 driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div[5]/div[1]/div/button")).submit();
//				 String ph_number_result1 = driver.findElement(By.id("phone_validation_msg")).getText();
//				 String ph_validation_massage1 = "please enter phone number with 10 digit ";
//				 Assert.assertEquals(ph_number_result1, ph_validation_massage1);
//				 
//			 
//			 }
//    
    
   //------------------------------------------phone number with less then 10 digit--------------------------------------// 
//
// @Test(priority=12 , dependsOnMethods = "checkvalidation")
//  
//		   //enter less than 10 digit and check validation
//  
//			 public void ph_numberless()throws InterruptedException  
//			 {
//		        
//				 WebElement ph_numberless = driver.findElement(By.id("m_user_login_phone"));
//				 ph_numberless.clear();
//				 ph_numberless.sendKeys("12345");
//			   // Thread.sleep(2000);
// 				 driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div[5]/div[1]/div/button")).submit();
//				 String ph_number_result2 = driver.findElement(By.id("phone_validation_msg")).getText();
//				 String ph_validation_massage2 = "please enter phone number with 10 digit ";
//				 Assert.assertEquals(ph_number_result2, ph_validation_massage2);
//			
//			 
//			 }

 //--------------------------------- phone number with more then 10 digit----------------------------//
//
// @Test(priority=13 , dependsOnMethods = "checkvalidation")
//  
// //enter more than 10 digit
//
//			 public void ph_numbermore()throws InterruptedException  
//			 { 
//	 
//	          
//				 WebElement ph_numbermore = driver.findElement(By.id("m_user_login_phone"));
//				 ph_numbermore.clear();
//				 ph_numbermore.sendKeys("12345678987");
//			  //   Thread.sleep(2000);
//				 driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div[5]/div[1]/div/button")).submit();
//				 String ph_number_result3 = driver.findElement(By.id("phone_validation_msg")).getText();
//				 String ph_validation_massage3 = "please enter phone number with 10 digit ";
//				 Assert.assertEquals(ph_number_result3, ph_validation_massage3);
//				 
//			 
//			 }
// 
 
 //--------------------------------- phone number with alphabet+ integer --------------------------------------//

// @Test(priority=14, dependsOnMethods = "checkvalidation")
//  
// //enter more than 10 digit
//
//			 public void ph_numbermix()throws InterruptedException  
//			 { 
//	 
//	          
//				 WebElement ph_numbermore = driver.findElement(By.id("m_user_login_phone"));
//				 ph_numbermore.clear();
//				 ph_numbermore.sendKeys("abcdr1222");
//			   //  Thread.sleep(2000);
//				 driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div[5]/div[1]/div/button")).submit();
//				 String ph_number_result4 = driver.findElement(By.id("phone_validation_msg")).getText();
//				 String ph_validation_massage4 = "please enter phone number with 10 digit ";
//				 Assert.assertEquals(ph_number_result4, ph_validation_massage4);
//				 
//			 
//			 }
 
 
 //-------------------------------------------real phone number------------------------------------------------------//
  
 // enter real phone number
  @Test(priority=15 , dependsOnMethods = "checkvalidation")

			 public void ph_number_real()throws InterruptedException  
			 {
                 WebElement ph_number_real = driver.findElement(By.id("m_user_login_phone"));
				 ph_number_real.clear();
				 ph_number_real.sendKeys("7567630234");
	    	  //   Thread.sleep(2000);

			 }
  
//-------------------------------------------E-mail -----------------------------------------------------//
  
  
//  @Test(priority=16 , dependsOnMethods = "checkvalidation")
//
//			 public void email()throws InterruptedException  
//			 {
//			  // enter only name
//	  
//				 WebElement email = driver.findElement(By.id("m_user_login_email"));
//				 email.clear();
//				 email.sendKeys("test");
//			  //   Thread.sleep(2000);
//				 driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div[5]/div[1]/div/button")).submit();
//				 String email_expect_msg = driver.findElement(By.id("m_user_login_email-error")).getText();
//				 String email_validation_msg = "Please enter a valid email address.";
//			     Assert.assertEquals(email_expect_msg,email_validation_msg);
//			     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//			 }
  
  //--------------------------------enter email with dot------------------------------------------------------//
  
//  @Test(priority=17 , dependsOnMethods = "checkvalidation")
//
//		 public void email_dot()throws InterruptedException  
//		 {
//		  //enter email with dot
//	        
//			 WebElement email_dot = driver.findElement(By.id("m_user_login_email"));
//			 email_dot.clear();
//			 email_dot.sendKeys("test@..");
//		//     Thread.sleep(2000);
//			 driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div[5]/div[1]/div/button")).submit();
//			 String email_expect_msg1 = driver.findElement(By.id("m_user_login_email-error")).getText();
//			 String email_validation_msg1 = "Please enter a valid email address.";
//		     Assert.assertEquals(email_expect_msg1,email_validation_msg1);
//		 }
//  
  
  //------------------------------------enter email with special character---------------------------------------------------------//
  
//  @Test(priority=18 , dependsOnMethods = "checkvalidation")
//
//			 public void email_specialsymbol()throws InterruptedException  
//			 {
//			  // enter email with special symbol, name and integer
//	  
//	  
//				 WebElement email_specialsymbol = driver.findElement(By.id("m_user_login_email"));
//				 email_specialsymbol.clear();
//				 email_specialsymbol.sendKeys("test@123&*");
//			//     Thread.sleep(2000);
//				 driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div[5]/div[1]/div/button")).submit();
//				 String email_expect_msg2 = driver.findElement(By.id("m_user_login_email-error")).getText();
//				 String email_validation_msg2 = "Please enter a valid email address.";
//			     Assert.assertEquals(email_expect_msg2,email_validation_msg2);
//			 }
  
  //------------------------------------enter email with integer and alphabets-----------------------------------------------------------//
  
//  @Test(priority=19 , dependsOnMethods = "checkvalidation")
//
//			 public void email_int()throws InterruptedException  
//			 {
//			  // enter email with integer
//	  
//				 WebElement email_int = driver.findElement(By.id("m_user_login_email"));
//				 email_int.clear();
//				 email_int.sendKeys("test12");
//		//	     Thread.sleep(2000);
//				 driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div[5]/div[1]/div/button")).submit();
//				 String email_expect_msg3 = driver.findElement(By.id("m_user_login_email-error")).getText();
//				 String email_validation_msg3 = "Please enter a valid email address.";
//			     Assert.assertEquals(email_expect_msg3,email_validation_msg3);
//	  		
//			 }
//  
  
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
				 String email ="User"+r.nextInt(1000)+"@yopmail.com";
				 //System.out.println(email);
				 email_real.sendKeys(email);
			     Thread.sleep(2000);

			 }

  //------------------------------------password with less than eight digit------------------------------------------------//

    
//  @Test(priority=21 , dependsOnMethods = "checkvalidation")
//
//		  //less than eight digit
//  
//			 public void password()throws InterruptedException  
//			 {
//	  
//	             driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//				 WebElement password = driver.findElement(By.id("m_user_login_password"));
//				 password.clear();
//				 password.sendKeys("123456");
//			     Thread.sleep(2000);
//				 driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div[5]/div[1]/div/button")).submit();
//				 String password_expect_msg = driver.findElement(By.id("m_user_login_password-error")).getText();
//				 String password_validation_msg = "Please enter at least 8 characters.";
//			     Assert.assertEquals(password_expect_msg,password_validation_msg);
//			 
//			 }

//--------------------------password with less than eight alphabet--------------------------------------------------------// 
//  
//  @Test(priority=22 , dependsOnMethods = "checkvalidation")
//  
//	  public void password_alpha()throws InterruptedException  
//		 {
//			 WebElement password_alpha = driver.findElement(By.id("m_user_login_password"));
//			 password_alpha.clear();
//			 password_alpha.sendKeys("abcde");
//			 Thread.sleep(2000);
//			 driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div[5]/div[1]/div/button")).submit();
//			 String password_expect_msg1 = driver.findElement(By.id("m_user_login_password-error")).getText();
//			 String password_validation_msg1 = "Please enter at least 8 characters.";
//		     Assert.assertEquals(password_expect_msg1,password_validation_msg1);
//		 
//		 }
  
  
//--------------------------password with 8 alphabet --------------------------------------------------------// 
  
//  @Test(priority=23 , dependsOnMethods = "checkvalidation")
//  
//	  public void password_mix()throws InterruptedException  
//		 {
//			 WebElement password_alpha = driver.findElement(By.id("m_user_login_password"));
//			 password_alpha.clear();
//			 password_alpha.sendKeys("chandnii");
//			 Thread.sleep(2000);
//			 driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div[5]/div[1]/div/button")).submit();
//			 String password_expect_msg2 = driver.findElement(By.id("m_user_login_password-error")).getText();
//			 String password_validation_msg2 = "Please enter 8 digit password with character and integer";
//		     Assert.assertEquals(password_expect_msg2,password_validation_msg2);
//		 
//		 }
//  
  
//--------------------------password with 8 integer --------------------------------------------------------// 
  
//  @Test(priority=24 , dependsOnMethods = "checkvalidation")
//  
//	  public void password_i()throws InterruptedException  
//		 {
//			 WebElement password_alpha = driver.findElement(By.id("m_user_login_password"));
//			 password_alpha.clear();
//			 password_alpha.sendKeys("123456789");
//			 Thread.sleep(2000);
//			 driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div[5]/div[1]/div/button")).submit();
//			 String password_expect_msg3 = driver.findElement(By.id("m_user_login_password-error")).getText();
//			 String password_validation_msg3 = "Please enter 8 digit password with character and integer";
//		     Assert.assertEquals(password_expect_msg3,password_validation_msg3);
//		 
//		 }
  
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
  

  
//@Test(priority=26 , dependsOnMethods = "checkvalidation")
//
////-------------------------- enter less then 8 character----------------------------------------------------------//
//
//	     public void confirm_password()throws InterruptedException  
//         {
//             
//			 WebElement confirm_password = driver.findElement(By.id("m_user_login_password_confirmation"));
//			 confirm_password.clear();
//			 confirm_password.sendKeys("abcdef");
//			 Thread.sleep(2000);
//			 driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div[5]/div[1]/div/button")).submit();
//			 String confirm_pass_expect_msg = driver.findElement(By.id("m_user_login_password_confirmation-error")).getText();
//			 String confirm_pass_validation_msg = "Please enter at least 8 characters.";
//		     Assert.assertEquals( confirm_pass_expect_msg , confirm_pass_validation_msg);
//		     
//	      }


//---------------------------------------enter less than 8 integer-------------------------------------------------//
//
//   @Test(priority=27 , dependsOnMethods = "checkvalidation")
// 
//   
//	      public void confirm_password_int()throws InterruptedException  
//		   {
//      
//            WebElement confirm_password_int = driver.findElement(By.id("m_user_login_password_confirmation"));
//		    confirm_password_int.clear();
//		    confirm_password_int.sendKeys("123456");
//		    Thread.sleep(2000);
//		    driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div[5]/div[1]/div/button")).submit();
//		    String confirm_pass_expect_msg1 = driver.findElement(By.id("m_user_login_password_confirmation-error")).getText();
//		    String confirm_pass_validation_msg1 = "Please enter at least 8 characters.";
//		    Assert.assertEquals( confirm_pass_expect_msg1 , confirm_pass_validation_msg1);
//		    
//		    
//	     }
   
 //---------------------------------------enter less than 8 integer-------------------------------------------------//

//   @Test(priority=28 , dependsOnMethods = "checkvalidation")
// 
//   
//	      public void confirm_password_i()throws InterruptedException  
//		   {
//      
//            WebElement confirm_password_int = driver.findElement(By.id("m_user_login_password_confirmation"));
//		    confirm_password_int.clear();
//		    confirm_password_int.sendKeys("12345678");
//		    Thread.sleep(2000);
//		    driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div[5]/div[1]/div/button")).submit();
//		    String confirm_pass_expect_msg2 = driver.findElement(By.id("m_user_login_password_confirmation-error")).getText();
//		    String confirm_pass_validation_msg2 = "Please enter the same value again.";
//		    Assert.assertEquals( confirm_pass_expect_msg2 , confirm_pass_validation_msg2);
//		    
//		    
//	     }


 //--------------------------------------------digit and alphabet---------------------------------------------------------//
   
//   @Test(priority=29 , dependsOnMethods = "checkvalidation")
// 
//      public void confirm_password_8()throws InterruptedException  
//	   {
//	   
//	       
//	        WebElement confirm_password_8 = driver.findElement(By.id("m_user_login_password_confirmation"));
//		    confirm_password_8.clear();
//		    confirm_password_8.sendKeys("1234abcd");
//		    Thread.sleep(2000);
//  		    driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div[5]/div[1]/div/button")).submit();
//		    String confirm_pass_expect_msg2 = driver.findElement(By.id("m_user_login_password_confirmation-error")).getText();
//		    String confirm_pass_validation_msg2 = "Please enter the same value again.";
//	        Assert.assertEquals( confirm_pass_expect_msg2 , confirm_pass_validation_msg2);
//       }
//   
   
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
   
   
 //-------------------------------------------Admin----------------------------------------------------------//
   
  @Test(priority=33 , dependsOnMethods = "checkvalidation")
   
   public void admin()throws InterruptedException  
   {
	   driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[4]/div/div/div[2]/div[3]/div/div[1]/a")).click();
	   driver.findElement(By.xpath("//*[@id=\"admin-step\"]/a")).click();
	   driver.findElement(By.xpath("//*[@id=\"admin-step\"]/ul/li[1]/a")).click();
	
   }
  
 //-----------------------------------------------Enter into department----------------------------------------------//
   
 @Test(priority=34 , dependsOnMethods = "checkvalidation")
   
   public void department()throws InterruptedException  
   {
	 
	 //click on department
	 driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/div/div[2]/div/div[1]/span/a")).click();
	 Thread.sleep(2000);
	 // add department
     driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/div[2]/a/button/i[1]")).click();
     Thread.sleep(2000);
     
   }
 
 //---------------------department(click on submit and check validation of code and name)---------------------------------------------------//
 
 @Test(priority=35 , dependsOnMethods = "department")
 
 public void department_submit()throws InterruptedException  
 {
    // click on submit without adding any value
     
    driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/form/div[3]/button")).click();
    
    
    // validation of department name
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    String dept1 = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/form/div[1]/div[1]/div/span[3]/span")).getText();
    String deptmsg = "Name is required";
    Assert.assertEquals(dept1,deptmsg);
    
    
   // validation of department code
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    String dept2 = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/form/div[1]/div[2]/div/span[3]/span")).getText();
    String deptcodemsg = "Code is required";
    Assert.assertEquals(dept2,deptcodemsg);
  
 }
 
 //---------------------department(enter only department name)---------------------------------------------------//
    
 @Test(priority=36 , dependsOnMethods = "department")
 
 public void department_name()throws InterruptedException  
 {
    // enter only dept name and see code validation
    
	    driver.findElement(By.name("dept_name")).clear();
	    driver.findElement(By.name("dept_name")).sendKeys("A");
	    Thread.sleep(2000);	
	    
	    driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/form/div[3]/button")).click();
	    String dept21 = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/form/div[1]/div[2]/div/span[3]/span")).getText();
	    String deptcodemsg1 = "Code is required";
	    
	    Assert.assertEquals(dept21,deptcodemsg1);
	    driver.findElement(By.name("dept_name")).clear();
}
//    
 
 //---------------------department(enter only department code )---------------------------------------------------//

 @Test(priority=37 , dependsOnMethods = "department")
 
 public void departmenttcode()throws InterruptedException  
 
  // enter only dept code and see name validation
 
 {
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.findElement(By.name("code")).clear();
    driver.findElement(By.name("code")).sendKeys("02");
    Thread.sleep(2000);
    
    driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/form/div[3]/button")).click();
    String dept211 = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/form/div[1]/div[1]/div/span[3]/span")).getText();
    String deptcodemsg11 = "Name is required";
    
    Assert.assertEquals(dept211,deptcodemsg11);
    driver.findElement(By.name("dept_name")).clear();
   
 }  
 
 //---------------------department(department with real value)-----------------------------------------------------//

 
@Test(priority=38 , dependsOnMethods = "department")

public void dept_real()throws InterruptedException  
{
	// real value
	 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	 driver.findElement(By.name("dept_name")).clear();
	 driver.findElement(By.name("dept_name")).sendKeys("A");
	 Thread.sleep(2000);
	 
	 driver.findElement(By.name("code")).clear();
	 driver.findElement(By.name("code")).sendKeys("2");
	 Thread.sleep(2000);
	 
     driver.findElement(By.id("textArea")).sendKeys("This is A department");
	 driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/form/div[3]/button")).click();
	 Thread.sleep(2000);
}


//-----------------------------------------department validation while edit------------------------------------------------------//


@Test(priority =39 , dependsOnMethods = "department")

public void dept_edit() throws InterruptedException

{
	driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/div[2]/div[3]/div/div/ul/li[2]/h4/a/span")).click();
	
	     Thread.sleep(2000);		 
		 driver.findElement(By.name("dept_name")).clear();
		 driver.findElement(By.name("dept_name")).sendKeys("unassigned");
		 
		 Thread.sleep(2000);
		 driver.findElement(By.name("code")).clear();
		 driver.findElement(By.name("code")).sendKeys("01");
		 Thread.sleep(3000);
		 
		 driver.findElement(By.id("textArea")).clear();
	     driver.findElement(By.id("textArea")).sendKeys("This is A department");
		 driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/form/div[3]/button")).click();
		 Thread.sleep(3000);

		// validation of department name
		 String dept1 = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/form/div[1]/div[1]/div/span[4]")).getText();
		 String deptmsg = "Name already exists.";
		 Assert.assertEquals(dept1,deptmsg);
		    
		    
		 // validation of department code
		 String dept2 = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/form/div[1]/div[2]/div/span[4]")).getText();
		 String deptcodemsg = "Department Code already exists.";
		 Assert.assertEquals(dept2,deptcodemsg);
		 
		 
		 driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/form/div[3]/a")).click();
		 Thread.sleep(1000);
		 	   
}


//-----------------------------------enter department with parent dept-------------------------------------------------------// 

@Test (priority=40 , dependsOnMethods = "department")

public void parent_dept()throws InterruptedException

{
  driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/div[2]/a/button")).click();
  Thread.sleep(1000);
  
  driver.findElement(By.name("dept_name")).clear();
  driver.findElement(By.name("dept_name")).sendKeys("a1");
  Thread.sleep(2000);
	 
  driver.findElement(By.name("code")).clear();
  driver.findElement(By.name("code")).sendKeys("3");
  Thread.sleep(2000);
  
  // select parent department 
  
  Select parent_dept = new Select(driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/form/div[1]/div[3]/div/select")));
  parent_dept.selectByVisibleText("A");
 
	 
  driver.findElement(By.id("textArea")).sendKeys("This is a1 department");
  driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/form/div[3]/button")).click();
  Thread.sleep(2000);
  
}



//------------------------------- Enter B department-----------------------------------------------------------------------//



@Test(priority=41 , dependsOnMethods = "department")

public void dept_B_delete()throws InterruptedException  
{
	// real value
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/div[2]/a/button")).click();
	 
	 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	 driver.findElement(By.name("dept_name")).clear();
	 driver.findElement(By.name("dept_name")).sendKeys("B");
	 Thread.sleep(2000);
	 
	 driver.findElement(By.name("code")).clear();
	 driver.findElement(By.name("code")).sendKeys("4");
	 Thread.sleep(2000);
	 
     driver.findElement(By.id("textArea")).sendKeys("This is B department");
	 driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/form/div[3]/button")).click();
	 Thread.sleep(2000);
	 
	 
	 //enter b1 with parent dept
	 
	  driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/div[2]/a/button")).click();
	  Thread.sleep(1000);
	  
	  driver.findElement(By.name("dept_name")).clear();
	  driver.findElement(By.name("dept_name")).sendKeys("b1");
	  Thread.sleep(2000);
		 
	  driver.findElement(By.name("code")).clear();
	  driver.findElement(By.name("code")).sendKeys("5");
	  Thread.sleep(2000);
	  
	  // select parent department 
	  
	  Select parent_dept = new Select(driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/form/div[1]/div[3]/div/select")));
	  parent_dept.selectByVisibleText("B");
	 
		 
	  driver.findElement(By.id("textArea")).sendKeys("This is b1 department");
	  driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/form/div[3]/button")).click();
	  Thread.sleep(2000);
	 
	  // delete B dept
	  
	  driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/div[2]/div[3]/div/div/ul/li[3]/h4/span/span/i")).click();
	  
	//alert gettext massage
      
	    String text111  =  driver.switchTo().alert().getText();
	    System.out.println(text111);
	        		
	 // alert accept
	     driver.switchTo().alert().accept();
	     
	     
	 // delete b1
	 Thread.sleep(2000);    
	 driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/div[2]/div[3]/div/div/ul/li[3]/h4/span/span/i")).click();
	
	 driver.switchTo().alert();
	   
	        		
	 // alert accept
	 driver.switchTo().alert().accept();
	 Thread.sleep(1000);
	    
}

//--------------------------------------------------Enter C,D,E  department----------------------------------------//

@Test(priority=42 , dependsOnMethods = "department")

public void dept_c_dept()throws InterruptedException  
{
	// real value
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/div[2]/a/button")).click();
	 
	 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	 driver.findElement(By.name("dept_name")).clear();
	 driver.findElement(By.name("dept_name")).sendKeys("C");
	 Thread.sleep(2000);
	 
	 driver.findElement(By.name("code")).clear();
	 driver.findElement(By.name("code")).sendKeys("04");
	 Thread.sleep(2000);
	 
     driver.findElement(By.id("textArea")).sendKeys("This is B department");
	 driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/form/div[3]/button")).click();
	 Thread.sleep(2000);
	 
	 
      // D dept
	 
	  driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/div[2]/a/button")).click();
	  Thread.sleep(1000);
	  
	  driver.findElement(By.name("dept_name")).clear();
	  driver.findElement(By.name("dept_name")).sendKeys("D");
	  Thread.sleep(2000);
		 
	  driver.findElement(By.name("code")).clear();
	  driver.findElement(By.name("code")).sendKeys("5");
	  Thread.sleep(2000);
	  	 
	  driver.findElement(By.id("textArea")).sendKeys("This is D department");
	  driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/form/div[3]/button")).click();
	  Thread.sleep(2000);
	    


      // E dept
	  driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/div[2]/a/button")).click();
	  Thread.sleep(1000);

	  driver.findElement(By.name("dept_name")).clear();
	  driver.findElement(By.name("dept_name")).sendKeys("E");
	  Thread.sleep(2000);
	 
	  driver.findElement(By.name("code")).clear();
	  driver.findElement(By.name("code")).sendKeys("6");
	  Thread.sleep(2000);
	 
	  driver.findElement(By.id("textArea")).sendKeys("This is E department");
	  driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/form/div[3]/button")).click();
	  Thread.sleep(2000);
	  
	  
	// b dept
	     Thread.sleep(1000);
		 driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/div[2]/a/button")).click();
		 
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 driver.findElement(By.name("dept_name")).clear();
		 driver.findElement(By.name("dept_name")).sendKeys("B");
		 Thread.sleep(2000);
		 
		 driver.findElement(By.name("code")).clear();
		 driver.findElement(By.name("code")).sendKeys("08");
		 Thread.sleep(2000);
		 
	     driver.findElement(By.id("textArea")).sendKeys("This is B department");
		 driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/form/div[3]/button")).click();
		 Thread.sleep(2000);
		
}



//-----------------------------------------department upload using blank csv---------------------------------------------------// 


//@Test(priority=43 , dependsOnMethods = "department")
//
//   public void dept_csv() throws InterruptedException
//   {
//   //  blank csv upload
//	
//      driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/div[2]/div[1]/button[1]")).click();
//      WebElement uploadElement = driver.findElement(By.id("upload"));
//      uploadElement.sendKeys("‪C:\\Users\\rising1\\Desktop\\sample_department_list (2).csv");
//      driver.findElement(By.xpath("//*[@id=\"csv-upload\"]/div/div/div[3]/button")).click();
//      Thread.sleep(2000);
//      
//      
//      String alert_msg = driver.findElement(By.className("alertOut")).getText();
//      System.out.println("Alert Box message: " + alert_msg);
//      String alert_msg_real="×\n" + "Please Check CSV Sample data file.";
//      Assert.assertEquals(alert_msg, alert_msg_real);
//      
//      
//}


//--------------------------------------department csv upload with same above data--------------------------------------------//


//@Test(priority=44 , dependsOnMethods = "department")
//
//public void dept_csv_samedata() throws InterruptedException
//{
//   Thread.sleep(1000);
//   driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/div[2]/div[1]/button[1]")).click();
//   WebElement uploadElements = driver.findElement(By.id("upload"));
//   uploadElements.sendKeys("‪E:\\dept automation file\\sd.csv");
//   driver.findElement(By.xpath("//*[@id=\"csv-upload\"]/div/div/div[3]/button")).click();
//   Thread.sleep(2000);
//   
//   
//   String alert_msg11 = driver.findElement(By.className("alertOut")).getText();
//   System.out.println("Alert Box message: " + alert_msg11);
//   String alert_msg_real1="×\n" + "コードは既に登録済です。新しいコードを入力して下さい。";
//   Assert.assertEquals(alert_msg11, alert_msg_real1);
//   
//}
//------------------------------department csv upload with same and different data----------------------------------//

//@Test(priority=45 , dependsOnMethods = "department")
//
//public void dept_csv_samenddiff() throws InterruptedException
//{
////  blank csv upload
//	
//   Thread.sleep(1000);
//   driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/div[2]/div[1]/button[1]")).click();
//   WebElement uploadElementsd = driver.findElement(By.id("upload"));
//   uploadElementsd.sendKeys("‪E:\\dept automation file\\s.csv");
//   driver.findElement(By.xpath("//*[@id=\"csv-upload\"]/div/div/div[3]/button")).click();
//   Thread.sleep(2000);
//   
//   
//   String alert_msg111 = driver.findElement(By.className("alertOut")).getText();
//   System.out.println("Alert Box message: " + alert_msg111);
//   String alert_msg_real11="×\n" + "コードは既に登録済です。新しいコードを入力して下さい。";
//   Assert.assertEquals(alert_msg111, alert_msg_real11);
//}

//--------------------------------------------real csv-----------------------------------------------------------------//

@Test(priority=46 , dependsOnMethods = "department")

public void dept_csv_real() throws InterruptedException
{

	
// Thread.sleep(1000);
	
   driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/div[2]/div[1]/button[1]")).click();
   WebElement uploadElementreal = driver.findElement(By.id("upload"));
   uploadElementreal.sendKeys("E:/dept automation file/real.csv");
   Thread.sleep(2000);
   driver.findElement(By.xpath("//*[@id=\"csv-upload\"]/div/div/div[3]/button")).click();
  
   Thread.sleep(2000);
   String alert_msg1111 = driver.findElement(By.className("alertOut")).getText();
   System.out.println("Alert Box message: " + alert_msg1111);
   String alert_msg_real111= "×\n" + "コードは既に登録済です。新しいコードを入力して下さい。";
   Assert.assertEquals(alert_msg1111, alert_msg_real111);
}


@Test
public void dept_download()
{
  driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/div[2]/div[1]/button[2]//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/div[2]/div[1]/button[2]")).click();
	
}


//------------------------------------department ending------------------------------------------------------------//

}










