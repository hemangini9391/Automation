package src;

//import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


public class position extends Browser_launch_signup {

	


	// -------------------------------------------Admin----------------------------------------------------------//

	@Test(priority = 12)

	public void admin() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[4]/div/div/div[2]/div[3]/div/div[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"admin-step\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"admin-step\"]/ul/li[1]/a")).click();

	}

	// -----------------------------------------------Enter into
	// position----------------------------------------------//

	@Test(priority = 13)

	public void position1() throws InterruptedException {

		// click on position
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/div/div[3]/div/div[1]/span/a"))
				.click();
		Thread.sleep(2000);

		// enter value in search box

		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div[1]/div/input"))
				.sendKeys("testing");
		Thread.sleep(1000);

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
	}

	// --------------------------------check validation
	// -----------------------------------//

	// check validation without adding any position value
	@Test(priority = 14)

	public void submit() throws InterruptedException {
		// click on add symbol

		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div[2]/div/button"))
				.click();
		Thread.sleep(1000);

		// click on submit and check validation
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[4]/button")).click();

		// validation for position name
		String val1 = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[1]/div/span[1]/span"))
				.getText();
		String rval1 = "Position name is required";
		Assert.assertEquals(val1, rval1);

		// validation for postion code

		String val2 = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[2]/div/span[1]/span"))
				.getText();
		String rval2 = "Position Code is required";
		Assert.assertEquals(val2, rval2);
		Thread.sleep(1000);

	}

	// -------------check validation when add only position
	// name------------------------------------------------//
	@Test(priority = 15)

	public void enter_only_position() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[1]/div/input")).sendKeys("a");

		// click on submit and check validation
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[4]/button")).click();
		Thread.sleep(1000);

		// validation for position code

		String val3 = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[2]/div/span[1]/span"))
				.getText();
		String rval3 = "Position Code is required";
		Assert.assertEquals(val3, rval3);

		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[1]/div/input")).clear();

	}
	//// -------------check validation when add only position
	//// name------------------------------------------------//

	@Test(priority = 16)

	public void enter_only_positioncode() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[2]/div/input")).sendKeys("02");

		// click on submit and check validation
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[4]/button")).click();
		Thread.sleep(1000);

		// validation for position name
		String val4 = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[1]/div/span[1]/span"))
				.getText();
		String rval4 = "Position name is required";
		Assert.assertEquals(val4, rval4);

		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[2]/div/input")).clear();
	}

	// ----------------------------check validation when add same
	// value------------------------------------------------//

	@Test(priority = 17)

	public void add_samevalue_position() throws InterruptedException {
		// code value
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[2]/div/input")).sendKeys("01");
		// name value
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[1]/div/input"))
				.sendKeys("unassigned");

		// click on submit and check validation
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[4]/button")).click();
		Thread.sleep(1000);

		// validation for position name
		String val5 = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[1]/div/span[2]"))
				.getText();
		String rval5 = "Name already exists.";
		Assert.assertEquals(val5, rval5);

		// validation for position code

		String val6 = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[2]/div/span[2]"))
				.getText();
		String rval6 = "Position Code already exists.";
		Assert.assertEquals(val6, rval6);

		// clear added value and add new one

		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[2]/div/input")).clear();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[1]/div/input")).clear();

		// code value
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[2]/div/input")).sendKeys("1");
		// name value
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[1]/div/input")).sendKeys("a");

		// select parent department

		Select parent_dept = new Select(
				driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[3]/div/select")));
		parent_dept.selectByVisibleText("unassigned");

		// click on submit
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[4]/button")).click();
		Thread.sleep(1000);

		// verify alert message
		String alert_position_message = driver.findElement(By.className("alertOut")).getText();
		String real_alert_position_message = "×\r\n" + "Position created successfully";
		System.out.println(real_alert_position_message);

		Assert.assertEquals(alert_position_message, real_alert_position_message);
	}

	// -----------------------------------delete
	// position---------------------------------------------------//

	@Test(priority = 18)

	public void delete_position() throws InterruptedException {
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div[1]/a"))
				.click();
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div[2]/div/table/tbody/tr[2]/td[4]/span/i"))
				.click();

		// alert accept
		driver.switchTo().alert().accept();
		Thread.sleep(1000);

		// verify alert message

		String alert_position_message1 = driver.findElement(By.className("alertOut")).getText();
		String real_alert_position_message1 = "×\r\n" + "Position created successfully";
		System.out.println(real_alert_position_message1);
		Assert.assertEquals(alert_position_message1, real_alert_position_message1);

	}

	// ----------------------------------------------add real
	// position-------------------------------------------//
	@Test(priority = 19)

	public void real_position() throws InterruptedException {
		// a position
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div[1]/a"))
				.click();

		// click on add symbol
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div[2]/div/button"))
				.click();
		Thread.sleep(1000);

		// code value
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[2]/div/input")).sendKeys("1");
		// name value
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[1]/div/input")).sendKeys("a");

		// click on submit
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[4]/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div[1]/a"))
				.click();

		// b position
		// click on add symbol
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div[2]/div/button"))
				.click();
		Thread.sleep(1000);

		// code value
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[2]/div/input")).sendKeys("2");
		// name value
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[1]/div/input")).sendKeys("b");

		// click on submit
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[4]/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div[1]/a"))
				.click();

		// c position

		// click on add symbol
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div[2]/div/button"))
				.click();
		Thread.sleep(1000);

		// code value
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[2]/div/input")).sendKeys("3");
		// name value
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[1]/div/input")).sendKeys("c");

		// click on submit
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[4]/button")).click();
		Thread.sleep(1000);

		// d position
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div[1]/a"))
				.click();
		// click on add symbol
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div[2]/div/button"))
				.click();
		Thread.sleep(1000);

		// code value
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[2]/div/input")).sendKeys("4");
		// name value
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[1]/div/input")).sendKeys("d");

		// click on submit
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[4]/button")).click();
		Thread.sleep(2000);

		// e position

		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div[1]/a"))
				.click();
		// click on add symbol
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div[2]/div/button"))
				.click();
		Thread.sleep(1000);

		// code value
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[2]/div/input")).sendKeys("5");
		// name value
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[1]/div/input")).sendKeys("e");

		// click on submit
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[4]/button")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div[1]/a"))
				.click();

		// -------------------------------check validation while
		// editing-------------------------------------------------//
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/div/div/div[2]/div/table/tbody/tr[6]/td[2]/a"))
				.click();
		Thread.sleep(2000);

		// name
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[1]/div/input")).clear();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[1]/div/input")).sendKeys("d");
		Thread.sleep(1000);

		// code
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[2]/div/input")).clear();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[2]/div/input")).sendKeys("4");
		Thread.sleep(1000);

		// click on submit
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[4]/button")).click();
		Thread.sleep(2000);

		// validation for position name
		String val7 = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[1]/div/span[2]"))
				.getText();
		String rval7 = "Name already exists.";
		Assert.assertEquals(val7, rval7);

		// validation for position code

		String val8 = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[2]/div/span[2]"))
				.getText();
		String rval8 = "Position Code already exists.";
		Assert.assertEquals(val8, rval8);
		Thread.sleep(1000);

		// clear both value

		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[1]/div/input")).clear();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[2]/div/input")).clear();

		// code value
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[2]/div/input")).sendKeys("5");
		// name value
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[1]/div/input")).sendKeys("e");

		// click on submit
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[4]/button")).click();
		Thread.sleep(2000);

	}
}
