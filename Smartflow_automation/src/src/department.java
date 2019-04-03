package src;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;

public class department extends Browser_launch_signup {

	// -------------------------------------------Admin----------------------------------------------------------//

	@Test(priority = 12)
	public void admin() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[4]/div/div/div[2]/div[3]/div/div[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"admin-step\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"admin-step\"]/ul/li[1]/a")).click();
	}

	// -----------------------------------------------Enter into
	// department----------------------------------------------//

	@Test(priority = 13)

	public void department1() throws InterruptedException {
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

	// ---------------------department(click on submit and check validation of code
	// and name)---------------------------------------------------//

	@Test(priority = 14)

	public void department_submit() throws InterruptedException {
		// click on submit without adding any value

		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/form/div[3]/button"))
				.click();

		// validation of department name
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String dept1 = driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/form/div[1]/div[1]/div/span[3]/span"))
				.getText();
		String deptmsg = "Name is required";
		Assert.assertEquals(dept1, deptmsg);

		// validation of department code
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String dept2 = driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/form/div[1]/div[2]/div/span[3]/span"))
				.getText();
		String deptcodemsg = "Code is required";
		Assert.assertEquals(dept2, deptcodemsg);

	}

	// ---------------------department(enter only department
	// name)---------------------------------------------------//

	@Test(priority = 15)

	public void department_name() throws InterruptedException {
		// enter only dept name and see code validation

		driver.findElement(By.name("dept_name")).clear();
		driver.findElement(By.name("dept_name")).sendKeys("A");
		Thread.sleep(2000);

		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/form/div[3]/button"))
				.click();
		String dept21 = driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/form/div[1]/div[2]/div/span[3]/span"))
				.getText();
		String deptcodemsg1 = "Code is required";

		Assert.assertEquals(dept21, deptcodemsg1);
		driver.findElement(By.name("dept_name")).clear();
	}
	//

	// ---------------------department(enter only department code
	// )---------------------------------------------------//

	@Test(priority = 16)

	public void departmenttcode() throws InterruptedException

	// enter only dept code and see name validation

	{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.name("code")).clear();
		driver.findElement(By.name("code")).sendKeys("02");
		Thread.sleep(2000);

		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/form/div[3]/button"))
				.click();
		String dept211 = driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/form/div[1]/div[1]/div/span[3]/span"))
				.getText();
		String deptcodemsg11 = "Name is required";

		Assert.assertEquals(dept211, deptcodemsg11);
		driver.findElement(By.name("dept_name")).clear();

	}

	// ---------------------department(department with real
	// value)-----------------------------------------------------//

	@Test(priority = 17)

	public void dept_real() throws InterruptedException {
		// real value
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.name("dept_name")).clear();
		driver.findElement(By.name("dept_name")).sendKeys("A");
		Thread.sleep(2000);

		driver.findElement(By.name("code")).clear();
		driver.findElement(By.name("code")).sendKeys("2");
		Thread.sleep(2000);

		driver.findElement(By.id("textArea")).sendKeys("This is A department");
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/form/div[3]/button"))
				.click();
		Thread.sleep(2000);
	}

	// -----------------------------------------department validation while
	// edit------------------------------------------------------//

	@Test(priority = 18)

	public void dept_edit() throws InterruptedException

	{
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/div[2]/div[3]/div/div/ul/li[2]/h4/a/span"))
				.click();

		Thread.sleep(2000);
		driver.findElement(By.name("dept_name")).clear();
		driver.findElement(By.name("dept_name")).sendKeys("unassigned");

		Thread.sleep(2000);
		driver.findElement(By.name("code")).clear();
		driver.findElement(By.name("code")).sendKeys("01");
		Thread.sleep(3000);

		driver.findElement(By.id("textArea")).clear();
		driver.findElement(By.id("textArea")).sendKeys("This is A department");
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/form/div[3]/button"))
				.click();
		Thread.sleep(3000);

		// validation of department name
		String dept1 = driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/form/div[1]/div[1]/div/span[4]"))
				.getText();
		String deptmsg = "Name already exists.";
		Assert.assertEquals(dept1, deptmsg);

		// validation of department code
		String dept2 = driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/form/div[1]/div[2]/div/span[4]"))
				.getText();
		String deptcodemsg = "Department Code already exists.";
		Assert.assertEquals(dept2, deptcodemsg);

		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/form/div[3]/a"))
				.click();
		Thread.sleep(2000);

	}

	// -----------------------------------enter department with parent
	// dept-------------------------------------------------------//

	@Test(priority = 19)

	public void parent_dept() throws InterruptedException

	{
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/div[2]/a/button"))
				.click();
		Thread.sleep(1000);

		driver.findElement(By.name("dept_name")).clear();
		driver.findElement(By.name("dept_name")).sendKeys("a1");
		Thread.sleep(2000);

		driver.findElement(By.name("code")).clear();
		driver.findElement(By.name("code")).sendKeys("3");
		Thread.sleep(3000);

		// select parent department

		Select parent_dept = new Select(driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/form/div[1]/div[3]/div/select")));
		parent_dept.selectByVisibleText("A");

		driver.findElement(By.id("textArea")).sendKeys("This is a1 department");
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/form/div[3]/button/span"))
				.click();
		Thread.sleep(2000);

	}
	// ------------------------------- Enter B department with parent and
	// delete----------------------------------------//

	@Test(priority = 20)

	public void dept_B_delete() throws InterruptedException {
		// real value
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/div[2]/a/button"))
				.click();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.name("dept_name")).clear();
		driver.findElement(By.name("dept_name")).sendKeys("B");
		Thread.sleep(2000);

		driver.findElement(By.name("code")).clear();
		driver.findElement(By.name("code")).sendKeys("4");
		Thread.sleep(2000);

		driver.findElement(By.id("textArea")).sendKeys("This is B department");
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/form/div[3]/button"))
				.click();
		Thread.sleep(3000);

		// enter b1 with parent dept

		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/div[2]/a/button"))
				.click();
		Thread.sleep(1000);

		driver.findElement(By.name("dept_name")).clear();
		driver.findElement(By.name("dept_name")).sendKeys("b1");
		Thread.sleep(2000);

		driver.findElement(By.name("code")).clear();
		driver.findElement(By.name("code")).sendKeys("5");
		Thread.sleep(2000);

		// select parent department

		Select parent_dept = new Select(driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/form/div[1]/div[3]/div/select")));
		parent_dept.selectByVisibleText("B");

		driver.findElement(By.id("textArea")).sendKeys("This is b1 department");
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/form/div[3]/button"))
				.click();
		Thread.sleep(3000);

		// delete B dept

		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/div[2]/div[3]/div/div/ul/li[3]/h4/span/span/i"))
				.click();

		// alert gettext massage

		String text111 = driver.switchTo().alert().getText();
		System.out.println(text111);

		// alert accept
		driver.switchTo().alert().accept();

		// delete b1
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/div[2]/div[3]/div/div/ul/li[3]/h4/span/span/i"))
				.click();

		driver.switchTo().alert();

		// alert accept
		driver.switchTo().alert().accept();
		Thread.sleep(1000);

	}

	// --------------------------------------------------Enter C,D,E
	// department----------------------------------------------------------//

	@Test(priority = 21)

	public void dept_c_dept() throws InterruptedException {
		// real value
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/div[2]/a/button"))
				.click();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.name("dept_name")).clear();
		driver.findElement(By.name("dept_name")).sendKeys("C");
		Thread.sleep(2000);

		driver.findElement(By.name("code")).clear();
		driver.findElement(By.name("code")).sendKeys("04");
		Thread.sleep(2000);

		driver.findElement(By.id("textArea")).sendKeys("This is c department");
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/form/div[3]/button"))
				.click();
		Thread.sleep(2000);

		// D dept

		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/div[2]/a/button"))
				.click();
		Thread.sleep(1000);

		driver.findElement(By.name("dept_name")).clear();
		driver.findElement(By.name("dept_name")).sendKeys("D");
		Thread.sleep(2000);

		driver.findElement(By.name("code")).clear();
		driver.findElement(By.name("code")).sendKeys("5");
		Thread.sleep(2000);

		driver.findElement(By.id("textArea")).sendKeys("This is D department");
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/form/div[3]/button"))
				.click();
		Thread.sleep(2000);

		// E dept
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/div[2]/a/button"))
				.click();
		Thread.sleep(1000);

		driver.findElement(By.name("dept_name")).clear();
		driver.findElement(By.name("dept_name")).sendKeys("E");
		Thread.sleep(2000);

		driver.findElement(By.name("code")).clear();
		driver.findElement(By.name("code")).sendKeys("6");
		Thread.sleep(2000);

		driver.findElement(By.id("textArea")).sendKeys("This is E department");
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/form/div[3]/button"))
				.click();
		Thread.sleep(2000);

		// b dept
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/div[2]/a/button"))
				.click();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.name("dept_name")).clear();
		driver.findElement(By.name("dept_name")).sendKeys("B");
		Thread.sleep(2000);

		driver.findElement(By.name("code")).clear();
		driver.findElement(By.name("code")).sendKeys("08");
		Thread.sleep(2000);

		driver.findElement(By.id("textArea")).sendKeys("This is B department");
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/form/div[3]/button"))
				.click();
		Thread.sleep(4000);

	}

	// -------------------------------------Csv
	// download---------------------------------------------------------------------//

	@Test(priority = 22)
	public void dept_download() throws InterruptedException {
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div/div[2]/div[1]/button[2]"))
				.click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id=\"admin-step\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"admin-step\"]/ul/li[1]/a")).click();
		Thread.sleep(3000);
	}

}