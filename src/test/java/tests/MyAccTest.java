package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccPage;
import pages.UserRegistrationPage;

public class MyAccTest extends TestBase{
	
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	MyAccPage myAccObject;
	String firstName = "Mahmoud";
	String lastName = "Adel";
	String email = "maxo9@yahoo.com";
	String oldPw = "123456";
	String newPw = "123456789";
	
	@Test(priority = 1)
	public void RegisterSuccessfully() throws InterruptedException
	{
		homeObject = new HomePage(driver);
		homeObject.openRegPage();
		
		registerObject = new UserRegistrationPage(driver);
		Thread.sleep(200);

		registerObject.userRegistration(firstName, lastName, "7" , "4", "1996", email, oldPw);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}
	
	
	@Test(priority = 2)
	public void registredUserCanChangePw()
	{
		myAccObject = new MyAccPage(driver);
		registerObject.openMyAccPage();
		myAccObject.changePwPage();
		myAccObject.changePassword(oldPw, newPw);
		Assert.assertTrue(myAccObject.result.getText().contains("Password was changed"));
		myAccObject.closeResultAfterChange();
	}
	
	
	@Test(priority = 3)
	public void userCanLogout() throws InterruptedException
	{
		Thread.sleep(400);
		registerObject.userLogout();
	}
	
	@Test(priority = 4)
	public void userCanLogin() throws InterruptedException
	{
		Thread.sleep(400);
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		Thread.sleep(500);
		loginObject.userCanLogin(email, newPw);
		Thread.sleep(200);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
	}

}
