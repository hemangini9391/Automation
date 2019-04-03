package src;

import java.awt.AWTException;
import java.awt.Robot;
//import java.awt.event.KeyEvent;
import java.util.Random;
//import java.util.List;
import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class User_registration extends Browser_launch_signup {
	Robot robot;

	// -------------------------------------------Admin----------------------------------------------------------//

	@Test(priority = 12)

	public void admin() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[4]/div/div/div[2]/div[3]/div/div[1]/a")).click();
		driver.findElement(By.id("admin-step")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"admin-step\"]/ul/li[1]/a")).click();
		Thread.sleep(1000);
		// click on user registration
		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/div/div[4]/div/div[1]/span/a"))
				.click();

	}

	@Test(priority = 13)

	public void User_submit() throws InterruptedException {

		// click on add user
		driver.findElement(
				By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/button"))
				.click();
		Thread.sleep(2000);

		// click on submit
		driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[15]/button[1]")).submit();
		Thread.sleep(1000);

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
		Thread.sleep(2000);

		// checkbox validation
		driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[9]/div[1]/div/label/span[1]/span")).click();
		String checkbox_validation = driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[9]/span"))
				.getText();
		String real_validation = "Select Any of checkbox";
		Assert.assertEquals(checkbox_validation, real_validation);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[9]/div[1]/div/label/span[1]/span")).click();

		// slack member id validation
		String[] slack = { "UCWXU6", "testtestt", "123456789" };

		for (int i = 0; i <= slack.length; i++) {

			if (i == 2) {
				driver.findElement(By.name("slack_member_id")).sendKeys(slack[i]);
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[15]/button[1]")).submit();
				Thread.sleep(1000);
				String slack_msg1 = driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[7]/div/span[1]"))
						.getText();
				String slack_real2 = "Slack Member ID is Invalid";
				Assert.assertEquals(slack_msg1, slack_real2);
				driver.findElement(By.name("slack_member_id")).clear();
				Thread.sleep(2000);

				driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[15]/button[2]")).click();
				Thread.sleep(2000);

			}

			driver.findElement(By.name("slack_member_id")).sendKeys(slack[i]);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[15]/button[1]")).submit();
			Thread.sleep(1000);
			String slack_msg = driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[7]/div/span[1]"))
					.getText();
			String slack_real = "Slack Member ID is Invalid";
			Assert.assertEquals(slack_msg, slack_real);
			driver.findElement(By.name("slack_member_id")).clear();

		}
	}

	@Test(priority = 14)
	public void user() throws InterruptedException, AWTException {
		String lastname = "patel";
		String[] Firstname = { "Milind", "Bhavik", "karan" };
		String[] Employeeid = { "m1", "b1", "k1" };
		String[] User = { "milinnd", "bhavik", "karran" };
		String Slackid = "UCW2MFXU6";

		// array lenth
		int ilength = Firstname.length;
		String test = Firstname[ilength - 1];
		System.out.println(test);

		for (int i = 0; i <= Firstname.length; i++) {

			// click on add user
			driver.findElement(
					By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/button"))
					.click();
			Thread.sleep(3000);

			// last name
			driver.findElement(By.name("last_name")).sendKeys(lastname);
			Thread.sleep(2000);

			// first name
			driver.findElement(By.name("first_name")).sendKeys(Firstname[i]);
			Thread.sleep(2000);

			// employeeid
			driver.findElement(By.id("m_user_login_employeeid")).sendKeys(Employeeid[i]);
			Thread.sleep(2000);

			// slackid

			if (i == 0) {
				driver.findElement(By.name("slack_member_id")).sendKeys(Slackid);
			}

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

			// click on checkbox
			driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[9]/div[2]/div/label/span[1]/span")).click();
			Thread.sleep(2000);

			// condition for last user click on checkbox (Travel expense and workflow)
			if (i == Firstname.length - 1)

			{
				// click on submit
				driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[15]/button[1]")).submit();

				// verifed messsage
				String actual = driver.findElement(By.className("alert-warning")).getText();
				System.out.println(actual);
				String expected = "×\n" + "You need to upgrade your package. Click here to upgrade your package.";
				Assert.assertEquals(actual, expected);

				// after deselect click on submit
				driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[9]/div[2]/div/label/span[1]/span"))
						.click();

				driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[15]/button[1]")).submit();

			}

			// click on submit
			driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[15]/button[1]")).submit();
			String user_alert = driver.findElement(By.className("alertOut")).getText();
			String user_alert_real = "×\n" + "User created successfully";
			Assert.assertEquals(user_alert, user_alert_real);
			Thread.sleep(6000);

		}
	}

	@Test(priority = 15)
	public void test() throws InterruptedException {
		// click on add user
		driver.findElement(
				By.xpath("//*[@id=\"wrapper\"]/div[5]/div[2]/div/section/div/div/aside/div/ui-view/ui-view/button"))
				.click();
		Thread.sleep(3000);

		// email
		driver.findElement(By.id("m_user_login_email")).sendKeys("chandni38@yopmail.com");
		Thread.sleep(2000);

		String exist_email = driver.findElement(By.id("id=\"m_user_login_email-error\"")).getText();
		String real_exist_email = "Email already registerd.";
		Assert.assertEquals(exist_email, real_exist_email);

		// slack

		driver.findElement(By.name("slack_member_id")).sendKeys("UCW2MFXU6");
		Thread.sleep(2000);
		String slack_exist1 = driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[7]/div/span[1]"))
				.getText();
		String slack_exist = "Slack Member ID already been registerd";
		Assert.assertEquals(slack_exist1, slack_exist);

		// click on cancel
		driver.findElement(By.xpath("//*[@id=\"m_user_login\"]/div/div[15]/button[2]")).click();
		Thread.sleep(2000);
	}

}
