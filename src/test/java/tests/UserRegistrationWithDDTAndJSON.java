package tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import data.JsonDataReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTAndJSON extends TestBase
{
		HomePage homeObject;
		UserRegistrationPage registerObject;
		LoginPage loginObject;
		
		
		@Test(priority = 1 , alwaysRun = true)
		public void RegisterSuccessfully() throws InterruptedException, FileNotFoundException, IOException, ParseException
		{
			JsonDataReader jsonReader = new JsonDataReader();
			jsonReader.JsonReader();
			
			homeObject = new HomePage(driver);
			homeObject.openRegPage();
			
			registerObject = new UserRegistrationPage(driver);
			Thread.sleep(200);

			registerObject.userRegistration(jsonReader.firstname, jsonReader.lastname, "7" , "4", "1996", jsonReader.email, jsonReader.password);
			Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
			Thread.sleep(200);
			registerObject.userLogout();
			Thread.sleep(200);
			homeObject.openLoginPage();
			loginObject = new LoginPage(driver);
			Thread.sleep(500);
			loginObject.userCanLogin(jsonReader.email, jsonReader.password);
			Thread.sleep(200);
			Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
			registerObject.userLogout();
		}
		
}
