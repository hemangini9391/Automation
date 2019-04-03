package src;

//import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;

public class Main_automationpage extends Browser_launch_signup {

	// WebDriver driver;
	// Robot robot;
	int total;

	// -------------------------------------------Admin----------------------------------------------------------//

	@Test(priority = 11)
	public void admin() throws InterruptedException {

		driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[4]/div/div/div[2]/div[3]/div/div[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"admin-step\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"admin-step\"]/ul/li[1]/a")).click();
	}

	// -----------------------------------------------Enter into
	// department----------------------------------------------//

	@Test(priority = 12)

	public void department() throws InterruptedException {
		// click on department
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/div/div[2]/div/div[1]/span/a"))
				.click();
		Thread.sleep(2000);
		// add department
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/div[2]/a/button/i[1]"))
				.click();
		Thread.sleep(2000);
	}
	// ---------------------department(department with real
	// value)-----------------------------------------------------//

	@Test(priority = 13, dependsOnMethods = "department")

	public void dept_real() throws InterruptedException {
		// real value
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.findElement(By.name("dept_name")).clear();
		driver.findElement(By.name("dept_name")).sendKeys("A");
		Thread.sleep(500);

		driver.findElement(By.name("code")).clear();
		driver.findElement(By.name("code")).sendKeys("2");
		Thread.sleep(500);

		driver.findElement(By.id("textArea")).sendKeys("This is A department");
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/form/div[3]/button"))
				.click();
		Thread.sleep(500);
	}

	// -----------------------------------enter department with parent department
	// --------------------------------------//

	@Test(priority = 14, dependsOnMethods = "department")

	public void parent_dept() throws InterruptedException {
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/div[2]/a/button"))
				.click();
		Thread.sleep(500);

		driver.findElement(By.name("dept_name")).clear();
		driver.findElement(By.name("dept_name")).sendKeys("a1");
		Thread.sleep(500);

		driver.findElement(By.name("code")).clear();
		driver.findElement(By.name("code")).sendKeys("3");
		Thread.sleep(500);

		// select parent department
		Select parent_dept = new Select(driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/form/div[1]/div[3]/div/select")));
		parent_dept.selectByVisibleText("A");

		driver.findElement(By.id("textArea")).sendKeys("This is a1 department");
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/form/div[3]/button/span"))
				.click();
		Thread.sleep(500);

	}

	// --------------------------------------------------Enter C,D,E
	// department----------------------------------------------------------//

	@Test(priority = 15, dependsOnMethods = "department")

	public void dept_c_dept() throws InterruptedException {
		// --------------------C department------------------//
		Thread.sleep(500);
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/div[2]/a/button"))
				.click();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.name("dept_name")).clear();
		driver.findElement(By.name("dept_name")).sendKeys("C");
		Thread.sleep(500);

		driver.findElement(By.name("code")).clear();
		driver.findElement(By.name("code")).sendKeys("04");
		Thread.sleep(500);

		driver.findElement(By.id("textArea")).sendKeys("This is c department");
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/form/div[3]/button"))
				.click();
		Thread.sleep(500);

		// --------- D dept----------------//

		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/div[2]/a/button"))
				.click();
		Thread.sleep(500);

		driver.findElement(By.name("dept_name")).clear();
		driver.findElement(By.name("dept_name")).sendKeys("D");
		Thread.sleep(500);

		driver.findElement(By.name("code")).clear();
		driver.findElement(By.name("code")).sendKeys("5");
		Thread.sleep(500);

		driver.findElement(By.id("textArea")).sendKeys("This is D department");
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/form/div[3]/button"))
				.click();
		Thread.sleep(500);

		// ------- E dept--------------//
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/div[2]/a/button"))
				.click();
		Thread.sleep(500);

		driver.findElement(By.name("dept_name")).clear();
		driver.findElement(By.name("dept_name")).sendKeys("E");
		Thread.sleep(500);

		driver.findElement(By.name("code")).clear();
		driver.findElement(By.name("code")).sendKeys("6");
		Thread.sleep(500);

		driver.findElement(By.id("textArea")).sendKeys("This is E department");
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/form/div[3]/button"))
				.click();
		Thread.sleep(500);

		// ------------- b dept---------------//
		Thread.sleep(500);
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/div[2]/a/button"))
				.click();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.name("dept_name")).clear();
		driver.findElement(By.name("dept_name")).sendKeys("B");
		Thread.sleep(500);

		driver.findElement(By.name("code")).clear();
		driver.findElement(By.name("code")).sendKeys("08");
		Thread.sleep(500);

		driver.findElement(By.id("textArea")).sendKeys("This is B department");
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/form/div[3]/button"))
				.click();
		Thread.sleep(500);

	}
	// ---------------------------------department Csv
	// download---------------------------------------------------------------------//

	@Test(priority = 16, dependsOnMethods = "department")
	public void dept_download() throws InterruptedException {
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/div[2]/div[1]/button[2]"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"admin-step\"]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"admin-step\"]/ul/li[1]/a")).click();
		Thread.sleep(2000);
	}

	// ------------------------------------position start
	// ---------------------------------------------------------//
	@Test(priority = 17)

	public void position() throws InterruptedException {
		// click on position
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/div/div[3]/div/div[1]/span/a"))
				.click();
		Thread.sleep(2000);

		// enter value in search box
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div[1]/div/input"))
				.sendKeys("testing");
		Thread.sleep(500);

		// output search result
		String search_msg = driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div[2]/div/table/tbody/tr/td"))
				.getText();
		String search_message = "No Position list Found";
		Assert.assertEquals(search_msg, search_message);

		// remove search result
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div[1]/div/input"))
				.clear();
		Thread.sleep(500);
	}
	// ----------------------------------------------Add real
	// position-------------------------------------------//

	@Test(priority = 18, dependsOnMethods = "position")

	public void real_position() throws InterruptedException {
		// --------a position-----------//
		// click on add symbol
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div[2]/div/button"))
				.click();
		Thread.sleep(500);

		// code value
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[2]/div/input")).sendKeys("1");
		// name value
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[1]/div/input")).sendKeys("a");

		// click on submit
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[4]/button")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div[1]/a"))
				.click();

		// -----------b position-----------//
		// click on add symbol
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div[2]/div/button"))
				.click();
		Thread.sleep(500);

		// code value
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[2]/div/input")).sendKeys("2");
		// name value
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[1]/div/input")).sendKeys("b");

		// click on submit
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[4]/button")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div[1]/a"))
				.click();

		// ---------c position-------------//

		// click on add symbol
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div[2]/div/button"))
				.click();
		Thread.sleep(500);

		// code value
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[2]/div/input")).sendKeys("3");
		// name value
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[1]/div/input")).sendKeys("c");

		// click on submit
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[4]/button")).click();
		Thread.sleep(500);

		// --------d position------------------//

		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div[1]/a"))
				.click();
		// click on add symbol
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div[2]/div/button"))
				.click();
		Thread.sleep(500);

		// code value
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[2]/div/input")).sendKeys("4");
		// name value
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[1]/div/input")).sendKeys("d");

		// click on submit
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[4]/button")).click();
		Thread.sleep(500);

		// -----------e position------------------//

		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div[1]/a"))
				.click();
		// click on add symbol
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div[2]/div/button"))
				.click();
		Thread.sleep(500);

		// code value
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[2]/div/input")).sendKeys("5");
		// name value
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[1]/div/input")).sendKeys("e");

		// click on submit
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[4]/button")).click();
		Thread.sleep(4000);
	}

	// -------------------------------------------User registration
	// start---------------------------------------------------//
	@Test(priority = 19, dependsOnMethods = "position")

	public void user_enter() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"admin-step\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"admin-step\"]/ul/li[1]/a")).click();
		Thread.sleep(2000);
	}

	@Test(priority = 20, dependsOnMethods = "position")

	public void User_registarion() throws InterruptedException {
			// click on user registration
			driver.findElement(By.xpath(
					"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/div/div[4]/div/div[1]/span/a"))
					.click();
			Thread.sleep(2000);
		}

	// ----------------------------click on submit and check
	// validation-------------------------------------------------------//

	@Test(priority = 21)
	public void user() throws InterruptedException {
		// String[] lastname = {"patel"};
		String[] Firstname = { "Milind", "Bhavik", "karan" };
		String[] Employeeid = { "m1", "b1", "k1" };
		String[] User = { "milinnd", "bhavik", "karran" };
		
		
		//array lenth
		int ilength =Firstname.length;
		String test = Firstname[ilength-1];
		System.out.println(test);
		

		for (int i = 0; i < Firstname.length; i++)
		{
			
			// click on add user
			driver.findElement(
					By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/button"))
					.click();
			Thread.sleep(3000);

			// last name
			driver.findElement(By.name("last_name")).sendKeys("patel");
			Thread.sleep(2000);

			// first name
			driver.findElement(By.name("first_name")).sendKeys(Firstname[i]);
			Thread.sleep(2000);

			// employeeid
			driver.findElement(By.id("m_user_login_employeeid")).sendKeys(Employeeid[i]);
			Thread.sleep(2000);

			// email
			Random r = new Random();
			String user_email = User[i] + r.nextInt(1000) + "@yopmail.com";
			// System.out.println(email);
			driver.findElement(By.id("m_user_login_email")).sendKeys(user_email);
			Thread.sleep(2000);

			// select category superadmin/admin/normal user
			Select dropdown = new Select(
					driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[6]/div/select")));
			dropdown.selectByVisibleText("Super Admin");
			Thread.sleep(2000);
			
			//click on checkbox
			driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[9]/div[2]/div/label/span[1]/span"))
			.click();

			// condition for last user click on checkbox (Travel expense and workflow)
			if (i == Firstname.length - 1) 
			{
				//click on submit
				driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[15]/button[1]")).submit();
				
				//verifed messsage
				String actual = driver.findElement(By.className("alert-warning")).getText();
				System.out.println(actual);
				String expected = "×\n" + 
						"You need to upgrade your package. Click here to upgrade your package.";
				Assert.assertEquals(actual, expected);
	
				// after deselect click on submit
				driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[9]/div[2]/div/label/span[1]/span"))
						.click();
		
				driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[15]/button[1]")).submit();		
			} else 
			{
				// click on submit
				driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[15]/button[1]")).submit();
				String user_alert = driver.findElement(By.className("alertOut")).getText();
				String user_alert_real = "×\n" + "User created successfully";
				Assert.assertEquals(user_alert, user_alert_real);
				Thread.sleep(6000);
				
			}	
		}
}
	}
