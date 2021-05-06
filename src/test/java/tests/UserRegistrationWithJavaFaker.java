 package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithJavaFaker extends TestBase
{
		HomePage homeObject;
		UserRegistrationPage registerObject;
		LoginPage loginObject;
		
		Faker fakeData = new Faker();
		
		String fName = fakeData.name().firstName();
		String lName = fakeData.name().lastName();
		String email = fakeData.internet().emailAddress();
		String pw	 = fakeData.number().digits(8).toString();
		
		@Test(priority = 1 , alwaysRun = true)
		public void RegisterSuccessfully() throws InterruptedException
		{
			homeObject = new HomePage(driver);
			homeObject.openRegPage();
			
			registerObject = new UserRegistrationPage(driver);
			Thread.sleep(200);

			registerObject.userRegistration(fName, lName, "7" , "4", "1996", email, pw);
			System.out.println(fName + " , " + lName + " , " + email + " , " + pw );
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
			loginObject.userCanLogin(email, pw);
			Thread.sleep(200);
			Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
		}
}
