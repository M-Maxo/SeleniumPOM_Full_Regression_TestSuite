package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase
{
		HomePage homeObject;
		UserRegistrationPage registerObject;
		LoginPage loginObject;
		
		@Test(priority = 1 , alwaysRun = true)
		public void RegisterSuccessfully() throws InterruptedException
		{
			homeObject = new HomePage(driver);
			homeObject.openRegPage();
			
			registerObject = new UserRegistrationPage(driver);
			Thread.sleep(200);

			registerObject.userRegistration("daaa", "aadass", "7" , "4", "1996", "ma7654321oss@yahoo.com", "123456789");
			Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		}
		
		@Test(dependsOnMethods = {"RegisterSuccessfully"})
		public void userCanLogout() throws InterruptedException
		{
			registerObject.userLogout();
		}
		
		@Test(dependsOnMethods = {"userCanLogout"})
		public void userCanLogin() throws InterruptedException
		{
			Thread.sleep(200);
			homeObject.openLoginPage();
			loginObject = new LoginPage(driver);
			Thread.sleep(500);
			loginObject.userCanLogin("ma7654321oss@yahoo.com", "123456789");
			Thread.sleep(200);
			Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
		}
}
