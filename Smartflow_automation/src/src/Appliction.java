package src;

//import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
//import org.testng.Assert;
import org.testng.annotations.Test;

public class Appliction {

	WebDriver driver;

	// -------------------------------------------browser
	// launch-------------------------------------------------------//
	@Test(priority = 1)

	public void Browserlaunch() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rising1\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://ec2-54-71-174-152.us-west-2.compute.amazonaws.com/dash_board/index#/app/dashboard/home");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.linkText("English")).click();
		driver.manage().window().maximize();
	}

	// ------------------------------------------click on sign
	// in--------------------------------------------------------//
	
	@Test(priority =2)
	public void real_value() throws InterruptedException {

		WebElement test5 = driver.findElement(By.xpath("//*[@id=\"m_user_login_email\"]"));
		test5.sendKeys("userr522@yopmail.com");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"m_user_login_password\"]")).clear();

		WebElement test7 = driver.findElement(By.xpath("//*[@id=\"m_user_login_password\"]"));
		test7.sendKeys("password38");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div/div[2]/div[4]/button[2]")).click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
//-----------------------------------admin----------------------------------------//
	@Test(priority = 3)

	public void admin() throws InterruptedException {
		
	 // driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[4]/div/div/div[2]/div[3]/div/div[1]/a")).click();
	  driver.findElement(By.xpath("//*[@id=\"admin-step\"]/a")).click();
	  driver.findElement(By.xpath("//*[@id=\"admin-step\"]/ul/li[1]/a")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/div/div[5]/div/div[1]/span")).click();
	}

	// --------------------------------drag and drop-------------------------------------//
 @Test(priority=4) 
 
	 public void actionsClass() throws InterruptedException{
	 
	  
	 
	 driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/div/div/div/div/div[2]/div[1]/div/div[3]/a[1]")).click();
	 Thread.sleep(2000);
	 
	 driver.findElement(By.id("appName")).sendKeys("firstapp");
	 driver.findElement(By.id("appDesc")).sendKeys("This is testing");
	 driver.findElement(By.xpath("//*[@id=\"createApp\"]/div/div/div[5]/button")).click();
	 Thread.sleep(3000);
	 
	 
	 //--------------Textbox-------------------//
	 
	 driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/div[2]/section/div/div[2]/aside/div/ui-view/ui-view/ui-view/div/div/div/div[2]/section/div/div[2]/div[1]/div/label")).click();
	 Thread.sleep(1000);
	 
     driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/div[2]/section/div/div[2]/aside/div/ui-view/ui-view/ui-view/div/div/div/div[2]/section/div/div[2]/div[1]/div/div/div[1]/input")).clear();
     driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/div[2]/section/div/div[2]/aside/div/ui-view/ui-view/ui-view/div/div/div/div[2]/section/div/div[2]/div[1]/div/div/div[1]/input")).sendKeys("Form");
     driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/div[2]/section/div/div[2]/aside/div/ui-view/ui-view/ui-view/div/div/div/div[2]/section/div/div[2]/div[1]/div/div/div[2]/button[1]")).click();
     Thread.sleep(3000);
     
  
	 Actions action = new Actions(driver);   
	   
	 WebElement sourceLocator = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/div[2]/section/div/div[2]/aside/div/ui-view/ui-view/ui-view/div/div/div/div[1]/div/div/div/div/div[1]/div[1]/button"));
	                //To get target locator
	 WebElement targetLocator = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/div[2]/section/div/div[2]/aside/div/ui-view/ui-view/ui-view/div/div/div/div[2]/section/div/div[2]/div[2]"));
	                //dragAndDrop(source, target) method accepts two parameters source and locator. 
	                //used dragAndDrop method to drag and drop the source locator to target locator
	 action.dragAndDrop(sourceLocator, targetLocator).build().perform();
	 Thread.sleep(2000);
	 
	 
	 //------------Textarea---------------------//
	 
	 WebElement sourceLocator1 = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/div[2]/section/div/div[2]/aside/div/ui-view/ui-view/ui-view/div/div/div/div[1]/div/div/div/div/div[2]/div[1]/button"));
     //To get target locator
	 WebElement targetLocator1 = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/div[2]/section/div/div[2]/aside/div/ui-view/ui-view/ui-view/div/div/div/div[2]/section/div/div[2]/div[2]"));
     //dragAndDrop(source, target) method accepts two parameters source and locator. 
     //used dragAndDrop method to drag and drop the source locator to target locator
     action.dragAndDrop(sourceLocator1, targetLocator1).build().perform();
     Thread.sleep(2000);
	 
     
     //------------checkbox-----------------------//
	 WebElement sourceLocator2 = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/div[2]/section/div/div[2]/aside/div/ui-view/ui-view/ui-view/div/div/div/div[1]/div/div/div/div/div[3]/div[1]/button"));
     //To get target locator
	 WebElement targetLocator2 = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/div[2]/section/div/div[2]/aside/div/ui-view/ui-view/ui-view/div/div/div/div[2]/section/div/div[2]/div[2]"));
     //dragAndDrop(source, target) method accepts two parameters source and locator. 
     //used dragAndDrop method to drag and drop the source locator to target locator
     action.dragAndDrop(sourceLocator2, targetLocator2).build().perform();
     Thread.sleep(2000);
   	 
     //-------------radio button------------------//
     WebElement sourceLocator3 = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/div[2]/section/div/div[2]/aside/div/ui-view/ui-view/ui-view/div/div/div/div[1]/div/div/div/div/div[4]/div[1]/button"));
        //To get target locator
   	 WebElement targetLocator3 = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/div[2]/section/div/div[2]/aside/div/ui-view/ui-view/ui-view/div/div/div/div[2]/section/div/div[2]/div[2]"));
        //dragAndDrop(source, target) method accepts two parameters source and locator. 
        //used dragAndDrop method to drag and drop the source locator to target locator
     action.dragAndDrop(sourceLocator3, targetLocator3).build().perform();
     Thread.sleep(2000);
     
     
     //------------------select section------------//
     driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/div[2]/section/div/div[2]/aside/div/ui-view/ui-view/ui-view/div/div/div/div[4]/button[1]")).click();
     Thread.sleep(2000);
     
     
   //-------------drop down------------------//
     WebElement sourceLocator4 = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/div[2]/section/div/div[2]/aside/div/ui-view/ui-view/ui-view/div/div/div/div[1]/div/div/div/div/div[5]/div[1]/button"));
        //To get target locator
   	 WebElement targetLocator4 = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/div[2]/section/div/div[2]/aside/div/ui-view/ui-view/ui-view/div/div/div/div[2]/section[2]/div/div[2]/div[2]"));
        //dragAndDrop(source, target) method accepts two parameters source and locator. 
        //used dragAndDrop method to drag and drop the source locator to target locator
     action.dragAndDrop(sourceLocator4, targetLocator4).build().perform();
     Thread.sleep(2000);
     
     
     //-------------date picker------------------//
     WebElement sourceLocator5 = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/div[2]/section/div/div[2]/aside/div/ui-view/ui-view/ui-view/div/div/div/div[1]/div/div/div/div/div[6]/div[1]/button"));
        //To get target locator
   	 WebElement targetLocator5 = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/div[2]/section/div/div[2]/aside/div/ui-view/ui-view/ui-view/div/div/div/div[2]/section[2]/div/div[2]/div[2]"));
        //dragAndDrop(source, target) method accepts two parameters source and locator. 
        //used dragAndDrop method to drag and drop the source locator to target locator
     action.dragAndDrop(sourceLocator5, targetLocator5).build().perform();
     Thread.sleep(2000);
     
     
     //-------------date and time picker ------------------//
     WebElement sourceLocator6 = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/div[2]/section/div/div[2]/aside/div/ui-view/ui-view/ui-view/div/div/div/div[1]/div/div/div/div/div[8]/div[1]/button"));
        //To get target locator
   	 WebElement targetLocator6 = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/div[2]/section/div/div[2]/aside/div/ui-view/ui-view/ui-view/div/div/div/div[2]/section[2]/div/div[2]/div[2]"));
        //dragAndDrop(source, target) method accepts two parameters source and locator. 
        //used dragAndDrop method to drag and drop the source locator to target locator
     action.dragAndDrop(sourceLocator6, targetLocator6).build().perform();
     Thread.sleep(2000);
     
     
     
  
     
     //-------------date and time picker ------------------//
     WebElement sourceLocator7 = driver.findElement(By.xpath(" //*[@id=\"wrapper\"]/div[5]/div[2]/div/div[2]/section/div/div[2]/aside/div/ui-view/ui-view/ui-view/div/div/div/div[1]/div/div/div/div/div[10]/div[1]/button"));
        //To get target locator
   	 WebElement targetLocator7 = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/div[2]/section/div/div[2]/aside/div/ui-view/ui-view/ui-view/div/div/div/div[2]/section[2]/div/div[2]/div[2]"));
        //dragAndDrop(source, target) method accepts two parameters source and locator. 
        //used dragAndDrop method to drag and drop the source locator to target locator
     action.dragAndDrop(sourceLocator7, targetLocator7).build().perform();
     Thread.sleep(2000);
    
	 }
 
 @Test(priority=5)
 public void create_flow() throws InterruptedException
 {
	//click on create flow
	 
     driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/div[2]/section/div/div[1]/ul/li[3]/a/span/i")).click();
     Thread.sleep(4000);
     
                 //----------------------first step------------------//
     //click on edit for heading
     
     driver.findElement(By.xpath("//*[@id=\"tr-0\"]/start-task/div/div[2]/div[1]/div[2]/span[2]/button")).click();
     Thread.sleep(1000);
     driver.findElement(By.id("appName")).clear();
     driver.findElement(By.id("appName")).sendKeys("first step");
     driver.findElement(By.xpath("//*[@id=\"tr-0\"]/start-task/div/div[2]/div[1]/div[2]/span[2]/button[1]")).click();
     Thread.sleep(1000);             
     //click on link to assign user 
     driver.findElement(By.xpath("//*[@id=\"tr-0\"]/start-task/div/div[2]/div[2]/div/a[1]")).click();
     Thread.sleep(2000);
     driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[5]/button[2]")).click();
     Thread.sleep(2000);
     
               //-----------------------second step----------------//
     
     //click on approver link
     driver.findElement(By.xpath("//*[@id=\"tr-2\"]/task-selector/div/span/span[2]")).click();
     Thread.sleep(2000);
     
     //click on edit
     driver.findElement(By.xpath("//*[@id=\"tr-4\"]/approval-task/div/div/div[1]/div[2]/span[2]/button")).click();
     driver.findElement(By.id("appName")).clear();
     driver.findElement(By.id("appName")).sendKeys("second step");
     driver.findElement(By.xpath("//*[@id=\"tr-0\"]/start-task/div/div[2]/div[1]/div[2]/span[2]/button[1]")).click();
     Thread.sleep(1000);
   
     // approver details 
     driver.findElement(By.xpath("//*[@id=\"tr-4\"]/approval-task/div/div/div[2]/div/div[2]/a[1]")).click();
     Thread.sleep(4000);
     driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[4]/div[1]/input")).sendKeys("chandni");
     Thread.sleep(2000);
     driver.findElement(By.className("active")).click(); 
     Thread.sleep(2000);
     driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[6]/button[2]")).click();
 
     
     //-----------------------third step----------------//
     
	//click on approver link
	driver.findElement(By.xpath("//*[@id=\"tr-2\"]/task-selector/div/span/span[2]")).click();
	Thread.sleep(2000);
	
	//click on edit
	driver.findElement(By.xpath("//*[@id=\"tr-4\"]/approval-task/div/div/div[1]/div[2]/span[2]/button")).click();
	driver.findElement(By.id("appName")).clear();
	driver.findElement(By.id("appName")).sendKeys("third step");
	driver.findElement(By.xpath("//*[@id=\"tr-0\"]/start-task/div/div[2]/div[1]/div[2]/span[2]/button[1]")).click();
	Thread.sleep(1000);
	
	// approver details 
	driver.findElement(By.xpath("//*[@id=\"tr-4\"]/approval-task/div/div/div[2]/div/div[2]/a[1]")).click();
	Thread.sleep(4000);
	driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[4]/div[1]/input")).sendKeys("milind");
	Thread.sleep(2000);
	driver.findElement(By.className("active")).click(); 
	Thread.sleep(2000);
    driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[6]/button[2]")).click();
 }
 }
	
