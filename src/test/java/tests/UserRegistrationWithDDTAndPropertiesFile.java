package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.LoadProperties;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTAndPropertiesFile extends TestBase
{
		HomePage homeObject;
		UserRegistrationPage registerObject;
		LoginPage loginObject;
		
		String fName = LoadProperties.userData.getProperty("firstname");
		String lName = LoadProperties.userData.getProperty("lastname");
		String eMail = LoadProperties.userData.getProperty("email");
		String pw    = LoadProperties.userData.getProperty("password");
		
		
		
		@Test(priority = 1 , alwaysRun = true)
		public void RegisterSuccessfully() throws InterruptedException
		{
			homeObject = new HomePage(driver);
			homeObject.openRegPage();
			
			registerObject = new UserRegistrationPage(driver);
			Thread.sleep(200);

			registerObject.userRegistration(fName, lName, "7" , "4", "1996", eMail, pw);
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
			loginObject.userCanLogin(eMail, pw);
			Thread.sleep(200);
			Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
		}
}
