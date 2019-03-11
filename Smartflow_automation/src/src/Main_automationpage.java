package src;

//import java.awt.event.KeyEvent;
//import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

//import com.sun.tools.javac.util.List;

import org.openqa.selenium.support.ui.Select;
import java.awt.AWTException;
import java.awt.Robot;

public class Main_automationpage {

	WebDriver driver;
	Robot robot;
    int total;

	// -----------------------browser_launch-----------------------------//

	@Test(priority = 1)

	public void browserlaunch() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rising1\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://ec2-34-216-206-233.us-west-2.compute.amazonaws.com/m_user_login/sign_in#/app/dashboard/home");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.linkText("English")).click();
		driver.findElement(By.linkText("新規登録")).click();
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"twblock\"]/a/label")).click();
	}

	// --------------------------------------click on submit with blank value
	// ----------------------------------------//

	@Test(priority = 2)

	public void checkvalidation() throws InterruptedException {
		WebElement login = driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div[5]/div[1]/div/button"));
		login.submit();

		// company_name
		String expected = driver.findElement(By.id("m_user_login_last_name-error")).getText();
		String validation_massage = "Field can not be blank.";
		Assert.assertEquals(expected, validation_massage);

		// last_name
		String expected1 = driver.findElement(By.id("m_user_login_last_name-error")).getText();
		Assert.assertEquals(expected1, validation_massage);

		// firstname
		String expected2 = driver.findElement(By.id("m_user_login_first_name-error")).getText();
		Assert.assertEquals(expected2, validation_massage);

		// email
		String expected3 = driver.findElement(By.id("m_user_login_email-error")).getText();
		Assert.assertEquals(expected3, validation_massage);

		// phonenumber
		// String expected4 =
		// driver.findElement(By.id("phone_validation_msg")).getText();
		// Assert.assertEquals(expected4,validation_massage);

		// password
		String expected5 = driver.findElement(By.id("m_user_login_password-error")).getText();
		Assert.assertEquals(expected5, validation_massage);

		// confirm_password
		String expected6 = driver.findElement(By.id("m_user_login_password_confirmation-error")).getText();
		Assert.assertEquals(expected6, validation_massage);

		// checkbox
		String expected7 = driver.findElement(By.id("m_user_login[is_agree]-error")).getText();
		Assert.assertEquals(expected7, validation_massage);

		
		// Sign up click
		
		if (!driver.findElement(By.name("m_user_login[is_agree]")).isSelected()) {
			driver.findElement(By.name("m_user_login[is_agree]")).click();
		}
		driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div[5]/div[1]/div/button")).submit();
	}
	// ----------------------------------------Enter
	// companyname-------------------------------------------------------//

	@Test(priority = 3)

	public void companyname() throws InterruptedException {

		WebElement c_name = driver.findElement(By.id("m_user_login_company_name"));
		c_name.sendKeys("Appsense Rising");
		Thread.sleep(500);
	}

	// --------------------------------last
	// name---------------------------------------------------------//
	@Test(priority = 4, dependsOnMethods = "checkvalidation")
	public void lastnamereal() throws InterruptedException {
		WebElement l_namereal = driver.findElement(By.id("m_user_login_last_name"));
		l_namereal.clear();
		l_namereal.sendKeys("patel");
		Thread.sleep(500);
	}
	// ------------------------------------------first name
	// -----------------------------------------------//

	@Test(priority = 5, dependsOnMethods = "checkvalidation")
	public void firstnamereal() throws InterruptedException { // enter firstname real
		WebElement l_namereal = driver.findElement(By.id("m_user_login_first_name"));
		l_namereal.clear();
		l_namereal.sendKeys("Chandni");
		// Thread.sleep(500);
	}
	// ----------------------------------------- phone
	// number------------------------------------------------------//

	// enter real phone number
	@Test(priority = 6, dependsOnMethods = "checkvalidation")
	public void ph_number_real() throws InterruptedException {
		WebElement ph_number_real = driver.findElement(By.id("m_user_login_phone"));
		ph_number_real.clear();
		ph_number_real.sendKeys("7567630234");
		Thread.sleep(500);
	}
	// ----------------------------------------random email
	// generate---------------------------------------------------------//

	@Test(priority = 7, dependsOnMethods = "checkvalidation")
	public void email_real() throws InterruptedException {

		// enter require email
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement email_real = driver.findElement(By.id("m_user_login_email"));
		email_real.clear();

		// method for send email randomly
		Random r = new Random();
		String email = "Userr" + r.nextInt(1000) + "@yopmail.com";
		// System.out.println(email);
		email_real.sendKeys(email);
		Thread.sleep(500);
	}
	// --------------------------------------------real
	// password------------------------------------------------------//

	@Test(priority = 8, dependsOnMethods = "checkvalidation")

	// real password
	public void password_real() throws InterruptedException {
		WebElement password_alpha = driver.findElement(By.id("m_user_login_password"));
		password_alpha.clear();
		password_alpha.sendKeys("password38");
		Thread.sleep(500);
	}
	// ------------------------ real confirm
	// password--------------------------------------------------------------//

	@Test(priority = 9, dependsOnMethods = "checkvalidation")

	public void confirm_password_real() throws InterruptedException {
		WebElement confirm_password_8 = driver.findElement(By.id("m_user_login_password_confirmation"));
		confirm_password_8.clear();
		confirm_password_8.sendKeys("password38");
		Thread.sleep(500);
	}
	// ------------------------------------------ check box
	// select----------------------------------------------------//

	@Test(priority = 10, dependsOnMethods = "checkvalidation")

	public void checkbox() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement checkbox = driver.findElement(By.name("m_user_login[is_agree]"));
		checkbox.click();

		 if ( !driver.findElement(By.name("m_user_login[is_agree]")).isSelected() )
		 {
		 driver.findElement(By.name("m_user_login[is_agree]")).click();
		 }
		 driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div[5]/div[1]/div/button")).submit();

	}
	// --------------------------yopmail
	// conformation--------------------------------------------------------//

	@Test(priority = 11, dependsOnMethods = "checkvalidation")

	public void yopmail() throws InterruptedException {
		// login email-id get
		String test = driver.findElement(By.xpath("//*[@id=\"home\"]/div/div/div/div/p/strong")).getText();
		System.out.println(test);

		// get yopmail
		driver.get("http://www.yopmail.com/en/");
		Thread.sleep(2000);

		// enter email-id in yopmail
		driver.findElement(By.id("login")).sendKeys(test);
		WebElement Check_Inbox = driver.findElement(By.xpath(
				"/html/body/center/div/div/div[3]/table[3]/tbody/tr/td[1]/table/tbody/tr[3]/td/div[1]/form/table/tbody/tr[1]/td[3]/input"));
		Check_Inbox.click();

		// change i-frame for click on link
		driver.switchTo().frame("ifmail");
		driver.findElement(By.linkText("アカウントの確認")).click();
		Thread.sleep(500);

		// smartflow login with real value
		driver.close();

		// Again open chrome
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rising1\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://ec2-54-71-174-152.us-west-2.compute.amazonaws.com/dash_board/index#/app/dashboard/home");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.linkText("English")).click();
		driver.manage().window().maximize();

		// login
		driver.findElement(By.id("m_user_login_email")).sendKeys(test);
		// Thread.sleep(2000);
		driver.findElement(By.id("m_user_login_password")).sendKeys("password38");
		// Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"new_m_user_login\"]/div/div[2]/div[4]/button[2]")).click();

	}
	// -------------------------------------------Admin----------------------------------------------------------//

	@Test(priority = 12, dependsOnMethods = "checkvalidation")
	public void admin() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[4]/div/div/div[2]/div[3]/div/div[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"admin-step\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"admin-step\"]/ul/li[1]/a")).click();
	}

	// -----------------------------------------------Enter into
	// department----------------------------------------------//

	@Test(priority = 13, dependsOnMethods = "checkvalidation")

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

	@Test(priority = 14, dependsOnMethods = "department")

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

	@Test(priority = 15, dependsOnMethods = "department")

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

	@Test(priority = 16, dependsOnMethods = "department")

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

	@Test(priority = 17, dependsOnMethods = "checkvalidation")
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
	@Test(priority = 18, dependsOnMethods = "checkvalidation")

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

	@Test(priority = 19, dependsOnMethods = "checkvalidation")

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
	@Test(priority = 20, dependsOnMethods = "checkvalidation")

	public void user_enter() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"admin-step\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"admin-step\"]/ul/li[1]/a")).click();
		Thread.sleep(2000);
	}

	@Test(priority = 21, dependsOnMethods = "checkvalidation")

	public void User_registarion() throws InterruptedException {
		// click on user registration
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/div/div[4]/div/div[1]/span/a"))
				.click();
		Thread.sleep(2000);

		// click on add user
		driver.findElement(
				By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/button"))
				.click();
		Thread.sleep(2000);
	}

	// ----------------------------click on submit and check
	// validation-------------------------------------------------------//

	@Test(priority = 22, dependsOnMethods = "checkvalidation")

	public void User_submit() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[15]/button[1]")).submit();
		Thread.sleep(500);

		// last name validation
		String lastname_val_msg = driver.findElement(By.xpath("//*[@id=\"last_name-error\"]")).getText();
		String lastname_val_msg_real = "This field is required.";
		Assert.assertEquals(lastname_val_msg, lastname_val_msg_real);

		// first name validation
		String firstname_val_msg = driver.findElement(By.xpath("//*[@id=\"inputDefault-error\"]")).getText();
		String firstname_val_msg_real = "This field is required.";
		Assert.assertEquals(firstname_val_msg, firstname_val_msg_real);

		// employee validation
		String employee_val_msg = driver.findElement(By.xpath("//*[@id=\"m_user_login_employeeid-error\"]")).getText();
		String employee_val_msg_real = "This field is required.";
		Assert.assertEquals(employee_val_msg, employee_val_msg_real);

		// email validation
		String email_val_msg = driver.findElement(By.xpath("//*[@id=\"m_user_login_email-error\"]")).getText();
		String email_val_msg_real = "This field is required.";
		Assert.assertEquals(email_val_msg, email_val_msg_real);
		Thread.sleep(1000);
	}

	@Test(priority = 23, dependsOnMethods = "checkvalidation")

	public void checkbox_validation() throws InterruptedException {
		// workflow and travel expense check box validation

		driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[9]/div[1]/div/label/span[1]/span")).click();
		Thread.sleep(2000);
		String checkbox_val = driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[9]/span")).getText();
		String checkbox_val_real = "Select Any of checkbox";
		Assert.assertEquals(checkbox_val, checkbox_val_real);
		Thread.sleep(1000);
	}

	// User milind patel

	@Test(priority = 24, dependsOnMethods = "checkvalidation")
	public void Enter_user2_milind() throws InterruptedException {

		// Enter last name
		driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[1]/div/input")).sendKeys("Patel");
		Thread.sleep(1000);

		// Enter first name
		driver.findElement(By.xpath("//*[@id=\"inputDefault\"]")).sendKeys("Milind");
		Thread.sleep(1000);

		// Enter Employee id
		driver.findElement(By.xpath("//*[@id=\"m_user_login_employeeid\"]")).sendKeys("m1");

		// Enter invalid email and verified message
		driver.findElement(By.xpath("//*[@id=\"m_user_login_email\"]")).sendKeys("chandni38@yopmail.com");
		Thread.sleep(2000);

		String emaill_val_msg = driver.findElement(By.xpath("//*[@id=\"m_user_login_email-error\"]")).getText();
		String emaill_val_msg_real = "Email already registerd.";
		Assert.assertEquals(emaill_val_msg, emaill_val_msg_real);

		// Enter valid email (This is random email method)
		driver.findElement(By.xpath("//*[@id=\"m_user_login_email\"]")).clear();
		// method for send email randomly
		Random r = new Random();
		String email1 = "Milinnd" + r.nextInt(5000) + "@yopmail.com";
		// System.out.println(email);
		driver.findElement(By.xpath("//*[@id=\"m_user_login_email\"]")).sendKeys(email1);
		Thread.sleep(2000);

		// select category superadmin/admin/normal user
		Select dropdown = new Select(driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[7]/div/select")));
		dropdown.selectByVisibleText("Super Admin");
		Thread.sleep(2000);

		// select checkbox
		driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[9]/div[1]/div/label/span[1]/span")).click();
		driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[9]/div[2]/div/label/span[1]/span")).click();

		// select department
		Select department = new Select(driver
				.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[12]/div[2]/div[1]/div[2]/div[1]/div/select")));
		department.selectByVisibleText("A");
		Thread.sleep(5000);

		// select position
		Select position = new Select(driver
				.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[12]/div[2]/div[1]/div[2]/div[2]/div/select")));
		position.selectByVisibleText("b");
		Thread.sleep(2000);

		// click on submit
		driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[15]/button[1]")).submit();
		String user_alert = driver.findElement(By.className("alertOut")).getText();
		String user_alert_real = "×\n" + "User created successfully";
		Assert.assertEquals(user_alert, user_alert_real);
		Thread.sleep(2000);
	}

	// User karan patel

	@Test(priority = 25, dependsOnMethods = "checkvalidation")

	public void Enter_user2_Karan() throws InterruptedException {
		// click on add user
		driver.findElement(
				By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/button"))
				.click();
		Thread.sleep(2000);

		// Enter last name
		driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[1]/div/input")).sendKeys("Patel");
		Thread.sleep(1000);

		// Enter first name
		driver.findElement(By.xpath("//*[@id=\"inputDefault\"]")).sendKeys("Karan");
		Thread.sleep(1000);

		// Enter Employee id
		driver.findElement(By.xpath("//*[@id=\"m_user_login_employeeid\"]")).sendKeys("K1");
		Thread.sleep(1000);

		// Enter valid email (This is random email method)
		// method for send email randomly
		Random r = new Random();
		String email2 = "Karran" + r.nextInt(7000) + "@yopmail.com";
		// System.out.println(email);
		driver.findElement(By.xpath("//*[@id=\"m_user_login_email\"]")).sendKeys(email2);
		Thread.sleep(2000);

		// select category superadmin/admin/normal user
		Select dropdown = new Select(driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[7]/div/select")));
		dropdown.selectByVisibleText("Super Admin");
		Thread.sleep(2000);

		// select checkbox
		// driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[9]/div[1]/div/label/span[1]/span")).click();
		driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[9]/div[2]/div/label/span[1]/span")).click();

		// select department
		Select department = new Select(driver
				.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[12]/div[2]/div[1]/div[2]/div[1]/div/select")));
		department.selectByVisibleText("C");
		Thread.sleep(1000);

		// select position
		Select position = new Select(driver
				.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[12]/div[2]/div[1]/div[2]/div[2]/div/select")));
		position.selectByVisibleText("c");
		Thread.sleep(1000);

		// click on submit
		driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[15]/button[1]")).submit();

		// User created successfully message verified
		String user_alert = driver.findElement(By.className("alertOut")).getText();
		String user_alert_real = "×\n" + "User created successfully";
		Assert.assertEquals(user_alert, user_alert_real);
		Thread.sleep(3000);
}

	// User bhavik patel

	@Test(priority = 26, dependsOnMethods = "checkvalidation")
	public void Enter_user2_bhavik() throws InterruptedException {

		// click on add user
		driver.findElement(
				By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/button"))
				.click();
		Thread.sleep(4000);

		// Enter last name
		driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[1]/div/input")).sendKeys("Patel");
		Thread.sleep(1000);

		// Enter first name
		driver.findElement(By.xpath("//*[@id=\"inputDefault\"]")).sendKeys("Bhavik");
		Thread.sleep(1000);

		// Enter Employee id
		driver.findElement(By.xpath("//*[@id=\"m_user_login_employeeid\"]")).sendKeys("B1");
		Thread.sleep(1000);

		// Enter valid email (This is random email method)
		// method for send email randomly
		Random r = new Random();
		String email2 = "Bhaviik" + r.nextInt(8000) + "@yopmail.com";
		// System.out.println(email);
		driver.findElement(By.xpath("//*[@id=\"m_user_login_email\"]")).sendKeys(email2);
		Thread.sleep(2000);

		// select category superadmin/admin/normal user
		Select dropdown = new Select(driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[7]/div/select")));
		dropdown.selectByVisibleText("Super Admin");
		Thread.sleep(2000);

		// select checkbox
		// driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[9]/div[1]/div/label/span[1]/span")).click();
		// driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[9]/div[2]/div/label/span[1]/span")).click();

		// select department
		Select department = new Select(driver
				.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[12]/div[2]/div[1]/div[2]/div[1]/div/select")));
		department.selectByVisibleText("D");
		Thread.sleep(1000);

		// select position
		Select position = new Select(driver
				.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[12]/div[2]/div[1]/div[2]/div[2]/div/select")));
		position.selectByVisibleText("d");
		Thread.sleep(1000);

		// click on submit
		driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[15]/button[1]")).submit();

		// User created successfully msg verified
		String user_alert = driver.findElement(By.className("alertOut")).getText();
		String user_alert_real = "×\n" + "User created successfully";
		Assert.assertEquals(user_alert, user_alert_real);
		Thread.sleep(3000);
		}
	// user test for check payment message

	@Test(priority = 27, dependsOnMethods = "checkvalidation")
	public void Enter_user2_test() throws InterruptedException {
		// click on add user
		driver.findElement(
				By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/button"))
				.click();
		Thread.sleep(2000);

		// Enter last name
		driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[1]/div/input")).sendKeys("Patel");
		Thread.sleep(1000);

		// Enter first name
		driver.findElement(By.xpath("//*[@id=\"inputDefault\"]")).sendKeys("test");
		Thread.sleep(1000);	

		// Enter Employee id

		driver.findElement(By.xpath("//*[@id=\"m_user_login_employeeid\"]")).sendKeys("tK1");
		Thread.sleep(1000);

		// Enter valid email (This is random email method)
		// method for send email randomly

		Random r = new Random();
		String email12 = "testrt" + r.nextInt(7000) + "@yopmail.com";
		// System.out.println(email);
		driver.findElement(By.xpath("//*[@id=\"m_user_login_email\"]")).sendKeys(email12);
		Thread.sleep(2000);

		// select category superadmin/admin/normal user
		Select dropdown = new Select(driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[7]/div/select")));
		dropdown.selectByVisibleText("Super Admin");
		Thread.sleep(1000);

		// select checkbox
		// driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[9]/div[1]/div/label/span[1]/span")).click();
		driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[9]/div[2]/div/label/span[1]/span")).click();
		Thread.sleep(500);

		// click on submit
		driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[15]/button[1]")).submit();
		Thread.sleep(500);

		String payment_alert = driver.findElement(By.className("alert-warning")).getText();
		String payment_alert_real = "×\n" + "You need to upgrade your package. Click here to upgrade your package.";
		Assert.assertEquals(payment_alert, payment_alert_real);

		// click on cancel button
		driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[15]/button[2]")).click();

	}

	// Edit user chandni to add proxy user

	@Test(priority = 28, dependsOnMethods = "checkvalidation")

	public void user_chandni_edit() throws InterruptedException, AWTException {
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div[1]/div/div[2]/div/div[3]/div[2]/table/tbody/tr[1]/td[8]/a"))
				.click();
		Thread.sleep(5000);

		// Enter Employee id
		driver.findElement(By.xpath("//*[@id=\"m_user_login_employeeid\"]")).sendKeys("A1");
		Thread.sleep(2000);

		// select department
		Select department = new Select(driver
				.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[12]/div[2]/div[1]/div[2]/div[1]/div/select")));
		department.selectByVisibleText("A");
		Thread.sleep(2000);

		// select position
		Select position = new Select(driver
				.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[12]/div[2]/div[1]/div[2]/div[2]/div/select")));
		position.selectByVisibleText("a");
		Thread.sleep(2000);

		// select proxy approver
		driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[13]/div/div[2]/div/div/a")).click();
		Thread.sleep(3000);

		// select proxy through active class
		driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[13]/div/div[2]/div[1]/div[2]/div[1]/div/input"))
				.sendKeys("milind");
		Thread.sleep(1000);
		driver.findElement(By.className("active")).click();
		
		
		//date validation 
		 WebElement dateBox = driver.findElement(By.id("startdate"));
	     dateBox.click();
	     Thread.sleep(2000);
	     
	     driver.findElement(By.xpath("/html/body/div[7]/div[1]/table/tbody/tr[3]/td[1]")).click();
	     
//	     //get all td 
//	     List<WebElement> allDates=driver.findElements(By.xpath("/html/body/div[7]/div[1]/table/tbody/tr/td"));
//	     total = allDates.size();
//	     
//	        	 
//	     for(WebElement ele:allDates)
//	 	 {		
//	 	  String date=ele.getText();
//	    	if(date.equalsIgnoreCase("28"))
//	 			{
//	 				ele.click();
//	 				break;
//	 			}
//		}

		// click on submit
	    driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[15]/button[1]")).submit();
	} 
	}