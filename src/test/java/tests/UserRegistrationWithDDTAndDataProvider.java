package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTAndDataProvider extends TestBase
{
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;


	@DataProvider(name = "testData")
	public static Object[][] userData()
	{
		return new Object[][]{ {"Maged" , "Adel" , "Max00000@yahoo.com" , "123456789"},
			{"Ahmed" , "Ali" , "Testuser000@gmil.com" , "147896321" } 
		};
	}

	@Test(priority = 1 , alwaysRun = true , dataProvider = "testData")
	public void RegisterSuccessfully(String fn , String ln , String email , String pw) 
			throws InterruptedException
	{
		homeObject = new HomePage(driver);
		homeObject.openRegPage();

		registerObject = new UserRegistrationPage(driver);
		Thread.sleep(200);
		registerObject.userRegistration(fn, ln, "7" , "4", "1996", email, pw);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		registerObject.userLogout();
		
		Thread.sleep(200);
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		Thread.sleep(500);
		loginObject.userCanLogin(email, pw);
		Thread.sleep(200);
		registerObject.userLogout();
	}

}
