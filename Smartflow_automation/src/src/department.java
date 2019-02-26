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


public class department {
	
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
	
 //--------------------------------last name---------------------------------------------------------//
  @Test(priority=4, dependsOnMethods = "checkvalidation")
            public void lastnamereal()throws InterruptedException  
		      {
	  				WebElement l_namereal = driver.findElement(By.id("m_user_login_last_name"));
	  				l_namereal.clear();
	  				l_namereal.sendKeys("patel");
			        Thread.sleep(1000);	 
			  }
//------------------------------------------first name -----------------------------------------------//	
				 
  @Test(priority=5 , dependsOnMethods = "checkvalidation")    
			public void firstnamereal()throws InterruptedException  
		    {   //enter firstname real
	     	     WebElement l_namereal = driver.findElement(By.id("m_user_login_first_name"));
				 l_namereal.clear();
				 l_namereal.sendKeys("Chandni");
			   //  Thread.sleep(2000);
			}
 //----------------------------------------- phone number------------------------------------------------------//
  
 // enter real phone number
  @Test(priority=6 , dependsOnMethods = "checkvalidation")
           public void ph_number_real()throws InterruptedException  
			 {
                 WebElement ph_number_real = driver.findElement(By.id("m_user_login_phone"));
				 ph_number_real.clear();
				 ph_number_real.sendKeys("7567630234");
	    	     Thread.sleep(2000);
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
				 String email ="Userr"+r.nextInt(1000)+"@yopmail.com";
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


   //------------------------ real confirm password--------------------------------------------------------------//
   
  @Test(priority=9, dependsOnMethods = "checkvalidation")
   
        public void confirm_password_real()throws InterruptedException  
        {
	   
           WebElement confirm_password_8 = driver.findElement(By.id("m_user_login_password_confirmation"));
		   confirm_password_8.clear();
		   confirm_password_8.sendKeys("password38");
		   Thread.sleep(2000);
    
        }
//------------------------------------------ check box select----------------------------------------------------//
   
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
	    
   }
   
   
 //-------------------------------------------Admin----------------------------------------------------------//
   
  @Test(priority=12 , dependsOnMethods = "checkvalidation")
   public void admin()throws InterruptedException  
   {
	   driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[4]/div/div/div[2]/div[3]/div/div[1]/a")).click();
	   driver.findElement(By.xpath("//*[@id=\"admin-step\"]/a")).click();
	   driver.findElement(By.xpath("//*[@id=\"admin-step\"]/ul/li[1]/a")).click();
   }
  
 //-----------------------------------------------Enter into department----------------------------------------------//
   
 @Test(priority=13 , dependsOnMethods = "checkvalidation")
   
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
 
 @Test(priority=14 , dependsOnMethods = "department")
 
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
    
 @Test(priority=15 , dependsOnMethods = "department")
 
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

 @Test(priority=16 , dependsOnMethods = "department")
 
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

 
@Test(priority=17 , dependsOnMethods = "department")

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


@Test(priority =18 , dependsOnMethods = "department")

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
		 Thread.sleep(2000);
		 	   
}


//-----------------------------------enter department with parent dept-------------------------------------------------------// 

@Test (priority=19 , dependsOnMethods = "department")

public void parent_dept()throws InterruptedException

{
  driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/div[2]/a/button")).click();
  Thread.sleep(1000);
  
  driver.findElement(By.name("dept_name")).clear();
  driver.findElement(By.name("dept_name")).sendKeys("a1");
  Thread.sleep(2000);
	 
  driver.findElement(By.name("code")).clear();
  driver.findElement(By.name("code")).sendKeys("3");
  Thread.sleep(3000);
  
  // select parent department 
  
  Select parent_dept = new Select(driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/form/div[1]/div[3]/div/select")));
  parent_dept.selectByVisibleText("A");
 
	 
  driver.findElement(By.id("textArea")).sendKeys("This is a1 department");
  driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/form/div[3]/button/span")).click();
  Thread.sleep(2000);
  
}
//------------------------------- Enter B department with parent and delete----------------------------------------//


@Test(priority=20 , dependsOnMethods = "department")

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
	 Thread.sleep(3000);
	 
	 
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
	  Thread.sleep(3000);
	 
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

//--------------------------------------------------Enter C,D,E  department----------------------------------------------------------//

@Test(priority=21 , dependsOnMethods = "department")

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
	 
     driver.findElement(By.id("textArea")).sendKeys("This is c department");
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
		 Thread.sleep(4000);
		
}

//-------------------------------------Csv download---------------------------------------------------------------------//

@Test (priority=22 , dependsOnMethods = "checkvalidation")
public void dept_download() throws InterruptedException
 {
  driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/div[2]/div[1]/button[2]")).click();
  Thread.sleep(3000);
  
  driver.findElement(By.xpath("//*[@id=\"admin-step\"]/a")).click();
  driver.findElement(By.xpath("//*[@id=\"admin-step\"]/ul/li[1]/a")).click();
  Thread.sleep(3000);
  }

}