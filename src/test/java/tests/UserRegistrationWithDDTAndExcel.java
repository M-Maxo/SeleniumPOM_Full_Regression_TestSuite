package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTAndExcel extends TestBase
{
		HomePage homeObject;
		UserRegistrationPage registerObject;
		LoginPage loginObject;
		
		
		@DataProvider(name = "ExcelData")
		public Object[][] userRegisterData() throws IOException
		{
			// get data from Excel reader class
			ExcelReader ER = new ExcelReader();
			return ER.getExcelData();
		}
		
		@Test(priority = 1 , alwaysRun = true , dataProvider = "ExcelData")
		public void RegisterSuccessfully(String fName , String lName , String email , String pw) throws InterruptedException
		{
			homeObject = new HomePage(driver);
			homeObject.openRegPage();
			
			registerObject = new UserRegistrationPage(driver);
			Thread.sleep(200);

			registerObject.userRegistration(fName, lName, "7" , "4", "1996", email, pw);
			Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
			registerObject.userLogout();
			Thread.sleep(200);
			homeObject.openLoginPage();
			loginObject = new LoginPage(driver);
			Thread.sleep(500);
			loginObject.userCanLogin(email, pw);
			Thread.sleep(200);
			Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
			registerObject.userLogout();
		}
}
