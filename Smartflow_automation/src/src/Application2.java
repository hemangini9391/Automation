package src;

//import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Application2 extends Browser_launch_login {

	// -----------------------------------admin----------------------------------------//
	@Test(priority = 3)

	public void admin() throws InterruptedException {

		// driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[4]/div/div/div[2]/div[3]/div/div[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"admin-step\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"admin-step\"]/ul/li[1]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/div/div[5]/div/div[1]/span"))
				.click();
	}

	// --------------------------------drag and
	// drop-------------------------------------//

	@Test(priority = 4)

	public void form_start() throws InterruptedException {
         
		// click on new application
		driver.findElement(By.xpath("//*[contains(@href ,'#/app/new/application\')]")).click();
		
		//click on next to check application name validation
		driver.findElement(By.xpath("//*[@id=\"createApp\"]/div/div/div[5]/button")).click();
	
		
		//validation of application name
		String appname = driver.findElement(By.xpath("//span[text()='Please enter name']")).getText();
		String appname_real = "Please enter name";
		Assert.assertEquals(appname, appname_real);
		
		
		//add real value
		driver.findElement(By.id("appName")).sendKeys("Test1");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"createApp\"]/div/div/div[5]/button")).click();
		Thread.sleep(1000);
		
		// ------------form create -------------------//
	}

	@Test(priority = 5)
	public void create_form() throws InterruptedException {
		
		 driver.findElement(By.xpath("//label[contains(text(),'ƒZƒNƒVƒ‡ƒ“1']")).click();
		 driver.findElement(By.xpath("//input[@type='text']")).clear();
		 
		 driver.findElement(By.xpath("//*[@ng-click='updateSectionName(section.id, section.nameWithoutPreivew)']")).click();
		 String section_msg = driver.findElement(By.xpath("//div[text()='Please enter valid Section Name.']")).getText();
		 String section_msg_real = "Please enter valid Section Name.";
		 Assert.assertEquals(section_msg, section_msg_real);
		 //driver.findElement(By.xpath("//input[@type='text']")).sendKeys("sect"));
		
		Actions action = new Actions(driver);
		int i;
		for (i = 1; i<=16; i++) {
			
//			if(i==10)
//			{
//				driver.findElement(By.xpath("\\*[text()='Add New Section']")).click();
//			}
//			
            
			WebElement sourceLocator1 = driver.findElement(By.xpath(
					"//*[@id=\"wrapper\"]/div[5]/div[2]/div/div[2]/section/div/div[2]/aside/div/ui-view/ui-view/ui-view/div/div/div/div[1]/div/div/div/div/div["
							+ i + "]/div[1]/button"));
			
			// To get target locator
			WebElement targetLocator1 = driver.findElement(By.xpath(
					"//*[@id=\"wrapper\"]/div[5]/div[2]/div/div[2]/section/div/div[2]/aside/div/ui-view/ui-view/ui-view/div/div/div/div[2]/section/div/div[2]/div[2]"));
			// dragAndDrop(source, target) method accepts two parameters source and locator.
			// used dragAndDrop method to drag and drop the source locator to target locator
			
			
			
			action.dragAndDrop(sourceLocator1, targetLocator1).build().perform();
			Thread.sleep(2000);
		}
	}

//	@Test(priority = 6)
//	public void create_flow() throws InterruptedException {
//		// click on create flow
//
//		driver.findElement(
//				By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/div[2]/section/div/div[1]/ul/li[3]/a/span/i")).click();
//		Thread.sleep(4000);
//
//		// ----------------------first step------------------//
//		// click on link to assign user
//		driver.findElement(By.xpath("//*[@id=\"tr-0\"]/start-task/div/div[2]/div[2]/div/a[1]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[5]/button[2]")).click();
//		Thread.sleep(2000);
//
//		// ----------------------- next step assign through array----------------//
//
//		String[] stepname = { "fouth_step", "third_step", "second_step", "fist_step" };
//		String[] approvername = { "milind", "milind", "chandni", "chandni" };
//
//		for (int i = 0; i < stepname.length; i++) {
//			driver.findElement(By.xpath("//*[@id=\"tr-2\"]/task-selector/div/span/span[2]")).click();
//			Thread.sleep(2000);
//
//			driver.findElement(By.xpath("//*[@id=\"tr-4\"]/approval-task/div/div/div[1]/div[2]/span[2]/button"))
//					.click();
//			driver.findElement(By.id("appName")).clear();
//			driver.findElement(By.id("appName")).sendKeys(stepname[i]);
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("//*[@id=\"tr-4\"]/approval-task/div/div/div[1]/div[2]/span[2]/button[1]"))
//					.click();
//			Thread.sleep(1000);
//
//			// approver details
//			driver.findElement(By.xpath("//*[@id=\"tr-4\"]/approval-task/div/div/div[2]/div/div[2]/a[1]")).click();
//			Thread.sleep(4000);
//			driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[4]/div[1]/input"))
//					.sendKeys(approvername[i]);
//			Thread.sleep(2000);
//			driver.findElement(By.className("active")).click();
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[6]/button[2]")).click();
//			Thread.sleep(3000);
//		}
//	}
//
//	@Test(priority = 7)
//	public void permission() throws InterruptedException {
//
//		driver.findElement(
//				By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/div[2]/section/div/div[1]/ul/li[4]/a/span/i")).click();
//		Thread.sleep(2000);
//	}
//
//	@Test(priority = 8)
//	public void publish() throws InterruptedException {
//
//		driver.findElement(
//				By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/div[2]/section/div/div[1]/ul/li[5]/a/span/i")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"publish\"]/div/div/div/form/div[4]/button[1]")).click();
//		Thread.sleep(2000);
//	}
}
